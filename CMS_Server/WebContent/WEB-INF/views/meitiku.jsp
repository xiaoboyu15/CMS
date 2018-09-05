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
    <script type="text/javascript">
    	function chakan(ID) {
			var disvideo=document.getElementById('disvideo');
			var path=document.getElementById(ID).innerHTML;
			disvideo.src=path;
			disvideo.hidden="";
		}
    </script>
</head>
<body>
<video src="" controls="controls" id="disvideo" hidden="hidden"></video>
<div class="container" id="Bdiv">
    <table class="table table-bordered" >
							<tr class="">
								<th>媒体信息ID</th>
								<th>路径</th>
								<th>真实路径</th>
								<th>查看</th>
							</tr>
								<c:forEach items="${medias}" var="medias">
									<tr id="${medias.path}">
										<td>${medias.mediaID}</td>
										<td id="${medias.mediaID}">${medias.path}</td>
										<td>${medias.realPath}</td>
										<td><a onclick="chakan(${medias.mediaID})">播放视频</a></td>
									</tr>
								</c:forEach>
						</table>
</div>
</body>
<script src="./lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="./lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
</html>