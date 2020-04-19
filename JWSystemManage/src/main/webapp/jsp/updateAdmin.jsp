 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>管理员基本信息修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>admin/updateAdmin">  
      <div class="form-group">
        <div class="label">
          <label>管理员工号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.getAdminNum()}" name="adminNum" readonly="readonly"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>管理员姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.adminName}" name="adminName"  />
          <div class="tips"></div>
        </div>
      </div>     
      
       <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.adminAge}" name="adminAge" />
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>管理员电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.adminTel}" name="adminTel"  />
          <div class="tips"></div>
        </div>
      </div>     
       <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.adminGender}" name="adminGender"/>
          <div class="tips"></div>
        </div>
      </div>     
     
       <div class="form-group">
        <div class="label">
          <label>管理员邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.adminEmail}" name="adminEmail" />
          <div class="tips"></div>
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">修改</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>