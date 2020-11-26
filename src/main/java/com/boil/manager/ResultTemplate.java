package com.boil.manager;

import com.boil.entity.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-21 14:10
 */
public class ResultTemplate
{

    public static String createWeekReport(List<Task> tasks, HashMap<String, String> map)
    {
        // 任务总数
        int taskSize = tasks.size();

        HashMap<String, List<Task>> taskInfoListHashMap = new HashMap<>(10);

        // 先根据项目 分组查询

        for (Task task : tasks)
        {
            // 获取中文名称
            String cnName = map.get(task.getReceiverWxid());

            // 任务内容 记录到任务表里面
            List<Task> strings = taskInfoListHashMap.get(cnName);
            if ( strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(task);
            taskInfoListHashMap.put(cnName, strings);
        }

        for (Task task : tasks)
        {
            // 获取中文名称
            String cnName = map.get(task.getReceiverWxid());

            // 任务内容 记录到任务表里面
            List<Task> strings = taskInfoListHashMap.get(cnName);
            if ( strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(task);
            taskInfoListHashMap.put(cnName, strings);
        }
        HashMap<String, List<Task>> projectListHashMap = new HashMap<>(10);
        taskInfoListHashMap.forEach((userName, item) -> {
            item.forEach((task -> {
                List<Task> tasks1 = projectListHashMap.get(task.getProjectcode());
                if ( tasks1 == null) {
                    tasks1 = new ArrayList<>();
                }
                tasks1.add(task);
            }));
        });

        return "1";
    }
}
