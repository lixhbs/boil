package com.boil.entity.message;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-16 15:26
 */
public class LovelyCatBean
{
    String type = "";
    String msg = "";
    String to_wxid = "";
    String robot_wxid = "";
    String at_wxid = "";
    String at_name = "";
    String from_wxid = "";
    String key = "";

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getFrom_wxid()
    {
        return from_wxid;
    }

    public void setFrom_wxid(String from_wxid)
    {
        this.from_wxid = from_wxid;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getTo_wxid()
    {
        return to_wxid;
    }

    public void setTo_wxid(String to_wxid)
    {
        this.to_wxid = to_wxid;
    }

    public String getRobot_wxid()
    {
        return robot_wxid;
    }

    public void setRobot_wxid(String robot_wxid)
    {
        this.robot_wxid = robot_wxid;
    }

    public String getAt_wxid()
    {
        return at_wxid;
    }

    public void setAt_wxid(String at_wxid)
    {
        this.at_wxid = at_wxid;
    }

    public String getAt_name()
    {
        return at_name;
    }

    public void setAt_name(String at_name)
    {
        this.at_name = at_name;
    }

    @Override
    public String toString()
    {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotEmpty(this.type)){
            jsonObject.put("type", this.type);
        }
        if (StringUtils.isNotEmpty(this.msg)){
            jsonObject.put("msg", this.msg);
        }
        if (StringUtils.isNotEmpty(this.to_wxid)){
            jsonObject.put("to_wxid", this.to_wxid);
        }
        if (StringUtils.isNotEmpty(this.robot_wxid)){
            jsonObject.put("robot_wxid", this.robot_wxid);
        }
        if (StringUtils.isNotEmpty(this.from_wxid)){
            jsonObject.put("from_wxid", this.from_wxid);
        }
        if (StringUtils.isNotEmpty(this.at_name)){
            jsonObject.put("at_name", this.at_name);
        }
        if (StringUtils.isNotEmpty(this.at_wxid)){
            jsonObject.put("at_wxid", this.at_wxid);
        }
        if (StringUtils.isNotEmpty(this.key)){
            jsonObject.put("key", this.key);
        }
        return jsonObject.toJSONString();
    }
}
