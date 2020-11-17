package com.boil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-09 17:12
 */
@SpringBootApplication
@MapperScan("com.boil.dao")
public class BoilApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BoilApplication.class, args);
    }
}
