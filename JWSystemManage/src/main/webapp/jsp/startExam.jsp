<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+
request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>在线英语考试系统</title>
<link href="<%=basePath%>/static/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/static/css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/static/css/test.css" rel="stylesheet" type="text/css" />

	<style>
	.hasBeenAnswer {
		background: #5d9cec;
		color:#fff;
	}
	</style>
</head>
<body>
	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left" style="width:69%">
				<div class="test">
					<form action="" method="post">
						<div class="test_title" style="width:70%">
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
							<font><input type="button" name="test_jiaojuan" value="交卷"></font>
						</div>
						
							<div class="test_content">
								<div class="test_content_title">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题，</span><span>合计</span><i class="content_fs">10</i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
										<li id="qu_0_0">
											<div class="test_content_nr_tt">
												<i>1</i><span>(1分)</span><font>在生产管理信息系统中，下列操作步骤能正确将工单推进流程的是（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer1"
																	id="0_answer_1_option_1"
																/>
															
															
															<label for="0_answer_1_option_1">
																A.
																<p class="ue" style="display: inline;">在工具栏中点击“workflow”标签</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer1"
																	id="0_answer_1_option_2"
																/>
															
															
															<label for="0_answer_1_option_2">
																B.
																<p class="ue" style="display: inline;">在缺陷单界面中点击“推进流程”按钮</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer1"
																	id="0_answer_1_option_3"
																/>
															
															
															<label for="0_answer_1_option_3">
																C.
																<p class="ue" style="display: inline;">在缺陷单界面中点击“提交”按钮</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer1"
																	id="0_answer_1_option_4"
																/>
															
															
															<label for="0_answer_1_option_4">
																D.
																<p class="ue" style="display: inline;">后台启动流程推进</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_1">
											<div class="test_content_nr_tt">
												<i>2</i><span>(1分)</span><font>在营销系统中查询客户有无欠费、余额及抄表数据接待客户时应做到哪些最基本的礼仪？</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer2"
																	id="0_answer_2_option_1"
																/>
															
															
															<label for="0_answer_2_option_1">
																A.
																<p class="ue" style="display: inline;">起身、微笑、示坐、问候客户</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer2"
																	id="0_answer_2_option_2"
																/>
															
															
															<label for="0_answer_2_option_2">
																B.
																<p class="ue" style="display: inline;">坐着，问候客户</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer2"
																	id="0_answer_2_option_3"
																/>
															
															
															<label for="0_answer_2_option_3">
																C.
																<p class="ue" style="display: inline;">坐着，问候客户</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer2"
																	id="0_answer_2_option_4"
																/>
															
															
															<label for="0_answer_2_option_4">
																D.
																<p class="ue" style="display: inline;">请问需要办理什么业务</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_2">
											<div class="test_content_nr_tt">
												<i>3</i><span>(1分)</span><font>请在下列选项中选择正确进入电力营销系统网址</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer3"
																	id="0_answer_3_option_1"
																/>
															
															
															<label for="0_answer_3_option_1">
																A.
																<p class="ue" style="display: inline;">http://10.113.225.24:83/epm/static/logon/logon.jsp</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer3"
																	id="0_answer_3_option_2"
																/>
															
															
															<label for="0_answer_3_option_2">
																B.
																<p class="ue" style="display: inline;">http://10.113.255.24:83/epm/static/logon/logon.jsp</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer3"
																	id="0_answer_3_option_3"
																/>
															
															
															<label for="0_answer_3_option_3">
																C.
																<p class="ue" style="display: inline;">http://10.113.255.24:81/epm/static/logon/logon.jsphttp://10.113.245.24:81/epm/static/logon/logon.jsp</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_3">
											<div class="test_content_nr_tt">
												<i>4</i><span>(1分)</span><font>如何在电力营销系统查询出客户的是否有余额</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer4"
																	id="0_answer_4_option_1"
																/>
															
															
															<label for="0_answer_4_option_1">
																A.
																<p class="ue" style="display: inline;">在综合查询下的电量电费查询中进行查询</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer4"
																	id="0_answer_4_option_2"
																/>
															
															
															<label for="0_answer_4_option_2">
																B.
																<p class="ue" style="display: inline;">在综合查询下的抄表信息查询中点击抄表数据进行查询</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer4"
																	id="0_answer_4_option_3"
																/>
															
															
															<label for="0_answer_4_option_3">
																C.
																<p class="ue" style="display: inline;">在收费管理下的综合查询中点击欠费查询进行查询</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer4"
																	id="0_answer_4_option_4"
																/>
															
															
															<label for="0_answer_4_option_4">
																D.
																<p class="ue" style="display: inline;">在收费管理下的坐收交费中进行查询</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_4">
											<div class="test_content_nr_tt">
												<i>5</i><span>(1分)</span><font>检查、使用万用表,用万用表测量一小型加工厂线电压为351V，请问其电压是否合格（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer5"
																	id="0_answer_5_option_1"
																/>
															
															
															<label for="0_answer_5_option_1">
																A.
																<p class="ue" style="display: inline;">合格</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer5"
																	id="0_answer_5_option_2"
																/>
															
															
															<label for="0_answer_5_option_2">
																B.
																<p class="ue" style="display: inline;">不合格</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_5">
											<div class="test_content_nr_tt">
												<i>6</i><span>(1分)</span><font>检查、使用万用表,用万用表测量一小型加工厂线电压为415V，请问其电压是否合格（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer6"
																	id="0_answer_6_option_1"
																/>
															
															
															<label for="0_answer_6_option_1">
																A.
																<p class="ue" style="display: inline;">合格</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer6"
																	id="0_answer_6_option_2"
																/>
															
															
															<label for="0_answer_6_option_2">
																B.
																<p class="ue" style="display: inline;">不合格</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_6">
											<div class="test_content_nr_tt">
												<i>7</i><span>(1分)</span><font>万用表使用完毕后，应将转换开关调至（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer7"
																	id="0_answer_7_option_1"
																/>
															
															
															<label for="0_answer_7_option_1">
																A.
																<p class="ue" style="display: inline;">交流电流最高档或空档</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer7"
																	id="0_answer_7_option_2"
																/>
															
															
															<label for="0_answer_7_option_2">
																B.
																<p class="ue" style="display: inline;">直流电流最高档或空档</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer7"
																	id="0_answer_7_option_3"
																/>
															
															
															<label for="0_answer_7_option_3">
																C.
																<p class="ue" style="display: inline;">交流电压最高档或空档</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer7"
																	id="0_answer_7_option_4"
																/>
															
															
															<label for="0_answer_7_option_4">
																D.
																<p class="ue" style="display: inline;">直流电压最高档或空档</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_7">
											<div class="test_content_nr_tt">
												<i>8</i><span>(1分)</span><font>钳形电流表的检查、使用方法,如何判断钳形电流表电池电量充足（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer8"
																	id="0_answer_8_option_1"
																/>
															
															
															<label for="0_answer_8_option_1">
																A.
																<p class="ue" style="display: inline;">钳形电流表开机后数字显示清晰</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer8"
																	id="0_answer_8_option_2"
																/>
															
															
															<label for="0_answer_8_option_2">
																B.
																<p class="ue" style="display: inline;">钳形电流表开机后数字显示模糊</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer8"
																	id="0_answer_8_option_3"
																/>
															
															
															<label for="0_answer_8_option_3">
																C.
																<p class="ue" style="display: inline;">钳形电流表开机后显示屏发光</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer8"
																	id="0_answer_8_option_4"
																/>
															
															
															<label for="0_answer_8_option_4">
																D.
																<p class="ue" style="display: inline;">钳形电流表开机后发出声响</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_8">
											<div class="test_content_nr_tt">
												<i>9</i><span>(1分)</span><font>钳形电流表的检查、使用方法,钳形电流表使用完毕后，应将转换开关调至（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer9"
																	id="0_answer_9_option_1"
																/>
															
															
															<label for="0_answer_9_option_1">
																A.
																<p class="ue" style="display: inline;">交流电压最高档或空档</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer9"
																	id="0_answer_9_option_2"
																/>
															
															
															<label for="0_answer_9_option_2">
																B.
																<p class="ue" style="display: inline;">交流电流最高档或空档</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer9"
																	id="0_answer_9_option_3"
																/>
															
															
															<label for="0_answer_9_option_3">
																C.
																<p class="ue" style="display: inline;">直流电流最高档或空档</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer9"
																	id="0_answer_9_option_4"
																/>
															
															
															<label for="0_answer_9_option_4">
																D.
																<p class="ue" style="display: inline;">直流电压最高档或空档</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_0_9">
											<div class="test_content_nr_tt">
												<i>10</i><span>(1分)</span><font>灭火器的检查、使用方法,下列不属于灭火器的日常检查主要有（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer10"
																	id="0_answer_10_option_1"
																/>
															
															
															<label for="0_answer_10_option_1">
																A.
																<p class="ue" style="display: inline;">灭火器应在有效试验周期内</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer10"
																	id="0_answer_10_option_2"
																/>
															
															
															<label for="0_answer_10_option_2">
																B.
																<p class="ue" style="display: inline;">灭火器压力值应在正常范围内</p>
															</label>
														</li>
													
														<li class="option">
															
																<input type="radio" class="radioOrCheck" name="answer10"
																	id="0_answer_10_option_3"
																/>
															
															
															<label for="0_answer_10_option_3">
																C.
																<p class="ue" style="display: inline;">灭火器的型号</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
								</ul>
							</div>
						
							<div class="test_content">
								<div class="test_content_title">
									<h2>多选题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题，</span><span>合计</span><i class="content_fs">30</i><span>分</span>
									</p>
								</div>
							</div>
							<div class="test_content_nr">
								<ul>
									
										<li id="qu_1_0">
											<div class="test_content_nr_tt">
												<i>1</i><span>(1分)</span><font>以下属于南方电网员工职业操守中明文规定的有()</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_1"
																/>
															
															<label for="1_answer_1_option_1">
																A.
																<p class="ue" style="display: inline;">热爱祖国、热爱南网、热爱岗位</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_2"
																/>
															
															<label for="1_answer_1_option_2">
																B.
																<p class="ue" style="display: inline;">遵纪守法、忠于职守、令行禁止</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_3"
																/>
															
															<label for="1_answer_1_option_3">
																C.
																<p class="ue" style="display: inline;">客户至上、诚实守信、优质服务</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer1"
																	id="1_answer_1_option_4"
																/>
															
															<label for="1_answer_1_option_4">
																D.
																<p class="ue" style="display: inline;">公平竞争、互相监督、服从监管</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_1">
											<div class="test_content_nr_tt">
												<i>2</i><span>(1分)</span><font>以下属于南方电网员工职业禁区的有()</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer2"
																	id="1_answer_2_option_1"
																/>
															
															<label for="1_answer_2_option_1">
																A.
																<p class="ue" style="display: inline;">严禁违反人文道德</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer2"
																	id="1_answer_2_option_2"
																/>
															
															<label for="1_answer_2_option_2">
																B.
																<p class="ue" style="display: inline;">严禁违反安全规定</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer2"
																	id="1_answer_2_option_3"
																/>
															
															<label for="1_answer_2_option_3">
																C.
																<p class="ue" style="display: inline;">严禁违背行风规定</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer2"
																	id="1_answer_2_option_4"
																/>
															
															<label for="1_answer_2_option_4">
																D.
																<p class="ue" style="display: inline;">严禁违反财经纪律</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_2">
											<div class="test_content_nr_tt">
												<i>3</i><span>(1分)</span><font>对 “热爱祖国、热爱南网、热爱岗位”理解正确的是()</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer3"
																	id="1_answer_3_option_1"
																/>
															
															<label for="1_answer_3_option_1">
																A.
																<p class="ue" style="display: inline;">坚持南网的利益高于一切</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer3"
																	id="1_answer_3_option_2"
																/>
															
															<label for="1_answer_3_option_2">
																B.
																<p class="ue" style="display: inline;">忠诚南网事业，维护南网利益，实践南网文化，维护南网形象，与公司同呼吸、共命运</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer3"
																	id="1_answer_3_option_3"
																/>
															
															<label for="1_answer_3_option_3">
																C.
																<p class="ue" style="display: inline;">人往高处走，水往低处流，专注于爬上更高的岗位</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer3"
																	id="1_answer_3_option_4"
																/>
															
															<label for="1_answer_3_option_4">
																D.
																<p class="ue" style="display: inline;">个人利益第一，南网利益第二</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_3">
											<div class="test_content_nr_tt">
												<i>4</i><span>(1分)</span><font>优质服务工作的主线是（）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer4"
																	id="1_answer_4_option_1"
																/>
															
															<label for="1_answer_4_option_1">
																A.
																<p class="ue" style="display: inline;">以客户为中心，提高供电可靠率、减少客户停电时间</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer4"
																	id="1_answer_4_option_2"
																/>
															
															<label for="1_answer_4_option_2">
																B.
																<p class="ue" style="display: inline;">以客户为中心，为客户节省更多的花费</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer4"
																	id="1_answer_4_option_3"
																/>
															
															<label for="1_answer_4_option_3">
																C.
																<p class="ue" style="display: inline;">以公司利益为中心，从客户手中赚取更多的金钱</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer4"
																	id="1_answer_4_option_4"
																/>
															
															<label for="1_answer_4_option_4">
																D.
																<p class="ue" style="display: inline;">以公司利益为中心，提高供电可靠率、减少客户投诉率</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_4">
											<div class="test_content_nr_tt">
												<i>5</i><span>(1分)</span><font>职业操守中明确注明需要增强的意识有哪些（）
①道德意识 ②忧患意识 ③环保意识 ④自律意识 ⑤节约意识</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer5"
																	id="1_answer_5_option_1"
																/>
															
															<label for="1_answer_5_option_1">
																A.
																<p class="ue" style="display: inline;">①②③④⑤</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer5"
																	id="1_answer_5_option_2"
																/>
															
															<label for="1_answer_5_option_2">
																B.
																<p class="ue" style="display: inline;">①②③</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer5"
																	id="1_answer_5_option_3"
																/>
															
															<label for="1_answer_5_option_3">
																C.
																<p class="ue" style="display: inline;">②③④</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer5"
																	id="1_answer_5_option_4"
																/>
															
															<label for="1_answer_5_option_4">
																D.
																<p class="ue" style="display: inline;">②③⑤</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_5">
											<div class="test_content_nr_tt">
												<i>6</i><span>(1分)</span><font>以下不属于严禁违反的行风规定的是（）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer6"
																	id="1_answer_6_option_1"
																/>
															
															<label for="1_answer_6_option_1">
																A.
																<p class="ue" style="display: inline;">严禁乱加价、乱收费、乱摊派</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer6"
																	id="1_answer_6_option_2"
																/>
															
															<label for="1_answer_6_option_2">
																B.
																<p class="ue" style="display: inline;">严禁人情电、关系电、权力电</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer6"
																	id="1_answer_6_option_3"
																/>
															
															<label for="1_answer_6_option_3">
																C.
																<p class="ue" style="display: inline;">严禁损害公司形象</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer6"
																	id="1_answer_6_option_4"
																/>
															
															<label for="1_answer_6_option_4">
																D.
																<p class="ue" style="display: inline;">严禁推诿、搪塞客户咨询、查询、投诉、举报等服务诉求。</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_6">
											<div class="test_content_nr_tt">
												<i>7</i><span>(1分)</span><font>以下哪项行为需要经过授权与批准（）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer7"
																	id="1_answer_7_option_1"
																/>
															
															<label for="1_answer_7_option_1">
																A.
																<p class="ue" style="display: inline;">下班</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer7"
																	id="1_answer_7_option_2"
																/>
															
															<label for="1_answer_7_option_2">
																B.
																<p class="ue" style="display: inline;">学习提高岗位专业技能</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer7"
																	id="1_answer_7_option_3"
																/>
															
															<label for="1_answer_7_option_3">
																C.
																<p class="ue" style="display: inline;">发生紧急事件需要员工立刻采取措施时</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer7"
																	id="1_answer_7_option_4"
																/>
															
															<label for="1_answer_7_option_4">
																D.
																<p class="ue" style="display: inline;">以公司名义进行考察、谈判、签约、提供担保和证明时</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_7">
											<div class="test_content_nr_tt">
												<i>8</i><span>(1分)</span><font>以下不属于“节约环保、居安思危、艰苦创业”内容的是（）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer8"
																	id="1_answer_8_option_1"
																/>
															
															<label for="1_answer_8_option_1">
																A.
																<p class="ue" style="display: inline;">务必继续保持谦虚、谨慎、不骄、不躁的作风</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer8"
																	id="1_answer_8_option_2"
																/>
															
															<label for="1_answer_8_option_2">
																B.
																<p class="ue" style="display: inline;">务必继续保持艰苦奋斗的作风</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer8"
																	id="1_answer_8_option_3"
																/>
															
															<label for="1_answer_8_option_3">
																C.
																<p class="ue" style="display: inline;">清醒地看到发展过程中面临的严峻挑战</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer8"
																	id="1_answer_8_option_4"
																/>
															
															<label for="1_answer_8_option_4">
																D.
																<p class="ue" style="display: inline;">不做出任何有损公司形象的事情</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_8">
											<div class="test_content_nr_tt">
												<i>9</i><span>(1分)</span><font>跌落式熔断器安装时螺母（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer9"
																	id="1_answer_9_option_1"
																/>
															
															<label for="1_answer_9_option_1">
																A.
																<p class="ue" style="display: inline;">安装时螺母朝上</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer9"
																	id="1_answer_9_option_2"
																/>
															
															<label for="1_answer_9_option_2">
																B.
																<p class="ue" style="display: inline;">安装时螺母朝下</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer9"
																	id="1_answer_9_option_3"
																/>
															
															<label for="1_answer_9_option_3">
																C.
																<p class="ue" style="display: inline;">无要求</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
									
										<li id="qu_1_9">
											<div class="test_content_nr_tt">
												<i>10</i><span>(1分)</span><font>新装的跌落式熔断器绝缘电阻应大于（  ）</font><b class="icon iconfont">&#xe881;</b>
											</div>

											<div class="test_content_nr_main">
												<ul>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer10"
																	id="1_answer_10_option_1"
																/>
															
															<label for="1_answer_10_option_1">
																A.
																<p class="ue" style="display: inline;">300兆欧</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer10"
																	id="1_answer_10_option_2"
																/>
															
															<label for="1_answer_10_option_2">
																B.
																<p class="ue" style="display: inline;">400兆欧</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer10"
																	id="1_answer_10_option_3"
																/>
															
															<label for="1_answer_10_option_3">
																C.
																<p class="ue" style="display: inline;">500兆欧</p>
															</label>
														</li>
													
														<li class="option">
															
															
																<input type="checkbox" class="radioOrCheck" name="answer10"
																	id="1_answer_10_option_4"
																/>
															
															<label for="1_answer_10_option_4">
																D.
																<p class="ue" style="display: inline;">600兆欧</p>
															</label>
														</li>
													
												</ul>
											</div>
										</li>
								</ul>
							</div>
						
					</form>
				</div>

			</div>
			
			<div class="nr_right" style="width:30%;height:1000px;overflow:auto" >
				<div class="nr_rt_main">
					<div class="rt_nr1">
						<div class="rt_nr1_title">
							<h1>
								<i class="icon iconfont">&#xe692;</i>答题卡
							</h1>
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
						</div>
						
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">60</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
											<li><a href="#qu_0_0">1</a></li>
										
											<li><a href="#qu_0_1">2</a></li>
										
											<li><a href="#qu_0_2">3</a></li>
										
											<li><a href="#qu_0_3">4</a></li>
										
											<li><a href="#qu_0_4">5</a></li>
										
											<li><a href="#qu_0_5">6</a></li>
										
											<li><a href="#qu_0_6">7</a></li>
										
											<li><a href="#qu_0_7">8</a></li>
										
											<li><a href="#qu_0_8">9</a></li>
										
											<li><a href="#qu_0_9">10</a></li>
										
									</ul>
								</div>
							</div>
						
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>多选题</h2>
									<p>
										<span>共</span><i class="content_lit">30</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
											<li><a href="#qu_1_0">1</a></li>
										
											<li><a href="#qu_1_1">2</a></li>
										
											<li><a href="#qu_1_2">3</a></li>
										
											<li><a href="#qu_1_3">4</a></li>
										
											<li><a href="#qu_1_4">5</a></li>
										
											<li><a href="#qu_1_5">6</a></li>
										
											<li><a href="#qu_1_6">7</a></li>
										
											<li><a href="#qu_1_7">8</a></li>
										
											<li><a href="#qu_1_8">9</a></li>
										
											<li><a href="#qu_1_9">10</a></li>
										
									</ul>
								</div>
							</div>	
					</div>

				</div>
			</div>
		</div>
		<!--nr end-->
		<div class="foot"></div>
	</div>

	<script src="<%=basePath%>/static/js/jquery-1.11.3.min.js"></script>
	<script src="<%=basePath%>/static/js/jquery.easy-pie-chart.js"></script>
	<!--时间js-->
	<script src="<%=basePath%>/static/js/time/jquery.countdown.js"></script>
	<script>
		window.jQuery(function($) {
			"use strict";
			
			$('time').countDown({
				with_separators : false
			});
			$('.alt-1').countDown({
				css_class : 'countdown-alt-1'
			});
			$('.alt-2').countDown({
				css_class : 'countdown-alt-2'
			});
			
		});
		
		
		$(function() {
			$('li.option label').click(function() {
			debugger;
				var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
				var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
				// 设置已答题
				if(!cardLi.hasClass('hasBeenAnswer')){
					cardLi.addClass('hasBeenAnswer');
				}
				
			});
		});
	</script>
</body>
</html>