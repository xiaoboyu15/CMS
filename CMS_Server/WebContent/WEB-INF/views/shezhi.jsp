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
</head>
<body>
<div class="container">
    <div class="panel-group" id="accordion" role="tablist">
        <div class="panel panel -default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Item1</a>
                </h4>
            </div>
                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel">
                    <div class="panel-body">
                        <p>2333333333233333</p>
                        <p>2333333333233333</p>
                        <p>2333333333233333</p>
                        <p>2333333333233333</p>
                    </div>
                </div>
        </div>


        <div class="panel panel -default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Item1</a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse " role="tabpanel">
                <div class="panel-body">
                    <p>2333333333233333</p>
                    <p>2333333333233333</p>
                    <p>2333333333233333</p>
                    <p>2333333333233333</p>
                </div>
            </div>
        </div>



        <div class="panel panel -default">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Item1</a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel">
                <div class="panel-body">
                    <p>2333333333233333</p>
                    <p>2333333333233333</p>
                    <p>2333333333233333</p>
                    <p>2333333333233333</p>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
<script src="../lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="../lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>
</html>