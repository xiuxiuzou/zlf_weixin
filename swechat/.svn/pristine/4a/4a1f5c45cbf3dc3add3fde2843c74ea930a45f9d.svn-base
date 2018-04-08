<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>IT支持部提醒您-页面未找到 </title>
    <c:set value="<%=path%>" var="path" scope="page"/>
    <c:set value="<%=basePath%>" var="basePath" scope="page"/>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/bootstrap.min.css" media="screen"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/error.css" media="screen"/>
</head>
<body>
<div id="container">
    <img class="png" src="${path}/img/error/404.png"/>
    <img class="png msg" src="${path}/img/error/404_msg.png"/>
    <button class="btn btn-warning btn-lg center-block" onclick="window.history.back();" style="">返回</button>
</div>
<%--<div id="cloud" class="png"></div>--%>
<pre style="DISPLAY: none"></pre>
</body>
</html>