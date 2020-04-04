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
			                <div class="text-center margin-big padding-big-top"><h1>英语考试系统后台管理中心</h1></div>
			                <div id="errorMessage" class="text-center" style="color: red;"></div>
			                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="text" class="input input-big" name="userName" placeholder="登录账号" data-validate="required:请填写账号" />
			                            <span class="icon icon-user margin-small"></span>
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="password" class="input input-big" name="userPassword" placeholder="登录密码" data-validate="required:请填写密码" />
			                            <span class="icon icon-key margin-small"></span>
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <div class="field">
			                            <input type="text" class="input input-big input-val" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
			                        	<canvas id="canvas" width="100" height="43"></canvas>
			                        </div>
			                    </div>
			                </div>
			                <div style="padding:10px;">
			                	<input type="button" id="loginButton" class="button button-block bg-main text-big input-big" value="登录">
			                </div>
			                <div class="form-group" style="padding:10px;">
								<label for="rememberMe" style="font-weight:100;">
									<input type="checkbox" name="rememberMe"> Remember Me
								</label>
								<div style="float:right;"><a href="<%=basePath%>sys/goregister">注册</a></div>
							</div>
			            </div>
		            </form>          
		        </div>
		    </div>
		</div>
	</body>
	<style>
		.input-val {
	        float: left;
	        width: 225px!important;;
	        background: #ffffff;
	        height: 45px!important;;
	        padding: 0 2%;
	        border-radius: 5px;
	        border: none;
	        border: 1px solid rgba(0,0,0,.2);
	    }
		#canvas {
	        float: right;
	        display: inline-block;
	        border: 1px solid #ccc;
	        border-radius: 5px;
	        cursor: pointer;
	    }
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			var show_num = [];//用来接收画的验证码
		    draw(show_num);
	
		    $("#canvas").on('click',function(){
		        draw(show_num);
		    })
		    
			/*
			 * 用户登录
			 */
			$("#loginButton").bind("click", function() {
				//获取验证码输入框的值
				var val = $(".input-val").val().toLowerCase();
				
		        var num = show_num.join("");//将js数组以指定分隔符加入到字符串中[A,B,C,B]-->ABCB
		        if(val==''){
		        	$("#errorMessage").text("请输入验证码！");
		        }else if(val != num){
		        	$("#errorMessage").text("验证码错误！请重新输入！");
		            $(".input-val").val('');//将验证码输入框清空
		            draw(show_num);
		        }else{//验证码输入正确，开启登录操作
		        	var user = {};
		        	user.userName = $("[name='userName']").val();//获取输入的账号
		        	user.userPassword = $("[name='userPassword']").val();//获取输入的密码
		        	/* user.rememberMe = $("[name='rememberMe']").prop('checked'); */
		        	$.ajax({
		        		url : "<%=basePath%>sys/login",
		        		type : "post",
		        		contentType: "application/json",
		        		data : JSON.stringify(user),
		        		success : function (data) {
		        			if (data.status == 200) {
		        				location.href = "<%=basePath%>sys/index";
		        			}else {
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
	
		function draw(show_num) {
		    var canvas_width=$('#canvas').width();
		    var canvas_height=$('#canvas').height();
		    var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
		    var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
		    canvas.width = canvas_width;
		    canvas.height = canvas_height;
		    var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
		    var aCode = sCode.split(",");
		    var aLength = aCode.length;//获取到数组的长度
		    //验证码是四位数，所以循环四次
		    for (var i = 0; i <= 3; i++) {
		        var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
		        var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
		        var txt = aCode[j];//得到随机的一个内容
		        show_num[i] = txt.toLowerCase();//每次循环产生的验证码的值存放到该数组
		        var x = 10 + i * 20;//文字在canvas上的x坐标
		        var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
		        context.font = "bold 23px 微软雅黑";
	
		        context.translate(x, y);
		        context.rotate(deg);
	
		        context.fillStyle = randomColor();
		        context.fillText(txt, 0, 0);
	
		        context.rotate(-deg);
		        context.translate(-x, -y);
		    }
		    for (var i = 0; i <= 5; i++) { //验证码上显示线条
		        context.strokeStyle = randomColor();
		        context.beginPath();
		        context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
		        context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
		        context.stroke();
		    }
		    for (var i = 0; i <= 30; i++) { //验证码上显示小点
		        context.strokeStyle = randomColor();
		        context.beginPath();
		        var x = Math.random() * canvas_width;
		        var y = Math.random() * canvas_height;
		        context.moveTo(x, y);
		        context.lineTo(x + 1, y + 1);
		        context.stroke();
		    }
		}
	
		function randomColor() {//得到随机的颜色值
		    var r = Math.floor(Math.random() * 256);
		    var g = Math.floor(Math.random() * 256);
		    var b = Math.floor(Math.random() * 256);
		    return "rgb(" + r + "," + g + "," + b + ")";
		}
	</script>
</html>