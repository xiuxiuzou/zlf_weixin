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
    <link rel="stylesheet" href="${path}/css/fileinput.css">

    <script src="${path}/js/jquery.min.js"></script>
    <script src="${path}/js/bootstrap.min.js"></script>
    <script src="${path}/js/bootstrap-table.js"></script>
    <script src="${path}/js/bootstrap-table/export/tableExport.js"></script>
    <script src="${path}/js/bootstrap-table/export/bootstrap-table-export.js"></script>
    <style>
        .uploadArea{
            height:40%;
            margin-bottom:100px;
        }
    </style>

</head>
<body
        style=" background: url(../img/backgound_sky1.jpg);background-attachment:fixed"
        class="mainBackGround">

<jsp:include page="nav.jsp" flush="true"/>
<div class="container">
    <div class="uploadArea">
    <form id="formExcel" enctype="multipart/form-data">
        <a href="../FileUpload/轮岗模板.xls" class="form-control" style="border: none;">下载导入模板</a>
        <%--后台根据name获得--%>
        <input type="file"  id="fileUpload" name="fileUpload" multiple class="file-loading" />
    </form>
    </div>
</div>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
<script>
    $(document).ready(function(){
        $("#fileUpload").fileinput(
            {
                language: 'zh', //设置语言
                uploadUrl: "${path}/upload/moneyExcel", //上传的地址
                allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
                showUpload: true, //是否显示上传按钮
                showCaption: false,//是否显示标题
                showPreview: true,
                browseClass: "btn btn-primary myBtn", //按钮样式
                initialPreviewAsData: false,
                dropZoneTitle: '拖拽一个文件到这里',
                //dropZoneEnabled: false,//是否显示拖拽区域
                //minImageWidth: 50, //图片的最小宽度
                //minImageHeight: 50,//图片的最小高度
                //maxImageWidth: 1000,//图片的最大宽度
                //maxImageHeight: 1000,//图片的最大高度
                maxFileSize: 1024,//单位为kb，如果为0表示不限制文件大小,限制文件大小
                //minFileCount: 0,
                maxFileCount: 1, //表示允许同时上传的最大文件个数
                enctype: 'multipart/form-data',
                validateInitialCount: true,
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
                previewFileIconSettings: {
                    'xlsx': '<i class="fa fa-file-excel-o"></i>',
                    'xls': '<i class="fa fa-file-excel-o"></i>',
                },
                layoutTemplates:{
                    actionZoom:""
                }
            });

    });
    $("#fileUpload").on("fileuploaded", function (event, data, previewId, index) {
        var data;
        var succ = data.response["status"];
        var msg = data.response["statusMsg"];
        if (succ == "SUCCESS") {
            var progress = $(".progress-bar").text("成功");
            alert(msg);
        } else {
            $(".file-upload-indicator").empty().append( '<i class="glyphicon glyphicon-exclamation-sign text-danger"></i>');
            var progress = $(".progress-bar");
            progress.addClass("progress-bar bg-danger progress-bar-danger");
            progress.text("失败");
            var doneProcess = $(".kv-upload-progress");
            doneProcess.hide();
            var errorInfo = $(".file-preview");
            $("#myInfo").remove();
            $(errorInfo).append("<div class='kv-fileinput-error file-error-message' id='myInfo'><button type='button' class='close kv-error-close' aria-label='Close'><span aria-hidden='true'>×</span></button><ul><li>"+msg+"</li></ul></div>");  }

    });
   /* 删除成功触发的事件*/
    $('#fileUpload').on('filesuccessremove', function(event, id) {
        $(".kv-file-zoom").hide();
        $("#myInfo").remove();
    });
   /* 选择文件后触发的事件*/
    $("#fileUpload").on("filebatchselected", function (event, files) {
        $(".kv-file-zoom").hide();
        $("#myInfo").remove();
    });

</script>
<script src="${path}/js/FileUpload/fileinput.js"></script>
<script src="${path}/js/FileUpload/fileInputzh.js"></script>
</body>
</html>