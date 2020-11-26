package com.boil.entity.bo;

import java.util.HashMap;
import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-21 14:40
 */
public class GroupMemberBO
{
    private List<String> userList;
    private HashMap<String, String> map;

    public GroupMemberBO()
    {
    }

    public GroupMemberBO(List<String> userList, HashMap<String, String> map)
    {
        this.setUserList(userList);
        this.setMap(map);
    }
    public List<String> getUserList()
    {
        return userList;
    }

    public void setUserList(List<String> userList)
    {
        this.userList = userList;
    }

    public HashMap<String, String> getMap()
    {
        return map;
    }

    public void setMap(HashMap<String, String> map)
    {
        this.map = map;
    }
    @Override
    public String toString(){
        return this.getClass().toString();
    }
}
