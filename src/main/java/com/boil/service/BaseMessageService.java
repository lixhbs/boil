package com.boil.service;

import com.boil.entity.message.ContentWechatMessage;

import java.util.Map;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 10:48
 */
public interface BaseMessageService
{
    /**
     * 判断是否是微信过来的
     * @author Lix.
     * @return boolean
     * @date 2020/11/10 10:49
     */
    boolean checkWechatMessage();

    /**
     * 根据微信MsgType 转发到对应的业务
     * @author Lix.
     * @param map 微信接口发的消息
     * @return Object
     * @date 2020/11/10 10:53
     */
    Object processRequest(Map<String, String> map);

    /**
     * 被动回复文本消息
     * @author Lix.
     * @param contentWechatMessage 接受到微信传回的消息
     * @return Object
     * @date 2020/11/10 11:44
     */
    Object replyTextMessage(ContentWechatMessage contentWechatMessage);
}
