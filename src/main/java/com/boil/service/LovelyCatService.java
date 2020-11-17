package com.boil.service;

import com.boil.entity.message.LovelyCatBean;

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
}
