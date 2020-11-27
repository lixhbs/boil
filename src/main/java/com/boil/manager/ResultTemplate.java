package com.boil.manager;

import com.boil.entity.model.Project;
import com.boil.entity.model.Task;

import java.util.HashMap;
import java.util.List;

/**
 * @author li
 */
public interface ResultTemplate
{
    /**
     * 周报模板
     * @author Lix.
     * @param tasks 任务列表
     * @param map 人员信息
     * @param projects 项目列表
     * @return String
     * @date 2020/11/27 10:52
     */
    HashMap<String, String> createWeekReport(List<Task> tasks, HashMap<String, String> map, List<Project> projects);
}
