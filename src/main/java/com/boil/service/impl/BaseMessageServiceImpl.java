package com.boil.service.impl;

import com.boil.common.DebuggerOrder;
import com.boil.common.WechatMessageUtils;
import com.boil.entity.message.ContentWechatMessage;
import com.boil.service.BaseMessageService;
import com.boil.service.DebuggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 10:55
 */
@Service
public class BaseMessageServiceImpl implements BaseMessageService
{
    @Autowired
    private DebuggerService debuggerService;

    @Override
    public boolean checkWechatMessage()
    {
        // TODO

        return true;
    }

    @Override
    public Object processRequest(Map<String, String> map)
    {
        // 消息类型
        String msgType = map.get("MsgType");

        // 发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");

        String responseMessage = "";
        // 对消息进行处理
        // 文本消息
        if (WechatMessageUtils.MESSAGE_TEXT.equals(msgType)) {
            ContentWechatMessage contentWechatMessage = new ContentWechatMessage();
            contentWechatMessage.setMsgType(WechatMessageUtils.MESSAGE_TEXT);
            contentWechatMessage.setToUserName(fromUserName);
            contentWechatMessage.setFromUserName(toUserName);
            contentWechatMessage.setContent(map.get("Content"));
            contentWechatMessage.setCreateTime(System.currentTimeMillis());
            responseMessage = replyTextMessage(contentWechatMessage);
        }
        return responseMessage;
    }

    @Override
    public String replyTextMessage(ContentWechatMessage contentWechatMessage)
    {
        String content = contentWechatMessage.getContent();

        if (DebuggerOrder.HELP.equals(content)){
            content = debuggerService.debuggerHelp();
        }
        contentWechatMessage.setContent(content);
        return WechatMessageUtils.textMessageToXml(contentWechatMessage);
    }
}
