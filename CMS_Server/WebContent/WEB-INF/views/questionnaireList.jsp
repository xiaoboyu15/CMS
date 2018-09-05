<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="head.jsp"%>
<link rel="stylesheet" href="./lib/bootstrap-3.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div style="margin-top: 50px;">
	<button type="button" class="btn btn-info" onclick="window.location.href='${pageContext.request.contextPath}/goToQuestionnaire.do'">添加问卷调查</button>
	<c:forEach items="${questionnaires}" var="questionnaires">
		<table class="table table-bordered" >
			<tr>
				<td>问卷调查名称</td>
				<c:forEach items="${questionnaires.questions}" var="questions">
				<td>问卷调查问题</td>
					<c:forEach items="${questions.answers}" var="answers">
						<td>选项</td>
						<td>被选次数</td>
					</c:forEach>
				</c:forEach>
			</tr>
			<tr>
				<td>${questionnaires.questionnaireName}</td>
				<c:forEach items="${questionnaires.questions}" var="questions">
				<td>${questions.questionName}</td>
					<c:forEach items="${questions.answers}" var="answers">
						<td>${answers.answerName}</td>
						<td>${answers.answerTicket}</td>
					</c:forEach>
				</c:forEach>
			</tr>
		</table>
	</c:forEach>
</div>
</body>
<script src="../lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="../lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
</html>