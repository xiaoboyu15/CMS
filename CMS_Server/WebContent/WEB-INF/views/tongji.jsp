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
	<table class="table table-bordered" >
			<tr>
				<td>填写记录ID</td>
				<td>填写问卷调查名称</td>
				<td>填写人名称</td>
			</tr>
		<c:forEach items="${qas}" var="qas">
			<tr>
				<td>${qas.QAPersonID}</td>
				<td>${qas.QAName}</td>
				<td>${qas.QAPersonName}</td>
			</tr>
		</c:forEach>
	
	</table>
</body>
<script src="../lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="../lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
</html>