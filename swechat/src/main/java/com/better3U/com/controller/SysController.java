package com.better3U.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户登录
 *
 * @author tangyuan
 * @create 2018-01-25 16:49
 **/

@Controller
@RequestMapping("/sys")
public class SysController {
    @RequestMapping("/home")

    public String goHome(HttpServletRequest request, HttpServletResponse response) {

        return "home";

    }

}
