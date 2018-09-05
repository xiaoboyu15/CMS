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
<%@ include file="dhangtiao.jsp"%>
<script type="text/javascript">
	function Tianxie(questionnaireID){
		parent.location.href = "${pageContext.request.contextPath}/tianXieUserQuestionnaire.do?questionnaireID="+questionnaireID; 
	}
</script>
</head>
<body>
	<table class="table table-bordered">
				<tr>
					<td>问卷调查ID</td>
					<td>问卷调查名称</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${questionnaires}" var="questionnaires">
					<tr>
						<td>${questionnaires.questionnaireID}</td>
						<td>${questionnaires.questionnaireName}</td>
						<td><button type="button" class="btn btn-success" onclick="Tianxie(${questionnaires.questionnaireID});">填写问卷</button></td>
					</tr>
				</c:forEach>
	</table>
</body>
</html>