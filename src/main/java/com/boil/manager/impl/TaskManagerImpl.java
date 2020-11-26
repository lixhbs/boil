package com.boil.manager.impl;

import com.boil.dao.UseraccountMapper;
import com.boil.entity.model.Useraccount;
import com.boil.entity.model.UseraccountExample;
import com.boil.manager.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-21 14:19
 */
@Service
public class TaskManagerImpl implements TaskManager
{
    @Autowired
    private UseraccountMapper useraccountMapper;

    @Override
    public List<Useraccount> selectAccountByWxId(String wxId)
    {
        // 先查询 是否存在，不存在就新增
        UseraccountExample useraccountExample = new UseraccountExample();
        UseraccountExample.Criteria criteria = useraccountExample.createCriteria();
        criteria.andWxidEqualTo(wxId);

        Useraccount userAccount = new Useraccount();
        userAccount.setWxid(wxId);

        return useraccountMapper.selectByExample(useraccountExample);
    }
}
