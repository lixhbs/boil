package com.boil.service;

import com.alibaba.fastjson.JSONArray;
import com.boil.entity.message.LovelyCatBean;

import java.io.UnsupportedEncodingException;

/**
 * @author li
 */
public interface LovelyCatService
{
    /**
     *
     * 发送文字消息(好友或者群)
     *

     *
     * @author Lix.
     * @param lovelyCatBean lovelyCatBean
     *        $robwxid 登录账号id，用哪个账号去发送这条消息
     *        $to_wxid 对方的id，可以是群或者好友id
     *        $msg     消息内容
     * @return String
     * @date 2020/11/16 15:25
     */
    String sendMsg(LovelyCatBean lovelyCatBean);

    /**
     * 取登录账号列表
     * @return string 当前框架已登录的账号信息列表
     */
    JSONArray getLoggedAccountList();

    /**
     * 发送群消息并艾特某人
     * @author Lix.
     * @param toWxId toWxId 发送到哪个群
     * @param atWxId atWxId 艾特
     * @param atName atName 艾特
     * @param msg msg 文本
     * @return String
     * @date 2020/11/18 08:52
     */
    String sendGroupAtMsg(String robot, String toWxId, String atWxId, String atName, String msg);

    /**
     * 取群聊列表
     * $data['type'] = 205;                // Api数值（可以参考 - api列表demo）
     * 机器人id后面默认获取第一个  robWxId $robwxid    账户id 账户id（可选，如果填空字符串，即取所有登录账号的好友列表，反正取指定账号的列表）
     * @param  isRefresh $isRefresh 是否刷新 是否刷新列表，0 从缓存获取 / 1 刷新并获取
     * @return string 当前框架已登录的账号信息列表
     */
    String getGroupList(String isRefresh);


    /**
     * 取群成员列表
     *
     * $data['type'] = 206;                // Api数值（可以参考 - api列表demo）
     * @param robWxId $data['robot_wxid'] = $robwxid;     // 账户id
     * @param  groupWxId $data['group_wxid'] = $group_wxid;  // 群id
     * @param  isRefresh $data['is_refresh'] = $is_refresh;  // 是否刷新列表，0 从缓存获取 / 1 刷新并获取
     *
     * @return string 当前框架已登录的账号信息列表
     */
    String getGroupMemberList(String robWxId, String groupWxId, String isRefresh);

    /**
     *
     * @author Lix.
     * @access public
     * @param  robotWxId $robwxid     账户id
     * @param  groupNum $group_wxid  群id
     * @param  notice $notice      新公告
     * @return string json_string
     * @date 2020/11/18 19:01
     */
    String modifyGroupNotice(String robotWxId, String groupNum, String notice);
}
