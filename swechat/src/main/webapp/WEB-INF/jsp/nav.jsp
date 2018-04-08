<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String jobnum = request.getSession().getAttribute("jobnum") + "";
    String username = request.getSession().getAttribute("username")
            + "";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="<%=path%>" var="path" scope="page"/>
<c:set value="<%=jobnum%>" var="jobnum" scope="page"/>
<c:set value="<%=username%>" var="username" scope="page"/>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${path}" target="_self"><img src="${path}/img/logo.png" height="25px"/> </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown"><a href="${path}/sys/home" class="dropdown-toggle"
                                        role="button" aria-haspopup="true"
                                        aria-expanded="false"><span class="glyphicon glyphicon-home"></span>主页</a>

                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown" role="button" aria-haspopup="true"
                                        aria-expanded="false"><span class="fa fa-bars"></span>批量上传<span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${path}/upload/excel">某表上传</a></li>
                        <li><a href="${path}/coordinators/airport">商委任务列表</a></li>
                        <li><a href="${path}/coordinators/airport">下载中心</a></li>

                    </ul>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" role="button" aria-haspopup="true"
                                        aria-expanded="false">
                    <span class="fa fa-bar-chart"></span>报表统计</a>

                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown" role="button" aria-haspopup="true"
                                        aria-expanded="false"><span class="fa fa-briefcase"></span>百宝箱<span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${path}/coordinators/airport">下载中心</a></li>
                    </ul>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">
                        <span class="glyphicon glyphicon-user">${jobnum}</span>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${path}/login/exit">退出系统</a></li>

                    </ul>
                </li>
                </li>
            </ul>

        </div>
    </div>
</nav>
