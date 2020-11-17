package com.boil.service.impl;

import com.boil.common.DebuggerOrder;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.common.WechatMessageUtils;
import com.boil.dao.TaskMapper;
import com.boil.entity.WechatMessageParameter;
import com.boil.model.Task;
import com.boil.model.TaskExample;
import com.boil.service.DebuggerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 17:43
 */
@Service
public class DebuggerServiceImpl implements DebuggerService
{

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public String debuggerHelp()
    {
        return " ── HELP ──\n" +
                "命令为'【】'内的文字，命令前必须为#\n" +
                "【#任务】 可以自定义完成日期，默认一天\n" +
                "\t\t\t\t『群聊』发送给艾特的那个人\n" +
                "\t\t\t\t『私聊』默认发送给自己\n" +
                "【#待办】『私聊』查询自己的待办任务\n" +
                "【#未处理】显示自己没有修复的BUG\n" +
                "【#认领-'BUG编码'】认领bug然后开始修复， 如：#认领-BTTEST0101002 \n" +
                "【#解决-'BUG编码'】BUG修复完后在群中发送， 如：#解决-BTTEST0101002 \n" +
                "--------------以下为测试人员指令-------------- \n" +
                "【#未解决-'BUG编码'】 如：#未解决-BTTEST0101002 \n" +
                "【#通过-'BUG编码'】   如：#通过-BTTEST0101002 \n" +
                "【#挂起-'BUG编码'】   如：#挂起-BTTEST0101002 \n" +
                "【#忽略-'BUG编码'】   如：#忽略-BTTEST0101002 \n" +
                " ── END ──";
    }

    @Override
    public String pushTask(WechatMessageParameter wechatMessageParameter)
    {
        String wxId = wechatMessageParameter.getAssignerId();
        if (StringUtils.isEmpty(wxId))
        {
            return "任务未指定执行人！";
        }
        return pushTaskExecute(wechatMessageParameter);
    }

    @Override
    public String pushTaskExecute(WechatMessageParameter wechatMessageParameter)
    {
        String content = wechatMessageParameter.getContent();
        Task task = new Task();
        task.setDeadline(wechatMessageParameter.getDate());
        task.setCreatedBy(wechatMessageParameter.getSender());
        task.setUntitled(wechatMessageParameter.getSenderId());
        task.setCreatedTime(new Date());
        task.setContent(content);
        task.setReceiverWxid(wechatMessageParameter.getAssignerId());
        task.setStatus(0);
        taskMapper.insert(task);
        return content + " - 任务已记录！";
    }

    @Override
    public String listTodo(WechatMessageParameter wechatMessageParameter)
    {
        String senderId = wechatMessageParameter.getSenderId();
        String content = wechatMessageParameter.getContent();
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andReceiverWxidEqualTo(senderId);
        int status = 0;
        if (StringUtils.isNotEmpty(content))
        {
            try
            {
                status = Integer.parseInt(content);
            } catch (Exception e)
            {
                return "查询条件有误！";
            }
        }
        criteria.andStatusEqualTo(status);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        StringBuilder stringBuilder = new StringBuilder();
        if (tasks.size() == 0)
        {
            return "未查询到！";
        }
        stringBuilder.append("── ").append(wechatMessageParameter.getOrder()).append(" ──\n");
        // "1、任务 - 2020-11-17 - 超时"
        String template = "No.{0}、{1}{2}{3}\n";

        for (Task task : tasks)
        {
            // 这里时间转换 需要优化 TODO
            Date deadline = task.getDeadline();
            int i = -1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = "";
            if (deadline != null)
            {
                i = deadline.compareTo(Date.from(LocalDate.parse(formatter.format(LocalDate.now()), formatter).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                format = " - " + simpleDateFormat.format(deadline);
            }
            stringBuilder.append(MessageFormat.format(template, task.getId(), (i > -1 ? "" : "【超时】"), task.getContent(), format));

        }
        stringBuilder.append("── END ──\n");

        return stringBuilder.toString();
    }

    public String todoStatus(WechatMessageParameter wechatMessageParameter, int status)
    {
        String content = wechatMessageParameter.getContent();
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        int id = 0;
        if (StringUtils.isNotEmpty(content))
        {
            try
            {
                id = Integer.parseInt(content);
            } catch (Exception e)
            {
                return "查询条件有误！";
            }
        }
        criteria.andIdEqualTo(id);
        criteria.andReceiverWxidEqualTo(wechatMessageParameter.getAssignerId());
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        if (tasks.size() == 0)
        {
            return "无此待办任务";
        }
        Task task = new Task();
        task.setStatus(status);
        int res = taskMapper.updateByExampleSelective(task, taskExample);
        if (res == 1) {
            return "状态修改成功！";
        }

        return "状态修改失败！";
    }

    @Override
    public String todoFinish(WechatMessageParameter wechatMessageParameter)
    {
        return todoStatus(wechatMessageParameter, 1);
    }
}
