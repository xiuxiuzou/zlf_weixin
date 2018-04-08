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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>微信测试系统</title>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/css/style.css">
    <link rel="stylesheet" href="${path}/css/bootstrap-table/bootstrap-table.css">
    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
    <script src="${path}/js/bootstrap-table.js"></script>
    <script src="${path}/js/bootstrap-table/export/tableExport.js"></script>
    <script src="${path}/js/bootstrap-table/export/bootstrap-table-export.js"></script>



</head>
<body
        style=" background: url(../img/backgound_sky1.jpg);background-attachment:fixed"
        class="mainBackGround">

<jsp:include page="nav.jsp" flush="true"/>
<div class="container">
<table id="taskTable" data-toolbar="#toolbar"
       data-search="true" data-show-toggle="true"
       data-show-columns="true" data-show-export="true"
       data-detail-view="false" data-detail-formatter="detailFormatter"
       data-minimum-count-columns="2" data-show-pagination-switch="true"
       data-pagination="true" data-show-footer="false"
       data-response-handler="responseHandler" data-row-style="rowStyle1"
       data-filter-control="true" class="table table-bordered">
    <caption id="tableTitle">任务查询</caption>
    <thead>
    <tr>
        <th data-checkbox="true"></th>

        <th data-formatter="formatter"
            data-align="center" data-halign="center">技术支持号
        </th>
        <th data-sortable="true" data-field="name"
            data-filter-control="input" data-align="center" data-halign="center">任务名称
        </th>
        <th data-sortable="true" data-field="age"
            data-filter-control="input" data-align="center" data-halign="center">申报时间
        </th>
        <th data-sortable="true" data-field="id"
            data-filter-control="input" data-align="center" data-halign="center">任务状态
        </th>
        <th data-sortable="true" data-field="EndDate"
            data-filter-control="input" data-align="center" data-halign="center">申报类型
        </th>
        <th data-sortable="true" data-field="FromOrgName"
            data-filter-control="input" data-align="center" data-halign="center">申报部门
        </th>
        <th data-sortable="true" data-field="FromSubOrgName"
            data-filter-control="input" data-align="center" data-halign="center">申报科室
        </th>
        <th data-sortable="true" data-field="FromChannelName"
            data-filter-control="input" data-align="center" data-halign="center">申报人
        </th>
        <th data-sortable="true" data-field="ToOrgName"
            data-filter-control="input" data-align="center" data-halign="center">技术支持责任人
        </th>
        <th data-sortable="true" data-field="ToSubOrgName"
            data-filter-control="input" data-align="center" data-halign="center">更新时间
        </th>
        <th data-sortable="true" data-field="ToChannelName"
            data-filter-control="input" data-align="center" data-halign="center">详情
        </th>
        <th data-sortable="true" data-field="IsZZ"
            data-filter-control="input" data-align="center" data-halign="center">优先
        </th>
    </tr>
    </thead>
</table>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
<script>
   /* $.ajax({
        type: 'post',
        url: "${path}/girls",
        contentType: "application/json; charset=utf-8",
        dataType: 'text',
        async: true,
        success: function (data, status) {

            var strs = $.parseJSON($.trim(data)).d;
            if (strs == null) {
                alert("查询错误");
            } else if (strs != "" || strs.length > 0) {
                $('#taskTable').bootstrapTable({
                    pageSize: 3,
                    //可供选择的每页的行数（*）
                    exportOptions: {
                        ignoreColumn: [0, 1],  //忽略某一列的索引
                        fileName: '商委全体员工信息' + new Date().Format("yyyyMMddHHmm"),  //文件名称设置
                        worksheetName: 'sheet1',  //表格工作区名称

                    }

                });
                $('#taskTable').bootstrapTable({
                    data: strs
                });
                $('#taskTable').bootstrapTable('load', strs);

            } else {
                alert("其他情况 ： "
                    + (strs.length <= 0 ? " 没有数据" : strs)
                    + "---" + status);
                //location.href = "/fltExecuteRateMonitor";

            }
        },
        error: function (data, status, e) {
            $("#myprogress").addClass("hide");
            alert(data + "---" + status + "---" + e);

        }
    });*/
</script>
</body>
</html>