<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="head.jsp" %>
</head>
<body>
	<form action="${pageContext.request.contextPath}/updateOne.do">
		<p>一级栏目</p>
		<input value="${oneLevels.oneLevelName}" name="disoneLevelName" type="hidden">
		<input value="${oneLevels.oneLevelName}" name="oneLevelName">
		<c:forEach items="${twoLevels}" var="twoLevels">
			<p>二级栏目</p>
			<input value="${twoLevels.twoLevelName}" name="distwoLevelName" type="hidden">
			<input value="${twoLevels.twoLevelName}" name="twoLevelName">
		</c:forEach>
		<button type="submit">提交</button>
		<button><a href="${pageContext.request.contextPath}/goToNeirong.do">返回</a></button>
	</form>
	
</body>
</html>