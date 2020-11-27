package com.boil.manager.impl;

import com.boil.entity.model.Project;
import com.boil.entity.model.Task;
import com.boil.manager.ResultTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-21 14:10
 */
@Service
public class ResultTemplateImpl implements ResultTemplate
{
    /**
     * 生成周报消息模板
     * @author Lix.
     * @return 这里应该返回项目分组的消息模板
     * @date 2020/11/27 11:20
     */
    @Override
    public HashMap<String, String> createWeekReport(List<Task> tasks, HashMap<String, String> map, List<Project> projects)
    {
        // 任务总数
        int taskSize = tasks.size();

        HashMap<String, List<Task>> taskInfoListHashMap = new HashMap<>(10);

        // 先根据项目 暂时没有用sql分组查询
        for (Task task : tasks)
        {
            String projectCode = task.getProjectcode();
            List<Task> tasksList = taskInfoListHashMap.get(projectCode);

            if ( tasksList == null) {
                tasksList = new ArrayList<>();
            }
            tasksList.add(task);
            taskInfoListHashMap.put(projectCode, tasksList);
        }
        HashMap<String, String> messageHashMap = new HashMap<>(4);
        taskInfoListHashMap.forEach((projectCode, item) -> {
            AtomicInteger index = new AtomicInteger(1);
            StringBuffer taskBuffer = new StringBuffer();
            item.forEach((task -> {
                taskBuffer.append(index.getAndIncrement()).append("、").append(task.getContent()).append(";\n");
            }));
            messageHashMap.put(projectCode, taskBuffer.toString());
        });
        return messageHashMap;
    }
}
