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
<style>
body {
	padding-top: 50px;
}

.row {
	margin-bottom: 20px
}

.row .row {
	margin-top: 10px;
	margin-bottom: 0;
}

[class*="col-"] {
	padding-top: 15px;
	padding-bottom: 15px;
	background-color: #eee;
	background-color: rgba(86, 61, 124, .15);
	border: 1px solid #ddd;
	border: 1px solid rgba(86, 61, 124, .2);
}
</style>
<%@ include file="head.jsp"%>
</head>
<body>
	<script>
	function yanzhen() {
		if("<%=session.getAttribute("Permission")%>" != "administrator") {
				alert("权限不足");
				return false;
			}

		}
	  function queren(oneLevelName){
		if(confirm("警告！！！警告！！！删除一级栏目将删除栏目所属下的所有二级栏目以及对应的文本！！！")) {  
			if("<%=session.getAttribute("Permission")%>" != "admin") {
				alert("权限不足,操作失败！！！");
				}else{
					parent.location.href = "${pageContext.request.contextPath}/deleteOne.do?oneLevelName="+oneLevelName; 
				}
			
		}  
		
		}
	
	</script>
	<div class="container">
		<div class="row">
			<div class="col-md-2 ">
				<h1>操作管理</h1>

				<ul id="myTab" class="nav nav-tabs">
					<li class="dropdown"><a href="#" id="myTabdrop1"
						class="dropdown-toggle" data-toggle="dropdown"> 栏目管理<b
							class="caret"></b></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#home" tabindex="-1" data-toggle="tab">添加一级栏目</a></li>
							<li><a href="#twoLevel" tabindex="-1" data-toggle="tab">添加二级栏目</a></li>
							<li><a href="#profile" tabindex="-1" data-toggle="tab">修改一二级栏目</a></li>
							<li><a href="#three" tabindex="-1" data-toggle="tab">删除一级栏目</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" id="myTabdrop2"
						class="dropdown-toggle" data-toggle="dropdown"> 信息管理<b
							class="caret"></b></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#one" tabindex="-1" data-toggle="tab">添加文章属性</a></li>
							<li><a href="#two" tabindex="-1" data-toggle="tab">添加视频信息</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" id="myTabdrop5"
						class="dropdown-toggle" data-toggle="dropdown"> 调查问卷管理<b
							class="caret"></b></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#wenjuan" tabindex="-1" data-toggle="tab">添加问卷</a></li>

						</ul></li>
				</ul>

			</div>
			<div class="col-md-8 col-md-offset-1">



				<div id="MyTabContent" class="tab-content">

					<div class="tab-pane" id="home">
						<form action="${pageContext.request.contextPath}/insertOne.do"
							onsubmit="return yanzhen()">
							<p>添加节点</p>
							<p style="color: red">*一级栏目节点名称</p>
							<input class="form-control" placeholder="节点名称不能为空"
								name="oneLevelName">
							<div style="text-align: center">
								<button type="submit">确定</button>
								<button type="reset">取消</button>
							</div>

						</form>
					</div>

				<div class="tab-pane" id="twoLevel">
						<form action="${pageContext.request.contextPath}/insertTwo.do"
							onsubmit="return yanzhen()">
							<p>添加节点</p>
							<p style="color: red">*一级栏目节点名称</p>
							<select name="oneLevelID">
								<c:forEach items="${onelevels}" var="onelevels">
									<option value="${onelevels.oneLevelID}">${onelevels.oneLevelName}</option>
								</c:forEach>
							</select>
							<input class="form-control" placeholder="节点名称不能为空"
								name="twoLevelName">
							<div style="text-align: center">
								<button type="submit">确定</button>
								<button type="reset">取消</button>
							</div>

						</form>
					</div>

					<div class="tab-pane" id="profile">

						<table class="table table-bordered">
							<tr>
								<td>id</td>
								<td>一级栏目</td>
								<td>二级栏目</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${onelevels}" var="onelevels">
								<tr>
									<td>${onelevels.oneLevelID}</td>
									<td>${onelevels.oneLevelName}</td>
									<td>${onelevels.twoLevelNames}</td>
									<td><a
										href="${pageContext.request.contextPath}/update.do?oneLevelID=${onelevels.oneLevelID}">修改</a></td>
								</tr>
							</c:forEach>
						</table>

					</div>
					<script type="text/javascript">
						function test(){
							console.log(UE.getEditor('editor').getContentTxt())
							var txtInput=document.getElementById("txtInput")
							txtInput.value=UE.getEditor('editor').getContentTxt()
						}
					</script>
					<div class="tab-pane" id="one">
						<form action="${pageContext.request.contextPath}/insertCon.do"
							encType="multipart/form-data" method="post" onsubmit="return test()">
							<p style="color: red">*标题</p>
							<input type="text" class="form-control" name="title"
								placeholder="请输入您的标题">
							<p>关键词</p>
							<input type="text" class="form-control" name="keywords"
								placeholder="请输入您的关键词">
							<p>来源</p>
							<input type="text" class="form-control" name="source"
								placeholder="请输入您的来源">
							<p>作者</p>
							<input type="text" class="form-control" name="author"
								placeholder="请输入您的来源">
							<p>编辑者</p>
							<input type="text" class="form-control" name="editor"
								value="${sessionScope.username}" disabled="disabled">
							<p>标签</p>
							<input type="text" class="form-control" name="tags"
								placeholder="请输入您的来源">
							<p>是否置顶</p>
							<select name="top">
								<option value="否">否</option>
								<option value="是">是</option>
							</select>
							<p>所属二级栏目</p>
							<select name="twoLevelName">
								<c:forEach items="${sessionScope.twolevels}" var="twolevels">
									<option value="${twolevels.twoLevelName}">${twolevels.twoLevelName}</option>
								</c:forEach>
							</select>
							<p>内容</p>
							<div id="editor" style="height: 360px" name="richText" >
								<script type="text/javascript" charset="utf-8">
									var ue=UE.getEditor('editor');
								</script>
							</div>
							<textarea id="txtInput" name="txtInput" hidden="hidden" ></textarea>
							<div style="float: left">
								<input type="file" name="fileName" multiple>
							</div>
							<div style="float: right">
								<button type="submit">提交</button>
							</div>
						</form>
					</div>
					<div class="tab-pane" id="two">
						<p>上传视频</p>
						<input type="file" multiple>
						<p>标题</p>
						<input class="form-control" placeholder="0/21">
						<p>封面</p>
						<input type="file" multiple placeholder="0/21">
						<p>分类</p>
						<div>
							<select>
								<option>---请选择---</option>
								<option>情感交友</option>
								<option>访谈</option>
								<option>选秀</option>
								<option>竞技</option>
								<option>时尚生活</option>
								<option>KTV</option>
								<option>音乐</option>
								<option>曲艺</option>
								<option>综艺</option>
							</select>
						</div>
						<p>标签</p>
						<input class="form-control" placeholder="输入您的标签">
						<p>简介</p>
						<textarea name="a" style="width: 750px; height: 300px;"
							placeholder="请简单介绍您的视频"></textarea>

						<div style="text-align: center">
							<button>确定</button>
							<button>取消</button>
						</div>

					</div>

					<div class="tab-pane" id="three">
						<table class="table table-bordered">
							<tr>
								<td>id</td>
								<td>一级栏目</td>
								<td>二级栏目</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${onelevels}" var="onelevels">
								<tr>
									<td>${onelevels.oneLevelID}</td>
									<td>${onelevels.oneLevelName}</td>
									<td>${onelevels.twoLevelNames}</td>
									<td><button onclick="queren('${onelevels.oneLevelName}');">删除</button></td>
								</tr>
							</c:forEach>
						</table>
					</div>


					<div class="tab-pane" id="wenjuan">


						<p>编辑问卷</p>

						<input class="form-control" placeholder="问卷标题"> <input
							class="form-control" placeholder="感谢您能抽出几分钟时间来参加本次答题，现在我们就马上开始吧！">
						<p>内容</p>
						<textarea name="a" style="width: 750px; height: 300px;"></textarea>
						<input class="form-control" placeholder="您已完成本次问卷，感谢您的帮助与支持">
						<div style="text-align: center">
							<button>发布</button>
							<button>返回</button>
						</div>

					</div>

				</div>


			</div>

		</div>
	</div>

</body>
<script src="./lib/bootstrap-3.3.0/js/tests/vendor/jquery.min.js"></script>
<script src="./lib/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>

</html>