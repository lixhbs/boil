package com.boil.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boil.common.DebuggerOrder;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.common.WechatMessageUtils;
import com.boil.dao.RobotMapper;
import com.boil.dao.TaskMapper;
import com.boil.dao.TimedtaskMapper;
import com.boil.entity.WechatMessageParameter;
import com.boil.model.*;
import com.boil.service.DebuggerService;
import com.boil.service.LovelyCatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Autowired
    private LovelyCatService lovelyCatService;

    @Autowired
    private RobotMapper robotMapper;

    @Autowired
    private TimedtaskMapper timedtaskMapper;

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
        if (res == 1)
        {
            return "状态修改成功！";
        }

        return "状态修改失败！";
    }

    @Override
    public String todoFinish(WechatMessageParameter wechatMessageParameter)
    {
        return todoStatus(wechatMessageParameter, 1);
    }

    @Override
    public boolean todoReport(String groupId)
    {

        return false;
    }

    @Override
    public Robot getRobotInfoSync()
    {
        JSONArray loggedAccountList = lovelyCatService.getLoggedAccountList();
        if (loggedAccountList == null)
        {
            throw new NullPointerException("未获取到机器人数据");
        }
        Robot robot = new Robot();
        JSONObject jsonObject = (JSONObject) loggedAccountList.get(0);
        robot.setWxid(jsonObject.getString("wxid"));
        robot.setWxNum(jsonObject.getString("wx_num"));
        robot.setHeadimgurl(jsonObject.getString("headimgurl"));
        robotMapper.insert(robot);
        return robot;
    }

    @Override
    public Robot getRobotInfo()
    {
        Robot robot = null;
        RobotExample robotExample = new RobotExample();
        List<Robot> robots = robotMapper.selectByExample(robotExample);
        if (robots == null || robots.size() == 0)
        {
            robot = getRobotInfoSync();
        } else
        {
            robot = robots.get(0);
        }
        return robot;
    }

    @Override
    public String sendGroupAtMsg(String toWxId, String atWxId, String atName, String msg)
    {
        Robot robotInfo = getRobotInfo();
        String res = lovelyCatService.sendGroupAtMsg(robotInfo.getWxid(), toWxId, atWxId, atName, msg);
        return res;
    }

    @Override
    public String registerDaily(WechatMessageParameter wechatMessageParameter)
    {
        if (StringUtils.isEmpty(wechatMessageParameter.getContent()) || DebuggerOrder.DAILY.equals(wechatMessageParameter.getMsg()))
        {
            wechatMessageParameter.setContent("1 2");
        }
        return registerTimedTask(wechatMessageParameter);
    }

    @Override
    public String registerWeekly(WechatMessageParameter wechatMessageParameter)
    {
        if (StringUtils.isEmpty(wechatMessageParameter.getContent()) || DebuggerOrder.WEEKLY.equals(wechatMessageParameter.getMsg()))
        {
            wechatMessageParameter.setContent("2 5");
        }
        return registerTimedTask(wechatMessageParameter);
    }

    @Override
    public String daily()
    {
        // 查询日报的定时任务
        TimedtaskExample timedtaskExample = new TimedtaskExample();
        TimedtaskExample.Criteria criteria = timedtaskExample.createCriteria();
        criteria.andNameEqualTo(DebuggerOrder.DAILY);

        List<Timedtask> timedtasks = timedtaskMapper.selectByExample(timedtaskExample);
        // 这里默认发第一个群

        Timedtask timedtask = timedtasks.get(0);
        String groupnum = timedtask.getGroupnum();

        // 根据群号 获取群里面的人员信息，然后去待办表里面查用户数据
        Robot robotInfo = getRobotInfo();
        String robotWxId = robotInfo.getWxid();
        String groupMemberList = lovelyCatService.getGroupMemberList(robotWxId, groupnum, "1");

        try
        {
            ArrayList<String> strings = new ArrayList<>();
            HashMap<String, String> stringStringHashMap = new HashMap<>(10);

            JSONArray jsonArray = LovelyCatMessageUtils.stringToJsonArray(groupMemberList);
            if (jsonArray != null && jsonArray.size() > 0){
                for (Object item : jsonArray)
                {
                    JSONObject jsonObject = (JSONObject) item;
                    String wxid = jsonObject.getString("wxid");
                    if (robotWxId.equals(wxid))
                    {
                        continue;
                    }
                    strings.add(wxid);
                    String nickname = jsonObject.getString("nickname");
                    stringStringHashMap.put(wxid, nickname);
                }
            }

            TaskExample taskExample = new TaskExample();
            TaskExample.Criteria criteria1 = taskExample.createCriteria();
            criteria1.andReceiverWxidIn(strings);
            criteria1.andStatusEqualTo(0);
            List<Task> tasks = taskMapper.selectByExample(taskExample);
            if (tasks != null && tasks.size() > 0)
            {
                String notice = sortTasks(tasks, stringStringHashMap);
                return lovelyCatService.modifyGroupNotice(robotWxId, groupnum, notice);
            }

        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return "";
    }

    private String sortTasks(List<Task> tasks, HashMap<String, String> stringStringHashMap)
    {
        // 任务总数
        int taskSize = tasks.size();

        HashMap<String, List<Task>> taskInfoListHashMap = new HashMap<>(10);

        for (Task task : tasks)
        {
            // 获取中文名称
            String cnName = stringStringHashMap.get(task.getReceiverWxid());

            // 任务内容 记录到任务表里面
            String content = task.getContent();
            List<Task> strings = taskInfoListHashMap.get(cnName);
            if ( strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(task);
            taskInfoListHashMap.put(cnName, strings);
        }

        return createTemplate(DebuggerOrder.DAILY, taskSize, taskInfoListHashMap);
    }

    private String createTemplate(String taskType, int taskSize, HashMap<String, List<Task>> taskInfoListHashMap)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" --- ").append(taskType).append("---\n");
        stringBuilder.append("总任务：").append(taskSize);

        return stringBuilder.toString();
    }

    /**
     * 注册定时任务
     *
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @author Lix.
     * @date 2020/11/18 18:06
     */
    String registerTimedTask(WechatMessageParameter wechatMessageParameter)
    {
        String groupId = wechatMessageParameter.getGroupId();
        String order = wechatMessageParameter.getOrder();

        Timedtask timedtask = new Timedtask();
        timedtask.setGroupnum(groupId);
        String msg = wechatMessageParameter.getContent();
        timedtask.setName(order);
        String[] taskOrder = msg.split(" ");
        if (taskOrder.length < 2)
        {
            return "指令参数有误！【" + DebuggerOrder.DAILY + " 1 2 / " + DebuggerOrder.WEEKLY + " 2 5】";
        }
        timedtask.setCycletype(Integer.parseInt(taskOrder[0]));
        if (DebuggerOrder.DAILY.equals(wechatMessageParameter.getOrder()))
        {
            timedtask.setDatetype(Integer.parseInt(taskOrder[1]));
        }
        if (DebuggerOrder.WEEKLY.equals(wechatMessageParameter.getOrder()))
        {
            timedtask.setSomeday(Integer.parseInt(taskOrder[1]));
        }
        TimedtaskExample timedtaskExample = new TimedtaskExample();
        TimedtaskExample.Criteria criteria = timedtaskExample.createCriteria();
        criteria.andGroupnumEqualTo(groupId);
        criteria.andNameEqualTo(order);

        List<Timedtask> timedTasks = timedtaskMapper.selectByExample(timedtaskExample);
        int insert = 0;
        if (timedTasks != null && timedTasks.size() > 0)
        {
            Timedtask timedTask1 = timedTasks.get(0);
            Integer id = timedTask1.getId();
            timedtask.setId(id);
            insert = timedtaskMapper.updateByPrimaryKey(timedtask);
        } else
        {
            insert = timedtaskMapper.insert(timedtask);
        }

        if (insert > 0)
        {
            return "定时任务注册成功！";
        }

        return "定时任务注册失败！";
    }

}
