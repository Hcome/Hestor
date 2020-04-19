 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>static/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
<script src="<%=basePath%>static/js/jquery.js"></script>
<script src="<%=basePath%>static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>你的基本信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="sys/selectStudent">
    <div class="form-group">
        <div class="label">
          <label>你的用户名：</label>
        </div>
        <div class="field">
          ${studentUser.getUserName()}
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label>你的身份：</label>
        </div>
        <div class="field">
           <c:forEach items="${roles}" var="item" begin="0" end="1">
          	  ${item.getRoleDesc()}
           </c:forEach>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>你的学号：</label>
        </div>
        <div class="field">
          ${studentUser.getStudent().getStudentNum()}
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>你的姓名：</label>
        </div>
        <div class="field">
          ${studentUser.getStudent().getStudentName()}
          <div class="tips"></div>
        </div>
      </div>     
      
       <div class="form-group">
        <div class="label">
          <label>你的性别：</label>
        </div>
        <div class="field">
          ${studentUser.getStudentGender()}
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>你的年龄：</label>
        </div>
        <div class="field">
          ${studentUser.getStudent().getStudentAge()}
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>你的电话：</label>
        </div>
        <div class="field">
          ${studentUser.getStudent().getStudentTel()}
          <div class="tips"></div>
        </div>
      </div>     
     
       <div class="form-group">
        <div class="label">
          <label>你的邮箱：</label>
        </div>
        <div class="field">
          ${studentUser.getStudent().getStudentEmail()}
          <div class="tips"></div>
        </div>
      </div>  
    </form>
  </div>
</div>
</body>
</html>