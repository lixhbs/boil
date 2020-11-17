package com.boil.entity.message;

import java.io.Serializable;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 08:56
 */
public class ContentWechatMessage extends BaseWeChatMessage implements Serializable
{
    private String Content = "";

    public String getContent()
    {
        return Content;
    }

    public ContentWechatMessage (){

    }

    public ContentWechatMessage(String content){
        this.Content = content;
    }

    public void setContent(String content)
    {
        this.Content = content;
    }
}
