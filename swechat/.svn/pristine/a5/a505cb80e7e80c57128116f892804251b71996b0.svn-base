package com.better3U.com.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    private String[] EgnoreUrlArray = {
            "/",
            "/index.html",
            "/index",
            "/WEB-INF/jsp/index.jsp",
            "/login/valid"};

    public void destroy() {
        System.out.println("过滤器销毁！");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String url = ((HttpServletRequest) req).getServletPath();

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        HttpSession session = httpServletRequest.getSession();
        Object jobNum = session.getAttribute("jobnum");
        boolean isLogin = false;
        if (jobNum != null) {
            isLogin = true;
        }

        if (isEgnoreUrl(url) || isLogin) {
            chain.doFilter(req, resp);
        } else {
            httpServletResponse.sendRedirect("/swechat/index");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化！");
    }

    public boolean isEgnoreUrl(String url) {
        for (String page : EgnoreUrlArray) {//判断是否在过滤url之外
            if (url.equals(page)) {
                return true;
            }
        }
        /*  静态资源*/
        if (url.length() > 3 && (url.endsWith(".js") || url.endsWith(".css") || url.endsWith(".jpg") || url.endsWith(".png"))) {//允许.js .css .jpg .png通过
            return true;
        }
        return false;
    }

}

