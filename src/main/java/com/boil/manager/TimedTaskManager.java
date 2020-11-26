package com.boil.manager;

import com.boil.entity.model.Timedtask;

import java.util.List;

/**
 * @author li
 */
public interface TimedTaskManager
{
    /**
     * 定时任务名称查询定时任务
     * @author Lix.
     * @param name 定时任务名称
     * @return List<Timedtask>
     * @date 2020/11/21 14:23
     */
    List<Timedtask> selectTimedTaskByName(String name);
}
