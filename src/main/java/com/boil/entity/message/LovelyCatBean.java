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
    String group_wxid = "";
    String is_refresh = "";
    String notice = "";

    public String getNotice()
    {
        return notice;
    }

    public void setNotice(String notice)
    {
        this.notice = notice;
    }

    public String getGroup_wxid()
    {
        return group_wxid;
    }

    public void setGroup_wxid(String group_wxid)
    {
        this.group_wxid = group_wxid;
    }

    public String getIs_refresh()
    {
        return is_refresh;
    }

    public void setIs_refresh(String is_refresh)
    {
        this.is_refresh = is_refresh;
    }

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
        // 这里需要优化 TODO
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
        if (StringUtils.isNotEmpty(this.group_wxid)){
            jsonObject.put("group_wxid", this.group_wxid);
        }
        if (StringUtils.isNotEmpty(this.is_refresh)){
            jsonObject.put("is_refresh", this.is_refresh);
        }
        if (StringUtils.isNotEmpty(this.notice)){
            jsonObject.put("notice", this.notice);
        }
        return jsonObject.toJSONString();
    }
}
