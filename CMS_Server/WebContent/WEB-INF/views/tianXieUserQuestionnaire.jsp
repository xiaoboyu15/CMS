<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Insert title here</title>
<%@ include file="dhangtiao.jsp"%>
<script type="text/javascript">
	function finish(){
		console.log(111)
		var radio=document.getElementsByClassName("radioClass")
		var questionnaireName=document.getElementById("Qname").innerHTML
		var answerID=new Array()
		var j=0;
		for(var i=0;i<radio.length;i++){
			if(radio[i].checked){
				answerID[j]=radio[i].value
				j=j+1
			}
		}
		parent.location.href = "${pageContext.request.contextPath}/finishUserQuestionnaire.do?answerID="+answerID+"&questionnaireName="+questionnaireName; 
	}
</script>
</head>
<body>
<div style="text-align: center;position: absolute; width: 100%;height: 100%; margin-top: 50px;">
	<form action="" method="post">
		<input name="questionnaireName" value="${questionnaire.questionnaireID}" hidden="hidden">
		<h2 id="Qname">${questionnaire.questionnaireName}</h2>
		<table class="table table-bordered">
		<c:forEach items="${questions}" var="questions">
			<p>${questions.questionName}</p>
			<c:forEach items="${questions.answers}" var="answers">
				<input type="radio" class="radioClass" name="${questions.questionName}" id="${questions.questionName}" value="${answers.answerID}">
				${answers.answerName}
			</c:forEach>
		</c:forEach>
		</table>
		
	</form>
	<button type="" onclick="finish();">提交</button>
</div>
</body>
</html>