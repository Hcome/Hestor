<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="<%=basePath%>static/css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
    <script src="<%=basePath%>static/js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="<%=basePath%>static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />英语考试系统后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="<%=basePath%>sys/gologin"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <shiro:hasAnyRoles name="student,admin,teacher">
  <h2><span class="icon-user"></span>用户信息中心</h2>
  <ul style="display:block">
  	<shiro:hasAnyRoles name="admin,teacher,student">
  		<li><a href="<%=basePath%>sys/goQueryUserIsAdminInfo" target="right"><span class="icon-caret-right"></span>个人信息查询</a></li>
  	</shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="admin">
    	<li><a href="<%=basePath%>user/goQueryUser" target="right"><span class="icon-caret-right"></span>查看用户信息</a></li>
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="admin">
       <li><a href="<%=basePath%>user/goQueryUsersAndRoles" target="right"><span class="icon-caret-right"></span>未分配角色列表</a></li> 
    </shiro:hasAnyRoles>
  </ul>
  </shiro:hasAnyRoles>
  <shiro:hasAnyRoles name="admin,teacher">   
  <h2><span class="icon-user"></span>管理员信息中心</h2>
  <ul>
  	<shiro:hasAnyRoles name="admin,teacher,student">
  		<li><a href="<%=basePath%>admin/goQueryAdmin" target="right"><span class="icon-caret-right"></span>管理员列表</a></li>
  	</shiro:hasAnyRoles>
    <li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加老师</a></li>        
  </ul>
  </shiro:hasAnyRoles>
  <shiro:hasAnyRoles name="admin,teacher">   
  <h2><span class="icon-user"></span>教师信息中心</h2>
  <ul>
  	<shiro:hasAnyRoles name="admin,teacher,student">
  		<li><a href="<%=basePath%>teacher/goQueryTeacher" target="right"><span class="icon-caret-right"></span>查看老师</a></li>
  	</shiro:hasAnyRoles>
    <li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加老师</a></li>        
  </ul>
  </shiro:hasAnyRoles>
  <shiro:hasAnyRoles name="admin">
  	<h2><span class="icon-user"></span>学生信息中心</h2>
  <ul>
  	<!-- 给查看学生赋予权限 -->
  	<shiro:hasAnyRoles name="admin,teacher,student">
  		<li><a href="<%=basePath%>student/goQueryStudent" target="right"><span class="icon-caret-right"></span>查看学生</a></li> 
  	</shiro:hasAnyRoles>
  	<li><a href="add.html" target="right"><span class="icon-caret-right"></span>添加学生</a></li> 
  </ul> 
  </shiro:hasAnyRoles>
  <shiro:hasAnyRoles name="admin">
  	<h2><span class="icon-pencil-square-o"></span>题库管理中心</h2>
  <ul>
  	<!-- 给查看学生赋予权限 -->
  	<shiro:hasAnyRoles name="admin,teacher">
  		<li><a href="<%=basePath%>student/goQueryStudent" target="right"><span class="icon-caret-right"></span>试题中心</a></li> 
  	</shiro:hasAnyRoles>
  	<li><a href="add.html" target="right"><span class="icon-caret-right"></span>试卷中心</a></li> 
  </ul> 
  </shiro:hasAnyRoles>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="<%=basePath%>jsp/index.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a href="<%=basePath%>jsp/info.jsp" id="a_leader_txt">网站信息</a></li>
  	  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-user">&nbsp;&nbsp;当前用户：&nbsp;&nbsp;欢迎你：&nbsp;&nbsp;${sessionScope.userName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-user"><c:forEach items="${sessionScope.roles}" var="item">角色：&nbsp;&nbsp;${item.getRoleDesc()}</c:forEach></span></li>

</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="<%=basePath%>jsp/info.jsp" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>