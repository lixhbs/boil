package com.boil.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.boil.common.LovelyCatMessageUtils;
import com.boil.entity.message.LovelyCatBean;
import com.boil.service.LovelyCatService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

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
        HttpEntity<String> request = new HttpEntity<>(lovelyCatBean.toString());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://192.168.6.113:8073/send", request, String.class);
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
        lovelyCatBean.setMsg(msg);
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
    public String getGroupMemberList(String groupWxId, String isRefresh)
    {
        return null;
    }


}
