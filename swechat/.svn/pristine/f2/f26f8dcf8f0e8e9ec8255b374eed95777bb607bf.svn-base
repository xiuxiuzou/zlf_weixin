package com.better3U.com.controller;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义错误页面
 *
 * @author tangyuan
 * @create 2018-02-23 11:54
 **/
//@Configuration
//@Controller
//public class MyErrorController {
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return new EmbeddedServletContainerCustomizer(){
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//               /* container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
//                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));*/
//                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
//                System.out.println("是不是来这里了哦");
//            }
//        };
//    }
//    @RequestMapping("/404")
//    public String customNotFound(){
//        System.out.println("第二次来了吗？");
//        return "404";
//    }
//
//}
@Controller
public class MyErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleError() {

        return "404";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
