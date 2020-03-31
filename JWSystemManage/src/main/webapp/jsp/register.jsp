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
	    <title>Login</title>
	    
	    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>static/js/hrms.js" type="text/javascript"></script>
		
		<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
	    <link href="<%=basePath%>static/css/admin.css" type="text/css" rel="stylesheet">
	    <link href="<%=basePath%>static/css/hrms.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="bg"></div>
		<div class="container">
		    <div class="line bouncein">
		        <div class="xs6 xm4 xs3-move xm4-move">
		            <div style="height:60px;"></div>
		            <div class="media media-y margin-big-bottom"></div>         
		            <form method="post">
			            <div class="panel loginbox">
			                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
			                <div id="errorMessage" class="text-center" style="color: red;"></div>
			                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="text" class="input input-big" name="userName" placeholder="注册账号" data-validate="required:请填写账号" />
			                            <span class="icon icon-user margin-small"></span>
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="password" id="pwd" class="input input-big" name="userPassword" placeholder="输入密码" data-validate="required:请填写密码" />
			                            <span class="icon icon-key margin-small"></span>
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="password" id="pwd1" class="input input-big" name="userPassword1" placeholder="确认密码" data-validate="required:请填写密码" />
			                            <span class="icon icon-key margin-small"></span>
			                        </div>
			                    </div>
			                </div>
			                <div style="padding:10px;">
			                	<input type="button" id="registerButton" class="button button-block bg-main text-big input-big" value="注册">
			                </div>
			                <div class="form-group" style="padding:10px;">
								<div style="float:right;"><a href="<%=basePath%>sys/gologin">登录</a></div>
							</div>
			            </div>
		            </form>          
		        </div>
		    </div>
		</div>
	</body>
	<style>
		
		
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			
			/*
			 * 用户注册
			 */
			$("#registerButton").bind("click", function() {
				//获取输入的密码，确认密码
				var val = $("#pwd").val();
				var val1= $("#pwd1").val();
		        if(val != val1){
		        	$("#errorMessage").text("两次密码不一致！");
		        }else{
		        	var user = {};
		        	user.userName = $("[name='userName']").val();//获取输入的账号
		        	user.userPassword = $("[name='userPassword']").val();//获取输入的密码
		        	/* user.rememberMe = $("[name='rememberMe']").prop('checked'); */
		        	$.ajax({
		        		url : "<%=basePath%>sys/register",
		        		type : "post",
		        		contentType: "application/json",
		        		data : JSON.stringify(user),
		        		success : function (data) {
		        			if (data.status == 200) {
		        				location.href = "<%=basePath%>sys/gologin";
		        			} else if(data.status == 400){
		        				$("#errorMessage").text(data.message);
		        			}else{
		        				$("#errorMessage").text(data.message);
		        			}
		        		},
		        		error : function (data) {
		        			$("#errorMessage").text(data.responseText);
		        		}
		        	});
		        }
			});
		});
	
		
	</script>
</html>