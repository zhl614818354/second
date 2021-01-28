<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生管理系统-修改学生</title>
<style type="text/css">
	form{
		width: 300px;
		height:  300px;
		border: 1px solid black;
		text-align: center;
		margin: auto;
	}
</style>
</head>
<body>
	<form action="StudentServlet" method="post">
		<input type="hidden" name="flag" value="updateStu">
		<input type="hidden" name="sid" value="${stu.sid }">
		<h2>学生管理系统-修改学生</h2>
		姓名：<input type="text" name="sname" value="${stu.sname }"/><br/><br/>  
		年龄：<input type="text" name="sage" value="${stu.sage }"/><br/><br/> 
		
		性别：<input type="radio" name="ssex" value="男" ${stu.ssex eq '男'?'checked':''}/>男
		<input type="radio" name="ssex" value="女" ${stu.ssex eq '女'?'checked':''}/>女<br/><br/> 
		
		邮箱：<input type="text" name="semail" value="${stu.semail }"/><br/><br/> 
		<input type="submit"/>
	</form>
</body>
</html>