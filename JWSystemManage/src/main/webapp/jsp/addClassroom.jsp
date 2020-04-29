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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加教室</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>classroom/addClassroom">  
      <div class="form-group">
        <div class="label">
          <label>教室名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="classRoomName" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教室容纳人数：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="classRoomNumber"  />
          <div class="tips"></div>
        </div>
      </div>     
      
        <div class="form-group">
        <div class="label" >
          <label>教室使用状态：</label>
        </div>
        <div class="field" style="display: inline;">
          <input type="text" class="input w50" th:field="*{input}" placeholder="请选择教室的使用状态"  list="listItem" name="classRoomStutas"/>
          <datalist id="listItem">
	        <option>在用</option>
	        <option>空闲</option>
		</datalist> 
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">添加</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>