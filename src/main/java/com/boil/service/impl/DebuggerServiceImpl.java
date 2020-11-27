package com.boil.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boil.common.BoilUtil;
import com.boil.common.DebuggerOrder;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.dao.*;
import com.boil.entity.WechatMessageParameter;
import com.boil.entity.bo.GroupMemberBO;
import com.boil.entity.model.*;
import com.boil.manager.ResultTemplate;
import com.boil.manager.impl.ResultTemplateImpl;
import com.boil.manager.RobotManager;
import com.boil.manager.TaskManager;
import com.boil.manager.TimedTaskManager;
import com.boil.service.DebuggerService;
import com.boil.service.LovelyCatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    @Autowired
    private UseraccountMapper useraccountMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private TaskManager taskManager;

    @Autowired
    private TimedTaskManager timedTaskManager;

    @Autowired
    private RobotManager robotManager;

    @Autowired
    private ResultTemplate resultTemplate;

    private static String ROBOT_WXID = "";

    private static String GROUP_ID = "";

    @Override
    public String debuggerHelp()
    {
        return " ── HELP ──\n" +
                "命令和内容中间要加一个空格\n" +
                "#任务 发布任务，可以指定时间，默认是当天。 \n" +
                "\n\t\t\t\t『群聊』指定返送人\n" +
                "如：#任务 @陈伟杰 【CAFP】任务内容 2020-11-19\n" +
                "解释：<指令> <执行人> <项目代码（可以发送#项目代码 查看）> <任务内容> [时间（默认当天）]\n" +
                "\n\t\t\t\t『私聊』默认发送给自己 ，如：#任务 【CAFP】任务内容 2020-11-19\n" +
                "解释：<指令> <项目代码（可以发送#项目代码 查看）> <任务内容> [时间（默认当天）]\n" +
                "\n#待办『私聊』查询自己的待办任务\n" +
                "#完成『私聊』加上待办编号，此条待办标记完成 ，如：#完成 3 \n" +
//                "【#项目列表】『*』所有项目\n" +
                "#实名『私聊』修改昵称\n" +
                "##项目代码『*』查询项目代码\n" +
//                "【#未处理】显示自己没有修复的BUG\n" +
//                "【#认领-'BUG编码'】认领bug然后开始修复， 如：#认领-BTTEST0101002 \n" +
//                "【#解决-'BUG编码'】BUG修复完后在群中发送， 如：#解决-BTTEST0101002 \n" +
//                "--------------以下为测试人员指令-------------- \n" +
//                "【#未解决-'BUG编码'】 如：#未解决-BTTEST0101002 \n" +
//                "【#通过-'BUG编码'】   如：#通过-BTTEST0101002 \n" +
//                "【#挂起-'BUG编码'】   如：#挂起-BTTEST0101002 \n" +
//                "【#忽略-'BUG编码'】   如：#忽略-BTTEST0101002 \n" +
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
        String projectCode = wechatMessageParameter.getProjectCode();
        if (StringUtils.isEmpty(projectCode))
        {
            return "请输入项目代码，如： 【CAFP】，可以发送" + DebuggerOrder.PROJECT_CODE + " 查询";
        }
        String content = wechatMessageParameter.getContent();
        if (StringUtils.isEmpty(content))
        {
            return "任务内容为空！";
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
        task.setCreatedTime(LocalDateTime.now());
        task.setContent(content);

        List<Useraccount> userAccounts = taskManager.selectAccountByWxId(wechatMessageParameter.getSenderId());

        if (userAccounts != null && userAccounts.size() > 0)
        {
            task.setName(userAccounts.get(0).getName());
        } else {
            task.setName(wechatMessageParameter.getAssigner());
        }

        task.setProjectcode(wechatMessageParameter.getProjectCode());
        task.setReceiverWxid(wechatMessageParameter.getAssignerId());
        task.setStatus(0);
        int res = taskMapper.insert(task);
        if (res > -1){
            return "*记录成功* " + content;
        }
        return "*记录失败* " + content;
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
            LocalDate deadline = task.getDeadline();
            LocalDate now = LocalDate.now();
            int i = -1;
            String format = "";
            if (deadline != null)
            {
                i = deadline.compareTo(now);
                format = " - " + deadline.format(DateTimeFormatter.ISO_DATE);
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
    public String sendGroupAtMsg(String toWxId, String atWxId, String atName, String msg)
    {
        Robot robotInfo = robotManager.getRobotInfo();
        return lovelyCatService.sendGroupAtMsg(robotInfo.getWxid(), toWxId, atWxId, atName, msg);
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
        return createReport(DebuggerOrder.DAILY);
    }

    @Override
    public String weekly()
    {
        List<Timedtask> timedTasks = timedTaskManager.selectTimedTaskByName(DebuggerOrder.WEEKLY);
        Robot robotInfo = robotManager.getRobotInfo();
        String wxId = robotInfo.getWxid();

        for (Timedtask timedtask : timedTasks)
        {
            // 通过定时任务配置 获取是那个群，群里面的成员，和成员实名信息（如果没有实名就是默认获取昵称）
            String groupNum = timedtask.getGroupnum();
            GroupMemberBO groupMemberBO = robotManager.listMember(groupNum, wxId);
            HashMap<String, String> map = groupMemberBO.getMap();
            List<String> userList = groupMemberBO.getUserList();

            TaskExample taskExample = new TaskExample();
            TaskExample.Criteria criteria1 = taskExample.createCriteria();
            criteria1.andReceiverWxidIn(userList);
            List<LocalDate> mondayAndFriday = BoilUtil.getMondayAndFriday();
            criteria1.andDeadlineBetween(mondayAndFriday.get(0), mondayAndFriday.get(1));

            List<Task> tasks = taskMapper.selectByExample(taskExample);

            // 查询所有的项目
            ProjectExample projectExample = new ProjectExample();
            List<Project> projects = projectMapper.selectByExample(projectExample);
            Map<String, Project> admin = new HashMap<>(4);
            if(projects != null && projects.size() > 0)
            {
                projects.forEach(item -> admin.put(item.getProjectcode(), item));
            }

            if (tasks != null && tasks.size() > 0)
            {
                HashMap<String, String> weekReport = resultTemplate.createWeekReport(tasks, map, projects);
                weekReport.forEach((code, template) -> {
                    String administrator = admin.get(code).getAdministrator();
                    String projectName = admin.get(code).getProjectname();
                    template = " > 【"+projectName+"】\n" + template;
                    lovelyCatService.sendGroupAtMsg(wxId, groupNum, administrator, map.get(administrator), template);
                });
            }
        }

        return "";
    }

    @Override
    public String listProjectCode(WechatMessageParameter wechatMessageParameter)
    {
        ProjectExample projectExample = new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(projectExample);
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        if (projects != null && projects.size() > 0){
            projects.forEach((item) -> {
                stringBuilder.append(atomicInteger.getAndIncrement()).append("、 【").append(item.getProjectcode()).append("】 ").append(item.getProjectname()).append("\n");
            });
        }
        if(stringBuilder.length() == 0)
        {
            return "没有查询到数据。";
        }
        return stringBuilder.toString();
    }

    private String createReport(String daily)
    {
        // 查询日报的定时任务
        TimedtaskExample timedtaskExample = new TimedtaskExample();
        TimedtaskExample.Criteria criteria = timedtaskExample.createCriteria();
        criteria.andNameEqualTo(daily);

        List<Timedtask> timedTasks = timedtaskMapper.selectByExample(timedtaskExample);

        timedTasks.forEach((item) -> {
            pushReport(item, daily);
        });

        return "";
    }

    private void pushReport(Timedtask timedtask, String daily)
    {
        String taskType = daily.replace("#注册","");
        String groupnum = timedtask.getGroupnum();
        GROUP_ID = groupnum;

        // 根据群号 获取群里面的人员信息，然后去待办表里面查用户数据
        Robot robotInfo = robotManager.getRobotInfo();
        String robotWxId = robotInfo.getWxid();
        ROBOT_WXID = robotWxId;
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

            // 和用户表比 拿到实名的信息
            UseraccountExample useraccountExample = new UseraccountExample();
            UseraccountExample.Criteria userAccountCriteria = useraccountExample.createCriteria();
            userAccountCriteria.andWxidIn(strings);
            List<Useraccount> userAccounts = useraccountMapper.selectByExample(useraccountExample);
            if (userAccounts != null && userAccounts.size() > 0)
            {
                userAccounts.forEach((item) -> {
                    String wxid = item.getWxid();
                    if(stringStringHashMap.containsKey(wxid)){
                        stringStringHashMap.put(wxid, item.getName());
                    }
                });
            }

            TaskExample taskExample = new TaskExample();
            TaskExample.Criteria criteria1 = taskExample.createCriteria();
            criteria1.andReceiverWxidIn(strings);

            // 如果是周报就要周期查询
            if(DebuggerOrder.WEEKLY.equals(daily)) {
                List<LocalDate> mondayAndFriday = BoilUtil.getMondayAndFriday();
                criteria1.andDeadlineBetween(mondayAndFriday.get(0), mondayAndFriday.get(1));
            }

            List<Task> tasks = taskMapper.selectByExample(taskExample);
            if (tasks != null && tasks.size() > 0)
            {
                String notice = sortTasks(taskType, tasks, stringStringHashMap);
                lovelyCatService.modifyGroupNotice(robotWxId, groupnum, notice);
            }

        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public String verified(WechatMessageParameter wechatMessageParameter)
    {
        // 先查询 是否存在，不存在就新增
        List<Useraccount> userAccounts = taskManager.selectAccountByWxId(wechatMessageParameter.getSenderId());
        int res = 0;
        Useraccount useraccount = new Useraccount();
        String content = wechatMessageParameter.getContent();
        useraccount.setName(content);
        if (userAccounts != null && userAccounts.size() > 0)
        {
            useraccount.setId(userAccounts.get(0).getId());
            useraccount.setUpdatedTime(LocalDateTime.now());
            useraccount.setUpdatedBy(content);
            res = useraccountMapper.updateByPrimaryKey(useraccount);
        } else
        {
            useraccount.setCreatedTime(LocalDateTime.now());
            useraccount.setCreatedBy(content);
            res = useraccountMapper.insert(useraccount);
        }

        return res > 0 ? "实名成功" : "实名失败";
    }



    private String sortTasks(String taskType, List<Task> tasks, HashMap<String, String> stringStringHashMap)
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

        return createTemplate(taskType, taskSize, taskInfoListHashMap);
    }

    private String createTemplate(String taskType, int taskSize, HashMap<String, List<Task>> taskInfoListHashMap)
    {
        StringBuilder stringBuilder = new StringBuilder();

        String title = LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " +taskType;
        if (DebuggerOrder.WEEKLY.indexOf(taskType) > 0) {
            List<LocalDate> mondayAndFriday = BoilUtil.getMondayAndFriday();
            int weeksNum = BoilUtil.getWeeksNum();
            LocalDate localDate = mondayAndFriday.get(0);
            LocalDate localDate1 = mondayAndFriday.get(1);
            title = "第" + weeksNum + "周 " + localDate.toString() + " ~ " + localDate1.getMonthValue() + "-" + localDate1.getDayOfMonth();
        }
        stringBuilder.append(" --- ")
                .append(title)
                .append(" ---\n");
        stringBuilder.append("总任务数量：").append(taskSize).append("\n");



        taskInfoListHashMap.forEach((name, list) -> {
            StringBuilder taskInfos = new StringBuilder();
            taskInfos.append("\n > ").append(name).append("\n");
            AtomicInteger index = new AtomicInteger(1);
            AtomicInteger overtimeCount = new AtomicInteger();
            AtomicInteger tadyCount = new AtomicInteger();
            list.forEach((task) -> {
                LocalDate deadline = task.getDeadline();
                Integer status = task.getStatus();


                LocalDate now = LocalDate.now();
                int i = -1;
                String format = "";
                if (deadline != null)
                {
                    i = deadline.compareTo(now);
                    format = " - " + deadline.format(DateTimeFormatter.ISO_DATE);
                }
                String overtime = "";
                if (status == 1){
                    overtime = "【完成】";
                } else {
                    if (i < 0){
                        overtime = "[叹气]【超时】";
                        overtimeCount.getAndIncrement();
                    }
                    if (i == 0){
                        overtime = "【今日任务】";
                        tadyCount.getAndIncrement();
                    }
                }
                taskInfos.append(index.getAndIncrement()).append("、").append(overtime).append(task.getContent()).append(format).append("\n");
            });
            stringBuilder.append(" > ").append(name).append(" - ").append("总任务：").append(list.size()).append(", 今日任务：").append(tadyCount).append(", 未完成：").append(overtimeCount.get() + tadyCount.get()).append(", 超时：").append(overtimeCount).append("\n");
        });
        stringBuilder.append("\n").append(" --- 详情 ---").append("\n");
//        stringBuilder.append(taskInfos);

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
