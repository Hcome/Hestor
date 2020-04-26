<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>欢迎进入本系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="<%=basePath%>static/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath%>static/css/font.css">
<link rel="stylesheet" href="<%=basePath%>static/css/xadmin.css">
<link rel="stylesheet" href="<%=basePath%>static/css/cutsom-style.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="x-body">
		<blockquote class="layui-elem-quote">欢迎进入企业资产管理系统！v1.0；登录时间：${LOGINTIME }；</blockquote>
		<fieldset class="layui-elem-field">
			<legend>信息总览</legend>
			<div class="layui-field-box">
				<table class="layui-table">
					<thead>
						<tr>
							<th colspan="2" scope="col">您的账户信息</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th width="30%">您的账号</th>
							<td><span>${user.accountNumber }</span></td>
						</tr>
						<tr>
							<td>您的姓名</td>
							<td>${user.userName }</td>
						</tr>
						<tr>
							<td>您的登录时间</td>
							<td>${LOGINTIME }</td>
						</tr>
						<tr>
							<td>您的浏览器信息</td>
							<td id="browserVersion"></td>
						</tr>
						<tr>
							<td>您的IP地址</td>
							<td>${userIp }</td>
						</tr>
					</tbody>
				</table>
				<table class="layui-table">
					<thead>
						<tr>
							<th colspan="2" scope="col">服务器信息</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th width="30%">本系统访问路径</th>
							<td><span id="lbServerName"><%=basePath %></span></td>
						</tr>
						<tr>
							<td>服务器名称</td>
							<td>${serverName }</td>
						</tr>
						<tr>
							<td>服务器ip地址</td>
							<td>${localIp }</td>
						</tr>
						<tr class="spanLinkTr">
							<td>当前在线人数</td>
							<td><span id="sasd">加载中...</span>&nbsp; <span id="ronBtn" onclick="reOnlineNum()" class="spanLink">点击刷新</span>
							</td>
						</tr>
						<tr>
							<td>登录超时时间</td>
							<td>${timeout }秒</td>
						</tr>
						<tr class="spanLinkTr">
							<td>服务器当前时间</td>
							<td><span id="st">加载中...</span>&nbsp; <span id="rstBtn"
								onclick="reServerTime()" class="spanLink">点击刷新</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
		<!-- 示例：调用父窗口的某个方法 -->
		<blockquote class="layui-elem-quote layui-quote-nm">
			本系统前端框架支持：X-admin（<a
				onclick="parent.x_admin_show('X-admin主页','http://x.xuebingsi.com/')">http://x.xuebingsi.com/</a>）；
			前端框架整合：舒松（ss112476@163.com）； 项目开发：企业资产管理系统（<a
				onclick="parent.x_admin_show('企业资产管理系统主页','http://localhost:8080/00.08_AssetsManagementSystem/indexController/entryIndex.do')">http://localhost:8080/00.08_AssetsManagementSystem/indexController/entryIndex.do</a>）java
			EE项目组
		</blockquote>
	</div>
</body>
<script type="text/javascript">
	//页面初始化方法
	function showBrowserVersion() {
		var userAgent = window.navigator.userAgent;
		$("#browserVersion").text(userAgent);
	}

	function reServerTime() {
		$("#rstBtn").attr("disabled", "disabled");
		$("#rstBtn").css("display", "none");
		//执行获取服务器时间的方法……
		$.ajax({
			type:"POST",
			url:"indexController/getServerTime.ajax",
			data:{
				
			},
			dataType:"text",
			success:function(result){
				$("#st").text(result);
			},
			error:function(){
				$("#st").text("获取失败");
			}
		});
		//回弹按钮
		setTimeout("popRstBtn()", 5000);
	}

	function popRstBtn() {
		$("#rstBtn").removeAttr("disabled");
		$("#rstBtn").css("display", "inline");
	}

	function reOnlineNum() {
		$("#ronBtn").attr("disabled", "disabled");
		$("#ronBtn").css("display", "none");
		//执行获取在线人数的方法……
		$.ajax({
			type:"POST",
			url:"indexController/OnlineNum.ajax",
			data:{
				
			},
			dataType:"text",
			success:function(ifo){
				$("#sasd").text(ifo);
			},
			error:function(){
				$("#sasd").text("获取失败");
			}
		});
		//回弹按钮
		setTimeout("popRonBtn()", 1000);
	}

	function popRonBtn() {
		$("#ronBtn").removeAttr("disabled");
		$("#ronBtn").css("display", "inline");
	}

	$(function() {
		showBrowserVersion();
		reOnlineNum();
		reServerTime();
	});
</script>
</html>