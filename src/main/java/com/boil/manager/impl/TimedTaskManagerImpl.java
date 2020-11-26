package com.boil.manager.impl;

import com.boil.dao.TimedtaskMapper;
import com.boil.entity.model.Timedtask;
import com.boil.entity.model.TimedtaskExample;
import com.boil.manager.TimedTaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-21 14:25
 */
@Service
public class TimedTaskManagerImpl implements TimedTaskManager
{
    @Autowired
    private TimedtaskMapper timedtaskMapper;

    @Override
    public List<Timedtask> selectTimedTaskByName(String name)
    {
        TimedtaskExample timedtaskExample = new TimedtaskExample();
        TimedtaskExample.Criteria criteria = timedtaskExample.createCriteria();
        criteria.andNameEqualTo(name);

        List<Timedtask> timedTasks = timedtaskMapper.selectByExample(timedtaskExample);
        if (timedTasks == null)
        {
            return new ArrayList<Timedtask>(0);
        }
        return timedTasks;
    }
}
