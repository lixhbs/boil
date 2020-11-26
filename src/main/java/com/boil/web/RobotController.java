package com.boil.web;

import com.boil.common.result.JsonResult;
import com.boil.common.result.ResultCode;
import com.boil.entity.model.Robot;
import com.boil.manager.RobotManager;
import com.boil.service.DebuggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-18 11:15
 */
@RestController
@RequestMapping("/robot")
public class RobotController
{
    @Autowired
    private DebuggerService debuggerService;

    @Autowired
    private RobotManager robotManager;

    @PostMapping("/getRobot")
    public JsonResult getRobot()
    {
        Robot robotInfo = robotManager.getRobotInfo();
        return new JsonResult(ResultCode.SUCCESS,robotInfo);

    }

    @PostMapping("/daily")
    public JsonResult daily(){
        String String = debuggerService.daily();
        return new JsonResult();
    }

    @PostMapping("/weekly")
    public JsonResult weekly(){
        String String = debuggerService.weekly();
        return new JsonResult();
    }


}
