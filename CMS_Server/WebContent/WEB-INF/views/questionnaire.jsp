<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>问卷调查测试版</title>
<script>
	var i=0;
	var j=1;
	function tianjiawenti(){
		var div =document.createElement("div");
		var input =document.createElement("input");
		var Rbutton=document.createElement("button");
		var Tbutton=document.createElement("button");
		var B=document.createElement("b")
		B.innerHTML="请输入问题："
		Rbutton.innerHTML="删除问题"
		Tbutton.innerHTML="添加选项"
		Rbutton.id=i;
		input.id=i;
		input.name="questionName"
		Tbutton.onclick=function add(){
			var B1=document.createElement("b")
			var wentidiv =document.createElement("div");
			var radioButton=document.createElement("input")
			var shanchuButton=document.createElement("button")
			var xuanxiangInput=document.createElement("input")
			B1.innerHTML="请输入选项："
			xuanxiangInput.name="answerName"
			xuanxiangInput.id=this.parentNode.firstChild.nextSibling.id
			radioButton.type="radio"
			radioButton.id=this.parentNode.firstChild.nextSibling.id
			radioButton.name=this.parentNode.firstChild.nextSibling.id
			shanchuButton.innerHTML="删除选项"
			shanchuButton.onclick = function removeXuanxian(){
				this.parentNode.parentNode.removeChild(this.parentNode)
			}
			wentidiv.id=this.parentNode.firstChild.nextSibling.id
			wentidiv.appendChild(B1)
			wentidiv.appendChild(radioButton)
			wentidiv.appendChild(xuanxiangInput)
			wentidiv.appendChild(shanchuButton)
			this.parentNode.appendChild(wentidiv)
		}
		Rbutton.onclick=function remove(){
			var parent=this.parentNode;
			div1.removeChild(parent)
		}
		var div1=document.getElementById("div1");
		div.appendChild(B)
		div.appendChild(input)
		div.appendChild(Tbutton)
		div.appendChild(Rbutton)
		div1.appendChild(div)
		i=i+1;
	}
	function tijiao(){
		var questionNames = document.getElementsByName("questionName")
		var answerNames = document.getElementsByName("answerName")
		var questionnaireName=document.getElementById("questionnaireName").value
		var questionName=new Array()
		var answerName=new Array()
		var answerNameLength=new Array()
		for(var i=0;i<questionNames.length;i++){
			var question=document.getElementsByName(questionNames[i].id)
			questionName[i]=questionNames[i].value
			answerNameLength[i]=question.length
		}
		for(var j=0;j<answerNames.length;j++){
			answerName[j]=answerNames[j].value
		}
		parent.location.href = "${pageContext.request.contextPath}/insertQuestionnaire.do?questionnaireName="+questionnaireName+"&questionName="+questionName+"&answerName="+answerName+"&answerNameLength="+answerNameLength;
	}
</script>
<%@ include file="head.jsp"%>
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
	<b>请输入问卷调查名字：</b>
	<input name="questionnaireName" id="questionnaireName"/>
	<button onclick="tianjiawenti()">添加问题</button>
	<div id="div1"></div>
	<button  onclick="tijiao();">提交</button>
</body>
</html>





