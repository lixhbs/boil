package com.boil.web;

import com.boil.common.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-26 11:54
 */
@RestController
@RequestMapping("/api/u/v1/")
public class UserAccountController
{
    /**
     * 登录
     * @author Lix.
     * @param map userName userPassword
     * @return JsonResult  sessionID
     * @date 2020/11/26 15:49
     */
    @PostMapping("/login")
    public JsonResult login(@RequestBody Map<String, String> map)
    {
        String userName = map.get("userName");
        String userPassword = map.get("userPassword");

        if(StringUtils.isAnyEmpty(userName, userPassword))
        {
            System.out.println("UserAccountController.login");
        }

        return new JsonResult();
    }
}
