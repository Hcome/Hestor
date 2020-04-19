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

<style type="text/css">
	
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加题目</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>test/getTestTypeName">  
      <div class="form-group">
        <div class="label" >
          <label>题目类型：</label>
        </div>
        <div class="field" style="display: inline;">
          <input type="text" class="input w50" th:field="*{input}" placeholder="请选择题目类型"  list="listItem" name="listItem"/>
          <datalist id="listItem">
	        <option>选择题</option>
	        <option>填空题</option>
	        <option>阅读理解</option>
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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改题目</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>test/getTestTypeName">  
      <div class="form-group">
        <div class="label" >
          <label>题目类型：</label>
        </div>
        <div class="field" style="display: inline;">
          <input type="text" class="input w50" th:field="*{input}" placeholder="请选择题目类型"  list="listItem" name="testTypeNsme"/>
          <datalist id="listItem">
	        <option>选择题</option>
	        <option>填空题</option>
	        <option>阅读题</option>
		</datalist> 
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