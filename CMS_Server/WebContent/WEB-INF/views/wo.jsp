<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

<script type="text/javascript" charset="utf-8"
	src="./lib/ueditor/ueditor.config.js"></script>

<script type="text/javascript" charset="utf-8"
	src="./lib/ueditor/ueditor.all.min.js">
	
</script>

<script type="text/javascript" charset="utf-8"
	src="./lib/ueditor/lang/zh-cn/zh-cn.js"></script>

<meta name="viewport" content="width=device-width,initial-scale=1">
<title></title>
<link rel="stylesheet"
	href="./lib/bootstrap-3.3.0/dist/css/bootstrap.min.css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
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
		if("<%=session.getAttribute("Permission")%>" == "administrator"){
			var checkPower=document.getElementById("checkPower");
			checkPower.hidden="";
			var checkApplication=document.getElementById("checkApplication");
			checkApplication.hidden="";
		}
	}
	function showLogin() {
		var loginWaters = document.getElementById("tableLogin");
		var open = document.getElementById("open");
		open.hidden = "hidden";
		tableLogin.hidden = "";
	}
	function hiddenLogin() {
		var loginWaters = document.getElementById("tableLogin");
		var open = document.getElementById("open");
		open.hidden = "";
		tableLogin.hidden = "hidden";
	}
	
	function showApplication() {
		var loginWaters = document.getElementById("tableApplication");
		var open1 = document.getElementById("open1");
		open1.hidden = "hidden";
		tableApplication.hidden = "";
	}
	function hiddenApplication() {
		var loginWaters = document.getElementById("tableApplication");
		var open1 = document.getElementById("open1");
		open1.hidden = "";
		tableApplication.hidden = "hidden";
	}
	
	function Agree(ID){
		if(confirm("确定同意该名用户的权限申请？")) {
			parent.location.href = "${pageContext.request.contextPath}/agree.do?applicationID="+ID; 
		}
	}
	function Refuse(ID){
		if(confirm("确定拒绝该名用户的权限申请？")) {
			parent.location.href = "${pageContext.request.contextPath}/refuse.do?applicationID="+ID; 
		}
	}
	function remove(){
		if(confirm("确定清楚登录记录？")) {
			parent.location.href = "${pageContext.request.contextPath}/removeWater.do"; 
		}
	}
</script>
</head>
<body>
	<div>
		<h2>个人信息：${sessionScope.username}</h2>
		<h4>权限等级：${sessionScope.Permission}</h4>
		<h4>上次登录时间:${sessionScope.Date}</h4>
	</div>
	<div id="checkPower" hidden="hidden">
		<button onclick="showLogin();" id="open">显示系统使用人员登录记录表</button>
		<div hidden="hidden" id="tableLogin">
			<table class="table table-bordered">
				<button onclick="hiddenLogin();" id="close">关闭系统使用人员登录记录表</button>
				<button type="button" class="btn btn-danger" onclick="remove();">清空数据</button>
				<tr>
					<td>登录记录ID</td>
					<td>登录账号名称</td>
					<td>登录记录时间</td>
					<td>登录角色等级</td>
				</tr>
				<c:forEach items="${loginWaters}" var="loginWaters">
					<tr>
						<td>${loginWaters.loginID}</td>
						<td>${loginWaters.loginName}</td>
						<td>${loginWaters.loginDate}</td>
						<td>${loginWaters.loginType}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<div id="checkApplication" hidden="hidden">
		<button onclick="showApplication();" id="open1">显示权限申请人员登录记录表</button>
		<div hidden="hidden" id="tableApplication">
			<table class="table table-bordered">
				<button onclick="hiddenApplication();" id="close1">关闭权限申请人员登录记录表</button>
				<tr>
					<td>权限申请ID</td>
					<td>申请人名称</td>
					<td>申请人的权限</td>
					<td>所申请的权限</td>
					<td>原因</td>
					<td>申请提交时间</td>
					<td>处理状态（1同意，2拒绝）</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${applications}" var="applications">
					<tr>
						<td>${applications.applicationID}</td>
						<td>${applications.applicationName}</td>
						<td>${applications.nowPower}</td>
						<td>${applications.applicationPower}</td>
						<td>${applications.why}</td>
						<td>${applications.applicationDate}</td>
						<td>${applications.applicationState}</td>
						<td>
							<button type="button" class="btn btn-success" onclick="Agree(${applications.applicationID});">允许</button>
							<button type="button" class="btn btn-danger" onclick="Refuse(${applications.applicationID});">拒绝</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>