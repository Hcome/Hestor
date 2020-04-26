<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>


<meta charset="UTF-8">
<title>xxx管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="<%=basePath %>static/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath %>static/css/font.css">
<link rel="stylesheet" href="<%=basePath %>static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src=""<%=basePath %>static/js/xadmin.js"></script>
<script src="<%=basePath %>static/lib/layui/layui.all.js" charset="utf-8"></script>

<script type="text/javascript">
	//文档加载事件
	$(function(){
		//alert("你好")
		//使用ajax去将后台查询的的数据取出来
		$.ajax({
			type:"POST",
			url:"<%=basePath%>sys/getCookies.ajax",
			//返回值得类型
			dataType:"text",
			//设置发送到后台的值(通过键值对的形式发送到后台)
			data:{
				
			},
			//成功的回调函数
			success:function(info){
				//将字符串对象转化成js对象
				var user = JSON.parse(info);
				//通过jQUery的id选择器赋值
				$("#username").val(user.userName)
				$("#password").val(user.passWord);
				//判断复选框是否勾选
				if(user.username != ''){
					$("#memoryuser").prop("checked",true);
				}else{
					$("#memoryuser").prop("checked",false);
				}
			},
			//失败的回调函数
			error:function(){
				//使用layui的打印信息(必须引入jayui才可以使用)
				layer.msg("ajax请求失败！",{icon:2});
				
			}
		});
	});
</script>
<script type="text/javascript">
	//如果该页面在iframe中出现，那么会自动调用最外层窗口刷新本链接
	if (window != top) {
		top.location.href = location.href;
	}
</script>
<script type="text/javascript">
	function checkLogin(){
		//拿到输入框的值
		var username = $("#username").val();
		var password = $("#password").val();
		//拿到复选框的状态
		var checkObj = $("#memoryuser").prop("checked");
		
		if(username.length == 0){
			layer.msg("用户名不能为空",{icon:2})
		}
		if(password.length == 0){
			layer.msg("密码不能为空",{icon:2})
		}
		/* alert(checkObj);
		alert(typeof(checkObj)); */
		//给定一个变量值来区分是否被选中
		var remember = "NO";
		if(checkObj){
			//表示被选中了
			remember = "YES";
		}
		
		//下面使用ajax来完成访问后台登录验证 使用的jQuery封装的ajax  (外面的公司使用另外一些前端js框架来封装ajax 比如现在最火的js框架：vue.js)
		$.ajax({//键值对来表示设置的属性
			//设置请求方式
			type:"POST",
			//设置请求后台的哪个url
			url:"<%=basePath%>sys/login.ajax",
			//设置返回值类型
			dataType:"text",
			//设置发送到后台的值(通过键值对的形式发送到后台)
			data:{
				userName:username,
				passWord:password,
				checkbox:remember
			},
			//成功的回调函数
			success:function(info){
				if(info == "ERROR"){
					layer.msg("用户名或者密码错误！",{icon:2})
				}else{
					//跳转到主页面，最好是后台跳转
					window.location.href = "<%=basePath%>sys/index.ajax"
				}
			},
			//失败的回调函数
			error:function(){
				//使用layui的打印信息(必须引入jayui才可以使用)
				layer.msg("ajax请求失败！",{icon:2});
				
			}
			
			
			
			
			
		});
		
	}

</script>

</head>
<body class="login-bg">

	<div class="login" >
		<div class="message">XXX管理系统-用户登录</div>
		
		<font  id="error" size="15" class="text-align:center" color="red"></font>
		<div id="darkbannerwrap"></div>
		<form  class="layui-form">
			<input id="username" placeholder="用户名" type="text" 
				class="layui-input">
			<hr class="hr15">
			<input id="password" placeholder="密码" type="password"
				class="layui-input">
			<hr class="hr15">
			<input lay-submit lay-filter="login" style="width: 100%;"
				type="button" value="登录" onclick="checkLogin()" />
			<hr class="hr20">
		</form>
		<input type="checkbox" id="memoryuser"  >&nbsp;30天内自动登录
	</div>

</body>
</html>
