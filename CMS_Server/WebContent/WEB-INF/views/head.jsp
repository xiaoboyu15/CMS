<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title></title>
    <link rel="stylesheet" href="./lib/bootstrap-3.3.0/dist/css/bootstrap.min.css">
    <style>
        body{
            padding-top:50px;
            }
        .starter{
            padding: 40px 15px;
            text-align: center;
    </style>
</head>
<body>



    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href="${pageContext.request.contextPath}/goToHome.do" class="navbar-brand">网络网站管理</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li style="color: white;"><a href="#">欢迎您：${sessionScope.username}</a></li>
                    <li><a href="#"><</a></li>
                    <li><a href="${pageContext.request.contextPath}/goToWo.do">我</a></li>
                    <li><a href="${pageContext.request.contextPath}/goToNeirong.do">内容</a></li>
                    <li><a href="${pageContext.request.contextPath}/goToMeitiku.do">媒体库</a></li>
                    <li><a href="${pageContext.request.contextPath}/goToQuestionnaireList.do">调查问卷</a></li>
                    <li><a href="${pageContext.request.contextPath}/goToTongji.do">问卷调查统计</a></li>
                    <li><a href="${pageContext.request.contextPath}/goToXitong.do">系统</a></li>
                    <li><a href="#">></a></li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>