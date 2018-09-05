<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <%@ include file="head.jsp" %>
</head>

<body>

<div class="container">
<form action="${pageContext.request.contextPath}/getPower.do" method="post">
   <h3>用户权限变更</h3>
    <div>
        <select style="border-radius: 10px;width:200px;height:30px;width: auto;padding: 0 2%;margin: 0;" name="select">
            <option style="text-align:center;" value="administrator">管理员</option>
        </select>
    </div>
    <h3>申请权限原因</h3>
    <textarea name="why" style="width:750px;height:300px;"placeholder="输入您的内容" ></textarea>
    <div>
        <button onclick="alert('您已提交成功，请等待审核！')" type="submit">提交</button>
        <button onclick="window.location.href='${pageContext.request.contextPath}/goToXitong.do'">返回</button>
    </div>
    </form>
</div>
</body>
<script src="./lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="./lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>

</html>