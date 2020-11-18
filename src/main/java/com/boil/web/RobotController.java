package com.boil.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boil.common.result.JsonResult;
import com.boil.common.result.ResultCode;
import com.boil.model.Robot;
import com.boil.service.DebuggerService;
import com.boil.service.LovelyCatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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

    @PostMapping("/getRobot")
    public JsonResult getRobot()
    {
        Robot robotInfo = debuggerService.getRobotInfo();
        return new JsonResult(ResultCode.SUCCESS,robotInfo);

    }


}
