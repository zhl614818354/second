<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=this.getServletContext().getContextPath() %>/doctor/">
    <title>门诊医生</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
    <script type="text/javascript" src="../Js/jquery-3.4.1.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
    	//单条删除
    	function del(did){
    		if(confirm("您确定要删除吗？")){
    			//删除
    			$.post("../DoctorServlet",{"flag":"delDocByDid","did":did},function(obj){
    				if(obj){
    					alert("删除成功！");
    					location.href = "../DoctorServlet?flag=getAllDoctorByPage";
    				}else{
    					alert("删除失败！");
    				}
    			},"json");
    		}
    	}
    	
    	//全选及反选
    	function checkall(){
    		$(".checkone").prop("checked",$("#checkall").prop("checked"));
    	}
    	
    	$(function(){
    		//批量删除
    		$("#delAll").click(function(){
    			//用于保存所有被选中医生编号的数组
    			var dids = new Array();
    			//找到所有被选中的checkone
    			$(".checkone:checked").each(function(){
    				//获取当前被循环的checkone的value属性的值
    				var did = $(this).val();
    				//将获取的did放入dids中
    				dids.push(did);
    			});
    			//判断数组中是否有数据
    			if(dids.length == 0){
    				alert("请选择您要删除的数据");
    			}else{
    				if(confirm("您确定要删除这些数据吗？")){
    					$.post("../DoctorServlet",{"flag":"delDoctors","dids":dids.join()},function(obj){
    						if(obj){
    	    					alert("删除成功！");
    	    					location.href = "../DoctorServlet?flag=getAllDoctorByPage";
    	    				}else{
    	    					alert("删除失败！");
    	    				}
    					},"json");
    				}
    			}
    			
    		});
    		
    		//跳转到添加页面
    		$("#newNav").click(function(){
    			location.href="add.jsp";
    		});
    	});
    </script>
</head>
<body>

<form action="../DoctorServlet" method="post" class="definewidth m20">
<input type="hidden" name="flag" value="getDoctorBySth">
<table class="table table-bordered table-hover definewidth m10">
	<tr>
	  <td width="10%" class="tableleft">医生姓名：</td>
	  <td><input type="text" id="dname" name="dname" value="${dname }"/></td>		
	  <td width="10%" class="tableleft">科室：</td>
	  <td>
	    <select name="department" id="department">
	        <option value="0" >==请选择==</option>
	        <option value="1" ${department==1?'selected':'' }>急诊科</option>
	        <option value="2" ${department==2?'selected':'' }>儿科</option>
	        <option value="3" ${department==3?'selected':'' }>妇科</option>
	        <option value="4" ${department==4?'selected':'' }>皮肤科</option>
	        <option value="5" ${department==5?'selected':'' }>内分泌科</option>
	        <option value="6" ${department==6?'selected':'' }>牙科</option>
        </select>
	  </td>
	</tr>
	<tr>
	  <td colspan="6">
	    <center>
			<input id="find" name="find" type="submit" class="btn btn-primary" value="查询"/>
			<input id="ret" name="ret" type="button" class="btn btn-primary" value="清空"/>
		</center>
	  </td>
	 </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>医生编号</th>
        <th>医生姓名</th>
        <th>联系方式</th>
        <th>所属科室</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    	 <c:forEach var="d" items="${list }">
    	 	<tr>
	    	 	<td><input type="checkbox" value="${d.did }" class="checkone"></td>
	    	 	<td>${d.did }</td>
	    	 	<td>${d.dname }</td>
	    	 	<td>${d.phone }</td>
	    	 	<td>
	    	 		<c:if test="${d.department==1 }">急诊科</c:if>
	    	 		<c:if test="${d.department==2 }">儿科</c:if>
	    	 		<c:if test="${d.department==3 }">妇科</c:if>
	    	 		<c:if test="${d.department==4 }">皮肤科</c:if>
	    	 		<c:if test="${d.department==5 }">内分泌科</c:if>
	    	 		<c:if test="${d.department==6 }">牙科</c:if>
	    	 	</td>
	    	 	<td>
	    	 		<a href="javascript:del(${d.did })">删除</a>
	    	 		<a href="../DoctorServlet?flag=getDocByDid&did=${d.did }&type=edit">编辑</a>
	    	 		<a href="../DoctorServlet?flag=getDocByDid&did=${d.did }&type=look">详情</a>
	    	 	</td>
    	 	</tr>
    	 </c:forEach>
	</tbody>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr>
  		<th colspan="5">  <div class="inline pull-right page">
          <a href='../DoctorServlet?flag=getDoctorBySth&page=1&dname=${dname }&department=${department}' >首页</a> 
          
          <a href='../DoctorServlet?flag=getDoctorBySth&page=${pu.prevPage }&dname=${dname }&department=${department}'>上一页</a>
          
          <a href='../DoctorServlet?flag=getDoctorBySth&page=${pu.nextPage }&dname=${dname }&department=${department}'>下一页</a> 
          
          <a href='../DoctorServlet?flag=getDoctorBySth&page=${pu.countPage }&dname=${dname }&department=${department}'>尾页</a>
          
		  &nbsp;&nbsp;&nbsp;共<span class='current'> ${pu.countRows } </span>条记录
		  <span class='current'> ${pu.page }/${pu.countPage } </span>页
		  
		  </div>
		 <div>
		 <button type="button" class="btn btn-success" id="newNav">添加新医生</button>
		 <button type="button" class="btn btn-success" id="delAll">批量删除</button>
		 </div>
		 
		 </th>
	</tr>
  </table>  
</body>
</html>
