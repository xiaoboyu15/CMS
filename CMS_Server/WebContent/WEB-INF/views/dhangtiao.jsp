<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet"
	href="./lib/bootstrap-3.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div>
		<nav class="navbar navbar-default  navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a href="${pageContext.request.contextPath}/goToUserIndex.do"
						class="navbar-brand">网络网站管理</a>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<c:forEach items="${sessionScope.onelevels}" var="onelevels">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false"> ${onelevels.oneLevelName} <span
									class="caret"></span>
							</a>

								<ul class="dropdown-menu">
									<c:forEach items="${onelevels.twoLevels}" var="twoLevels">
										<li><a
											href="${pageContext.request.contextPath}/getConByTwo.do?twoLevelID=${twoLevels.twoLevelID}">${twoLevels.twoLevelName}</a></li>
									</c:forEach>
								</ul></li>
						</c:forEach>
						<li class="dropdown" onclick="parent.location.href = '${pageContext.request.contextPath}/goToUserQuestionnaire.do'"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">问卷调查 </a></li>
						<li class="dropdown" onclick="parent.location.href = '${pageContext.request.contextPath}/goToUserXitong.do'"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"> 系统 </a></li>
						
					</ul>
				</div>
			</div>
		</nav>
	</div>
</body>
<script src="./lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="../lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
</html>