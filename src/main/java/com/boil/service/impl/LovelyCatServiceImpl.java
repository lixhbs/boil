package com.boil.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.entity.message.LovelyCatBean;
import com.boil.service.LovelyCatService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-16 15:36
 */
@Service
public class LovelyCatServiceImpl implements LovelyCatService
{

    @Override
    public String sendMsg(LovelyCatBean lovelyCatBean)
    {
        try
        {
            JSONObject jsonObject = new JSONObject();
            HttpResponse<JsonNode> jsonResponse = Unirest.post("http://192.168.6.113:8073/send")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("data", lovelyCatBean.toString())
                    .asJson();
            return jsonResponse.getBody().toString();
        } catch (UnirestException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONArray getLoggedAccountList()
    {
        LovelyCatBean lovelyCatBean = new LovelyCatBean();
        lovelyCatBean.setType("203");
        String res = sendMsg(lovelyCatBean);
        try
        {
            JSONArray jsonArray = LovelyCatMessageUtils.stringToJsonArray(res);
            if (jsonArray != null){
                return jsonArray;
            }
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public String sendGroupAtMsg(String robot, String toWxId, String atWxId, String atName, String msg)
    {
        LovelyCatBean lovelyCatBean = new LovelyCatBean();
        lovelyCatBean.setType(LovelyCatMessageUtils.TYPE_GROUP_AT);
        try
        {
            lovelyCatBean.setMsg(URLEncoder.encode(msg, "UTF-8"));
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        lovelyCatBean.setRobot_wxid(robot);
        lovelyCatBean.setTo_wxid(toWxId);
        lovelyCatBean.setAt_wxid(atWxId);
        lovelyCatBean.setAt_name(atName);
        return sendMsg(lovelyCatBean);
    }

    @Override
    public String getGroupList(String isRefresh)
    {
        return null;
    }

    @Override
    public String getGroupMemberList(String robWxId, String groupWxId, String isRefresh)
    {
        LovelyCatBean lovelyCatBean = new LovelyCatBean();
        lovelyCatBean.setType(LovelyCatMessageUtils.TYPE_GROUP_MEMBER_LIST);
        lovelyCatBean.setRobot_wxid(robWxId);
        lovelyCatBean.setGroup_wxid(groupWxId);
        lovelyCatBean.setIs_refresh(isRefresh);
        return sendMsg(lovelyCatBean);
    }

    @Override
    public String modifyGroupNotice(String robotWxId, String groupNum, String notice)
    {
        LovelyCatBean lovelyCatBean = new LovelyCatBean();
        lovelyCatBean.setType(LovelyCatMessageUtils.TYPE_MODIFY_GROUP_NOTICE);
        lovelyCatBean.setRobot_wxid(robotWxId);
        lovelyCatBean.setGroup_wxid(groupNum);
        lovelyCatBean.setNotice(notice);
        return sendMsg(lovelyCatBean);
    }


}
