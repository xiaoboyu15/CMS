<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title></title>
<link rel="stylesheet"
	href="./lib/bootstrap-3.3.0/dist/css/bootstrap.min.css">
<style>
body {
	padding-top: 50px;
}

.starter {
	padding: 40px 15px;
	text-align: center;
}
</style>
<%@ include file="head.jsp"%>
<script type="text/javascript">
window.onload = function(){
	if("<%=session.getAttribute("Permission")%>" != "administrator") {
		var quanxian=document.getElementById("quanxian");
		quanxian.hidden="";
	}
}
	function tuichu() {
		if (confirm("是否退出？")) {
			
			parent.location.href = "${pageContext.request.contextPath}/loginOut.do"
		}
	}
	
</script>
</head>
<body>


	<div class="container" hidden="hidden" id="quanxian">
		<h3>权限设置</h3>
		&nbsp
		<button
			onclick="window.location.href='${pageContext.request.contextPath}/goToQuanxian.do'"
			type="button" class="btn btn-info" >申请权限</button>
	</div>
	<div class="container" >
		<h3>登录设置</h3>
		&nbsp
		<button onclick="tuichu();" type="button" class="btn btn-danger">退出登录</button>
	</div>
</body>
</html>