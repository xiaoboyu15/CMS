<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<video src="./img/20180709594e3b2e286e496b921681e8852e8252.MP4" controls="controls">
</video>

<form action="${pageContext.request.contextPath}/upload.do" encType="multipart/form-data" method="post">
    <label>选择文件</label>
    <input id="fileId" name="fileName" type="file"/>
    <input type="submit" value="提交"/>    
</form>
<a href="${pageContext.request.contextPath}/goToAdminHome.do"
				target="view_frames">科室管理</a>
</body>
</html>