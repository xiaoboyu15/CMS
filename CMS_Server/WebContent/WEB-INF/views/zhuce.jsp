<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>注册</title>
<script type="text/javascript">
	function yanzhen(){
		var userpassword=document.getElementById("userpassword").val();
		var userpassword1=document.getElementById("userpassword1").val();
		if(userpassword1!=userpassword){
			alert("两次输入的密码不同，请重新输入！")
			return false
		}
	}
	function fanhui(){
		parent.location.href = "${pageContext.request.contextPath}/goToIndex.do"; 
	}
</script>
</head>
<body>
	<div style="position: absolute; width: 100%; height: 100%;">
		<img src="tupian/1531128105.jpg"
			style="position: absolute; width: 100%; height: 100%;" />
		<div
			style="border-radius: 20px; background: gray; width: 850px; height: 350px; margin: auto; position: absolute; top: 0; left: 0; right: 0; bottom: 0;">
			<div style="text-align: center;">
				<h1>
					<a style="color: black; text-decoration: none;">用户注册</a>
				</h1>
			</div>
<form action="${pageContext.request.contextPath}/Registered.do"
					method="post" onsubmit="return yanzhen();">
			<div class="tab-pane" id="one">
				
					<div>
						<input style="text-align: center; height: 20px; width: 845px"
							type="" class="form-control" placeholder="请输入用户名" name="username" id="username"> <br>
						<br> <input
							style="text-align: center; height: 20px; width: 845px" type=""
							class="form-control" placeholder="请输入手机号" name="userPhone" id="userPhone"> <br>
						<br> <input
							style="text-align: center; height: 20px; width: 845px" type=""
							class="form-control" placeholder="请输入住址" name="userAddress" id="userAddress"> <br>
						<br> <input
							style="text-align: center; height: 20px; width: 845px"
							type="email" class="form-control" placeholder="请输入邮箱" name="userEmail" id="userEmail"> <br>
						<br> <input
							style="text-align: center; height: 20px; width: 845px"
							type="password" class="form-control" placeholder="请输入密码" name="userpassword" id="userpassword">
						<br>
						<br> <input
							style="text-align: center; height: 20px; width: 845px"
							type="password" class="form-control" placeholder="确认密码" name="userpassword1" id="userpassword1">
						<br>
						<br>
						<button type="submit"
							style="border-color: #07192f; height: 40px; width: 800px; background: #07192f; margin-left: 20px; margin-right: 20px">
							<a style="color: white">注册</a>
						</button>
						<button onclick="fanhui();"
							style="border-color: #07192f; height: 40px; width: 800px; background: #07192f; margin-left: 20px; margin-right: 20px">
							<a style="color: white">返回</a>
						</button>
					</div>
				
				
			</div>
</form>

		</div>

	</div>
</body>
</html>