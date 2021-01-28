<%@page import="com.offcn.entity.Student"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table,form{
		width: 500px;
		margin: auto;
		text-align: center;
	}
	div{
		width: 500px;
		margin: auto;
		text-align: right;
	}
</style>
</head>
<body>
	<a href='add.html'>新增学生</a>
	
	<form action="StudentServlet" method="post">
		<input type="hidden" name="flag" value="getStuBySname"/>
		学生姓名：<input type="text" name="sname"/>
		<input type="submit" value="搜索">
	</form>
	<br/>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<%-- <%
			List<Student> list = (List<Student>)request.getAttribute("stuList");
			for(Student stu:list){
		%>
			<tr>
				<td><%=stu.getSid() %></td>
				<td><%=stu.getSname() %></td>
				<td><%=stu.getSage() %></td>
				<td><%=stu.getSsex() %></td>
				<td><%=stu.getSemail() %></td>
				<td>
					<a href="StudentServlet?flag=delStuBySid&sid=<%=stu.getSid()%>">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="StudentServlet?flag=getStuBySid&sid=<%=stu.getSid()%>">修改</a>
				</td>
			</tr>
		<% 
			}
		%> --%>
		
		<c:forEach var="stu" items="${stuList }">
			<tr>
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.sage }</td>
				<td>${stu.ssex }</td>
				<td>${stu.semail }</td>
				<td>
					<a href="StudentServlet?flag=delStuBySid&sid=${stu.sid }">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="StudentServlet?flag=getStuBySid&sid=${stu.sid }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="">首页</a>
		<a href="">上一页</a>
		1/20
		<a href="">下一页</a>
		<a href="">尾页</a>
	</div>
</body>
</html>