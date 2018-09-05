<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<meta name="viewport" content="width=devide-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" >
<link href="./lib/bootstrap-3.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    a,a:active,a:hover,a:focus{
        text-decoration: none;
        color: black;
    }
    a{
        display: block;
    }
    img{
        width: 140px;
    }
    .mycontent{
        display: -webkit-box;
        -webkit-line-clamp:2;
        overflow: hidden;
        text-overflow: ellipsis;
        -webkit-box-orient: vertical;
    }
    video{
        width: 100%;
    }
</style>
<%@ include file="dhangtiao.jsp"%>
<body>
<div class="container" style="margin-top: 50px">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        
        <c:forEach items="${contents}" var="contents">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="row" class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#${contents.conID}" aria-expanded="false" aria-controls="collapseTwo">
                        <div class="col-lg-2">
                            <video class="img-thumbnail" src="${contents.annex}" controls="controls" alt="xxx">
                        </div>
                        <div class="col-lg-8">
                            <div class="container-fluid">
                                <h2>标题：${contents.title}</h2>
                                <h5>标签：${contents.tags}</h5>
                                <h5>来源：${contents.source}</h5>
                                <h5>作者：${contents.author}</h5>
                                <h5>编辑者：${contents.editor}</h5>
                                <h5>关键字：${contents.keywords}</h5>
                                <h5>编辑时间：${contents.time}</h5>
                                
                            </div>
                        </div>
                    </a>
                </h4>
            </div>
            <div id="${contents.conID}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
                  ${contents.richText}
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
</body>

<script src="./lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="./lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
</html>