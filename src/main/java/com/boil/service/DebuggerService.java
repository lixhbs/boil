package com.boil.service;

import com.boil.entity.WechatMessageParameter;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-10 16:45
 */
public interface DebuggerService
{
    /**
     * 帮助
     * @author Lix.
     * @return String
     * @date 2020/11/16 15:42
     */
    String debuggerHelp();

    /**
     * 发布任务
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/16 18:11
     */
    String pushTask(WechatMessageParameter wechatMessageParameter);

    /**
     * 具体执行任务持久化的方法
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/16 18:27
     */
    String pushTaskExecute(WechatMessageParameter wechatMessageParameter);

    /**
     * 【私聊】 查看待办
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/17 14:41
     */
    String listTodo(WechatMessageParameter wechatMessageParameter);

    /**
     * 【私聊】 待办完成
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/17 16:44
     */
    String todoFinish(WechatMessageParameter wechatMessageParameter);

    /**
     * 当前团队的待办报告
     * @author Lix.
     * @param groupId 群微信id
     * @return boolean 是否发送成功
     * @date 2020/11/17 17:24
     */
    boolean todoReport(String groupId);
}
