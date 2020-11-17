package com.boil.entity.message;

import java.io.Serializable;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 08:56
 */
public class BaseWeChatMessage implements Serializable
{
    private String ToUserName = "";
    private String FromUserName = "";
    private long CreateTime = 0L;
    private String MsgType = "";

    public String getToUserName()
    {
        return ToUserName;
    }

    public void setToUserName(String toUserName)
    {
        ToUserName = toUserName;
    }

    public String getFromUserName()
    {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName)
    {
        FromUserName = fromUserName;
    }

    public long getCreateTime()
    {
        return CreateTime;
    }

    public void setCreateTime(long createTime)
    {
        CreateTime = createTime;
    }

    public String getMsgType()
    {
        return MsgType;
    }

    public void setMsgType(String msgType)
    {
        MsgType = msgType;
    }
}
