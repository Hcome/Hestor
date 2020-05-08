<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>企业资产管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="static/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="static/css/font.css">
<link rel="stylesheet" href="static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="static/js/xadmin.js"></script>
</head>
<body>
    <div class="x-body" >
        <form id="form1" class="layui-form">
			<div class="layui-form-item">
				<div class="layui-form-item">
					<label for="username" class="layui-form-label" style="width: 100px">
						<span class="x-red">*</span>选择商场名称：
					</label>
					<div class="layui-form-item">
						<input type="text" id="username" name="userName" required=""
							lay-verify="required" autocomplete="off" class="layui-input"
							list="list">
						<datalist id="list">
							<option selected="selected">台州万达</option>
							<option>苍山万达</option>
						</datalist>
					</div>
				</div>

				<div class="layui-input-inline">
					<label for="L_repass" class="layui-form-label"> </label>
					<button type="button"  class="layui-btn" lay-filter="add" lay-submit="">
						查询</button>
				</div>
			</div>
		</form>
      	<br>
		<div class="layui-form-item">
				<label for="username" class="layui-form-label">公司可用资产
				</label>
				<div class="layui-input-inline">
					<input type="text" id="username1" value="" class="layui-input">
				</div>
				<span>元</span>
		</div>
    </div>
    <script type="text/javascript">
    	$(function(){
    		$(".layui-btn").on("click",function(){
    			var username = $("#username").val();
    			console.log(username);
       			$.ajax({
       				type:"POST",
       				url:"<%=basePath%>account/accountAllUse.do",
    				dateType : "text",
    				data:{
    					makectName:username
    				},
    				success : function(info) {
    					console.log(info)
    					 $("#username1").val(info);
    				},
    				error : function() {
    					layer.msg("商场名字不能为空", {
    						icon : 2
    					})
    				}
    			});		
    		});
		});	
	</script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>
