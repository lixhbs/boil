package com.boil.service;

import com.boil.entity.WechatMessageParameter;
import com.boil.model.Robot;

import java.io.UnsupportedEncodingException;

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

    /**
     * 获取机器人信息 非缓存
     * @author Lix.
     * @return Robot
     * @date 2020/11/18 16:36
     */
    Robot getRobotInfoSync();

    /**
     * 获取缓存中数据库信息
     * @author Lix.
     * @return Robot
     * @date 2020/11/18 16:37
     */
    Robot getRobotInfo();

    /**
     * 在群里面发消息并且艾特某个人
     * @author Lix.
     * @param toWxId toWxId 发送到哪个群
     * @param atWxId atWxId 艾特
     * @param atName atName 艾特
     * @param msg msg 文本
     * @return String
     * @date 2020/11/18 16:55
     */
    String sendGroupAtMsg(String toWxId, String atWxId, String atName, String msg) throws UnsupportedEncodingException;

    /**
     * "#注册日报"
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/18 17:45
     */
    String registerDaily(WechatMessageParameter wechatMessageParameter);

    /**
     * "#注册周报";
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/18 17:42
     */
    String registerWeekly(WechatMessageParameter wechatMessageParameter);

    /**
     * 发送日报
     * @author Lix.
     * @return String
     * @date 2020/11/18 18:32
     */
    String daily();

    /**
     * 实名认证
     * @author Lix.
     * @param wechatMessageParameter wechatMessageParameter
     * @return String
     * @date 2020/11/19 09:35
     */
    String verified(WechatMessageParameter wechatMessageParameter);

    /**
     * 发送周报
     * @author Lix.
     * @return String
     * @date 2020/11/19 09:52
     */
    String weekly();
}
