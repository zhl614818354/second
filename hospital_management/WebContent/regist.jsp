<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
    <title>优就业-线医疗管理系统</title>
	<meta charset="UTF-8">
	<link rel="icon" href="Images/logo_favicon.ico" type="image/x-icon" />
   <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="Js/jquery.validate.js"></script>
    <script type="text/javascript" src="Js/messages_zh.js"></script>
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: "微软雅黑";
            background-color: buttonhighlight;
        }

        .form-signin {
            max-width: 600px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            background: rgba(255,255,255,0.5);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
            font-size: 24px;
            margin-left: 90px;
        }
        
        .form-signin .form-signin-heading{
        	margin-bottom: 10px;
            font-size: 24px;
            margin-left: 200px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
		
		
		#message{
			font-size: 14px;
			color:red;
			margin-left: 40px;
		}
		
		.input-block-level{
			width: 300px;
			margin-left: 40px;
		}
		.input-medium{
			margin-left: 40px;
		}
		.code_images{
			width: 115px;
			height: 35px;
			margin-top: -15px;
			margin-left: 10px;
		}
		.error{
			color: red;
			font-size: 14px;
		}
		
    </style> 
    
	<script type="text/javascript">
		$(function(){
			$("form").validate({
				rules:{
					"username":{
						required:true,
						rangelength:[6,12],
						remote:{
							url:"UserServlet",
							type:"post",
							dataType:"json",
							data:{
								"flag":"checkUsername",
								"name":function(){
									return $("input[name=username]").val();
								}
							}
						}
					},
					"pwd":{
						required:true,
						rangelength:[8,14]
					},
					"pwd2":{
						equalTo:"#pwd"
					},
					"uname":{
						required:true
					},
					"email":{
						required:true,
						email:"email",
						remote:{
							url:"UserServlet",
							type:"post",
							dataType:"json",
							data:{
								"flag":"checkEmail",
								"email":function(){
									return $("input[name=email]").val();
								}
							}
						}
					}
				},
				messages:{
					"username":{
						required:"账号不能为空哦",
						rangelength:"账号是6-12位字符哦",
						remote:"账号已被占用"
					},
					"pwd":{
						required:"密码不能为空哦",
						rangelength:"密码是8-14位字符哦"
					},
					"pwd2":{
						equalTo:"两次密码输入必须一致哦"
					},
					"uname":{
						required:"姓名不能为空哦"
					},
					"email":{
						required:"邮箱不能为空哦",
						email:"邮箱格式不正确哦",
						remote:"邮箱已被占用"
					}
				},
				submitHandler:function(){//数据验证成功以后执行的方法
					//利用Ajax进行注册操作
					$.post("UserServlet",$("form").serialize(),function(obj){
						if(obj){
							//注册成功
							alert("注册成功，即将跳转至登录页面");
							location.href="login.jsp";
						}else{
							alert("注册失败，请稍后重试");
						}
					},"json");
				}
			});
		});
	</script>
</head>
<body>
<div class="container">	
    <form class="form-signin" >
    	<input type="hidden" name="flag" value="regist">
        <h2 class="form-signin-heading" >管理员注册</h2>
                        账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：
		<input type="text" name="username" class="input-block-level" placeholder="账号">
		<br/>
                        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
        <input id="pwd" type="password" name="pwd" class="input-block-level" placeholder="密码">
        <br/>
                       确认密码：<input type="password" name="pwd2" class="input-block-level" placeholder="确认密码">
        <br/>
                        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" id="uname" name="uname" class="input-block-level" placeholder="姓名">
        <br/>
                        邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" id="email" name="email" class="input-block-level" placeholder="邮箱">
        <br/>               
        <p style="text-align: center;">
        <input id="regist" type="submit" value="注册" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input id="reset" type="reset" value="清空" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        </p>
    </form>
</div>
</body>
</html>