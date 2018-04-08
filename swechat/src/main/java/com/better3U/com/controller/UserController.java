package com.better3U.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 用户登录
 *
 * @author tangyuan
 * @create 2018-01-25 16:49
 **/
@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    private ValidEffectUser validEffectUser;

    @RequestMapping({"/valid"})
    public void valid(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("jobnum");
        String password = request.getParameter("password");
        String success = "error";
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (validEffectUser.validEffectUser(id, password)) {
                request.getSession().setAttribute("jobnum", id);
                success = "success";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

      out.write(success);

    }

    @RequestMapping({"/exit"})
    public String exit(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "index";

    }

}
