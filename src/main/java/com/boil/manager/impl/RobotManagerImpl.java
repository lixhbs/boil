package com.boil.manager.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.dao.RobotMapper;
import com.boil.dao.UseraccountMapper;
import com.boil.entity.bo.GroupMemberBO;
import com.boil.entity.model.*;
import com.boil.manager.RobotManager;
import com.boil.service.LovelyCatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-21 14:36
 */
@Service
public class RobotManagerImpl implements RobotManager
{
    @Autowired
    private RobotMapper robotMapper;

    @Autowired
    private LovelyCatService lovelyCatService;

    @Autowired
    private UseraccountMapper useraccountMapper;

    @Override
    public GroupMemberBO listMember(String groupNum, String robotWxId)
    {
        // 根据群号 获取群里面的人员信息，然后去待办表里面查用户数据
        if (StringUtils.isEmpty(robotWxId))
        {
            Robot robotInfo = getRobotInfo();
            robotWxId = robotInfo.getWxid();
        }

        String groupMemberList = lovelyCatService.getGroupMemberList(robotWxId, groupNum, "1");
        List<String> strings = new ArrayList<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>(10);

        JSONArray jsonArray = null;
        try
        {
            jsonArray = LovelyCatMessageUtils.stringToJsonArray(groupMemberList);
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
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
        return new GroupMemberBO(strings, stringStringHashMap);
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
}
