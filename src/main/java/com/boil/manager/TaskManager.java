package com.boil.manager;

import com.boil.entity.model.Useraccount;

import java.util.List;

/**
 * @author li
 */
public interface TaskManager
{
    /**
     * 通过微信id查询用户信息
     * @author Lix.
     * @param wxId wxId
     * @return List List
     * @date 2020/11/25 10:40
     */
    List<Useraccount> selectAccountByWxId(String wxId);
}
