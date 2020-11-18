package com.boil.service.impl;

import com.boil.entity.message.LovelyCatBean;
import com.boil.service.LovelyCatService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public String getLoggedAccountList()
    {
        return null;
    }

    @Override
    public String sendGroupAtMsg(String toWxId, String atWxId, String atName, String msg)
    {
        return null;
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
