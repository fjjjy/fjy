<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>登录账号</title>

<%--<link rel="stylesheet" type="text/css" href="static/Login.css"/>--%>
	<style type="text/css">
		html{
			width: 100%;
			height: 100%;
			overflow: hidden;
			font-style:normal;
		}

		body{
			width: 100%;
			height: 100%;
			font-family: 'Open Sans',sans-serif;
			margin: 0;
            background: url(111.png);
			background-size: 100% 100%;
		}
		#login{
			position: absolute;
			top: 50%;
			left:50%;
			margin: -150px 0 0 -150px;
			width: 300px;
			height: 300px;
		}

		#login h1{
			color: #fff;
			text-shadow:0 0 10px;
			letter-spacing: 1px;
			text-align: center;
		}

		h1{
			font-size: 2em;
			margin: 0.67em 0;
		}


		input{
			width: 278px;
			height: 20px;
			margin-bottom: 10px;
			outline: none;
			padding: 10px;
			font-size: 13px;
			color: #fdfdfd;
			/*text-shadow:1px 1px 1px;*/
			border-top: 1px solid #312E3D;
			border-left: 1px solid #312E3D;
			border-right: 1px solid #312E3D;
			border-bottom: 1px solid #56536A;
			border-radius: 4px;
			background-color: #2D2D3F;
		}
		.but{
			width: 300px;
			min-height: 20px;
			display: block;
			background-color: #4089d7;
			border: 1px solid #3762bc;
			color: #fff;
			padding: 9px 14px;
			font-size: 15px;
			line-height: normal;
			border-radius: 5px;
			margin: 0;
			float: left;
		}
		.but1{
			width: 300px;
			min-height: 20px;
			display: block;
			background-color: #4089d7;
			border: 1px solid #3762bc;
			color: #fff;
			padding: 9px 14px;
			font-size: 15px;
			line-height: normal;
			border-radius: 5px;
			margin: 10px 0;
			float: left;
		}
		a{
			 text-decoration: none;
		}

	</style>
</head>
<body>
	<div id="login">  
	
	<h1>登录账号</h1>  
	<form method="post" action="LoginServet">   <%-- post方法提交参数，提交到后端--%>
            <%--@declare id="password"--%><input type="text" required="required" placeholder="用户名" name="u"></input>
            <input type="password" required="required" placeholder="密码" name="p"></input>  

		<button class="but" type="submit">登录</button>
            <label for="password">
				<button class="but1" type="submit"> <a href="register.jsp" style="color:#ffffff;">注册</a></button>

			</label>
    </form>  
	
	<br/>
			<label>
<%--                  提示语--%>
				<%
				String state = (String) session.getAttribute("A2");
							 session.removeAttribute("A2");
				if(state!=null){
					out.print(state);
				}

				%>

			</label>
	</div>
</body>
</html>