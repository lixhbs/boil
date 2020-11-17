package com.boil.service.impl;

import com.boil.common.DebuggerOrder;
import com.boil.entity.message.LovelyCatBean;
import com.boil.service.DebuggerService;
import com.boil.service.LovelyCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private DebuggerService debuggerService;

    @Override
    public String sendMsg(LovelyCatBean lovelyCatBean)
    {
        HttpEntity<String> request = new HttpEntity<>(lovelyCatBean.toString());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://192.168.6.113:8073/send", request, String.class);
    }
}
