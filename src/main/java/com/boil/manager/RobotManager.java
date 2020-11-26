package com.boil.manager;

import com.boil.entity.model.Robot;
import com.boil.entity.model.RobotExample;
import com.boil.entity.model.Timedtask;
import com.boil.entity.bo.GroupMemberBO;

import java.util.List;

/**
 * @author li
 */
public interface RobotManager
{
    /**
     * 根据群id获取群成员信息
     * @author Lix.
     * @param groupNum groupNum
     * @return GroupMemberBO
     * @date 2020/11/21 14:43
     */
    GroupMemberBO listMember(String groupNum, String robotWxId);

    /**
     * 获取机器人信息
     * @author Lix.
     * @return Robot
     * @date 2020/11/21 14:45
     */
    Robot getRobotInfo();

    /**
     * 获取机器人信息 同步
     * @author Lix.
     * @return Robot
     * @date 2020/11/21 14:45
     */
    Robot getRobotInfoSync();
}
