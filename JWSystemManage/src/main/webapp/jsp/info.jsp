<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<form action="" method="post">
		<div>
			<span><h1>XXX学校期末英语考试</h1></span>
		</div>
		<div class="row-fluid">
			<div class="span7" ontablet="span12" ondesktop="span7">
				<div class="row-fluid">
					<div>
						<h2>考试须知：</h2>
					</div>
					<div>
						<p>
							1，必须按规定时间入场，开始入场15分钟后，禁止入场。入场时，考生须主动出示学生证及有效身份证件，并按要求在考场座位表上签名。<br />
							2，考生进场只能携带必要文具，如草稿纸、黑色签字笔，耳机。禁止携带任何资料，手机等通讯工具入场，考场内不得擅自相互借用文具。<br />
							3，入场后，要对号入座，将本人准考证以及有效身份证件放在课桌上，以便核验。<br />
							4，考前检查计算机有无问题，比如说声音是否正常，题目是否正确显示，如有问题及时向监考员反应。<br />
							5，答题前应认真核对自己的准考证号是否正确，是否对应相应的姓名、准考证号等栏目。凡答题过程中出现抄袭的现象，视本次成绩无效，监考老师有权将驱除考场，成绩作零分处理。
						</p>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center;">
			<button type="submit" id="submit">开始考试</button>
		</div>
	</form>
	<style>
		#submit{
			style=width: 100px;
			height: 30px;
			text-align: center;
		}
	
	</style>
	<script type="text/javascript">
		$("#submit").click(function () {
			window.open('<%=basePath%>test/selectById', '_blank')
		});
	</script>
</body>
</html>