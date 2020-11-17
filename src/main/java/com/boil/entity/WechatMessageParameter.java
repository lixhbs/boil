package com.boil.entity;

import java.util.Date;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 10:50
 */
public class WechatMessageParameter
{
    /**
     * 发送人              sender
     * 发送人WechatId      sender_id
     * 指定人              assigner
     * 指定人WechatId      assigner_id
     * 日期                date
     * 指令                order
     * 原文本              msg
     * 群号                group_id
     * 事件类型             type  100私聊  200 群聊
     * 内容                content
     * 来源               source  就是如果这条数据如果要回复那应该发送给谁，比如群聊里面应该发送给群 而不是发送者（这里可以艾特发送者）
     */

    String sender;
    String senderId;
    String assigner;
    String assignerId;
    Date date;
    String order;
    String msg;
    String groupId;
    String type;
    String content;
    String source;

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getSenderId()
    {
        return senderId;
    }

    public void setSenderId(String senderId)
    {
        this.senderId = senderId;
    }

    public String getAssigner()
    {
        return assigner;
    }

    public void setAssigner(String assigner)
    {
        this.assigner = assigner;
    }

    public String getAssignerId()
    {
        return assignerId;
    }

    public void setAssignerId(String assignerId)
    {
        this.assignerId = assignerId;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }
}
