<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title></title>
<link rel="stylesheet" href="<%=basePath%>static/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
<script src="<%=basePath%>static/js/jquery.js"></script>
<script src="<%=basePath%>static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>user/updateUser">  
    	<input type="hidden" value="${u.userId}" name="userId">
      <div class="form-group">
        <div class="label">
          <label>用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${u.userName}" name="userName" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>    
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>角色：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
	          <c:forEach items="${roles}" var="role">
	           ${role.roleDesc} <input id="ishome"  type="checkbox" name="roleId" value="${role.roleId}" 
	           		<c:forEach items="${u.roles}" var="r">
	           			<c:if test="${r.roleName==role.roleName}">checked</c:if>
	           		</c:forEach>
	           />
	          </c:forEach>
          </div>
        </div>
      </if>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button id="submitCommit" class="button bg-main icon-check-square-o" type="submit">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

<script type="text/javascript">
	
</script>
</body>
</html>