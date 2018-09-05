<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginIn.do" method="post">
		<div style="position: absolute; width: 100%; height: 100%;">
			<img src="./tupian/1531128105.jpg"  style="position:absolute;width:100%;height:100%;"/>
			<div
				style="border-radius: 20px; background: gray; width: 850px; height: 350px; margin: auto; position: absolute; top: 60px; left: 0; right: 0; bottom: 0;">


				<div style="text-align: center;">
					<h1>
						<a style="color: black; text-decoration: none;">用户登录</a>
					</h1>
				</div>

				<div>
					<div>
						<input style="text-align: center; height: 40px; width: 845px"
							name="username" class="form-control" placeholder="请输入手机号/邮箱账号">
						<br> <br> <br> <input
							style="text-align: center; height: 40px; width: 845px"
							name="userpassword" type="password" class="form-control"
							placeholder="请输入密码"> <br> <br> <br> <a
							href="${pageContext.request.contextPath}/goToZhuce.do"
							style="text-align: right; text-decoration: none;">没有账户?创建一个账户</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<div style="text-align: center">
							<select
								style="border-radius: 10px; width: 200px; height: 30px; width: auto; padding: 0 2%; margin: 0;"
								name="select">
								<option style="text-align: center;" value="用户">用户</option>
								<option style="text-align: center;" value="信息录入员">信息录入员</option>
								<option style="text-align: center;" value="管理员">管理员</option>
							</select>
						</div>
						<br>
						<button type="submit"
							style="border-color: #07192f; height: 40px; width: 800px; background: #07192f; margin-left: 20px; margin-right: 20px">登录</button>


					</div>
				</div>


			</div>

		</div>
	</form>
</body>
</html>