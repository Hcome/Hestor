<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>正在考试</title>
<link href="<%=basePath%>/static/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/static/css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/static/css/test.css" rel="stylesheet" type="text/css" />

	<style>
	.hasBeenAnswer {
		background: #5d9cec;
		color:#fff;
	}
	.inputBtn {
		border: none;
		outline: none;
		width: 40px;
		height: 20px
	
	}
	</style>
</head>
<body>
	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left" style="width:69%">
				<div class="test">
					<form action="<%=basePath%>test/finishTest" method="post">
						<div class="test_title" style="width:70%">
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:40</b>
							</p>
							<font><input type="submit" name="test_jiaojuan" value="交卷">交卷</font>
						</div>
						
						<div class="test_content">
							<div class="test_content_title">
								<h2>单选题</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题，</span><span>合计</span><i class="content_fs">30</i><span>分</span>
									</p>
							</div>
						</div>

						<div class="test_content_nr">
							<ul>
								<c:forEach items="${choiceList}" var="test" begin="0" end="9"
									varStatus="status">
									<li id="qu_0_${status.index}">
										<div class="test_content_nr_tt">
											<i>${status.index+1}</i><span>(1分)</span><font>${test.testQuestion} 
											(<input type="text" id="inputBtn" class="inputBtn" name="answer1" >)</font>
											<b><class="icon iconfont">&#xe881;</b>
										</div>

										<div class="test_content_nr_main">
											<ul>

												<li class="option"><label
													for="0_answer_${status.index+1}_option_1"> A.
													<p class="ue" style="display: inline;">${test.testAnswerA }</p>
												</label></li>

												<li class="option"><label
													for="0_answer_${status.index+1}_option_2"> B.
													<p class="ue" style="display: inline;">${test.testAnswerB}</p>
												</label></li>

												<li class="option"><label
													for="0_answer_${status.index+1}_option_3"> C.
													<p class="ue" style="display: inline;">${test.testAnswerC }</p>
												</label></li>

												<li class="option"><label
													for="0_answer_${status.index+1}_option_4"> D.
													<p class="ue" style="display: inline;">${test.testAnswerD}</p>
												</label></li>

											</ul>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>

						<div class="test_content">
								<div class="test_content_title">
									<h2>填空题</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题，</span><span>合计</span><i class="content_fs">30</i><span>分</span>
									</p>
								</div>
							</div>
							<c:forEach items="${fillList}" var="fill" begin="0" end="9" varStatus="status">
								<div class="test_content_nr" name="answer${status.index+1}">
									<ul>
										<li id="qu_1_${status.index}">
											<div class="test_content_nr_tt">
												<i>${status.index+1}</i><span>(1分)</span><font>${fill.fillblanksQuestion}</font><b class="icon iconfont">&#xe881;</b>
												(<input type="text" class="inputBtn" name="answer2" >)
											</div>
										</li>
									</ul>
								</div>
							</c:forEach>
						<div class="test_content">
							<div class="test_content_title">
								<h2>阅读理解</h2>
								<p>
									<span>共</span><i class="content_lit">4</i><span>题，</span><span>合计</span><i><class="content_fs">40</i><span>分</span>
								</p>
							</div>
						</div>
						<div class="test_content_nr">
							<ul>
								<li >
									<c:forEach items="${articleList}" var="article" begin="0" end="3" varStatus="status">
										<div class="test_content_nr_tt">
											<div align="center">
												<i>${status.index+1}</i><h2 >${article.articleTitle }</h2><b><class="icon iconfont">&#xe881;</b>
											</div>
											<br>
											<font>${article.articleText}</font><b>
										</div>
										<br>
										<br>
										
										<div class="test_content_nr_tt" id="qu_2_0">
											<i>${status.index+1}</i><font>${article.articleQuestionOne}</font>
											(<input type="text" class="inputBtn" name="answer3" >)
											<b><class="icon iconfont">&#xe881;</b>
										</div>
										
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<label for="0_answer_1_option_1"> A.
														<p class="ue" style="display: inline;">${article.articleAnswerA}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_1_option_2"> B.
														<p class="ue" style="display: inline;">${article.articleAnswerB}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_1_option_3"> C.
														<p class="ue" style="display: inline;">${article.articleAnswerC}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_1_option_4"> D.
														<p class="ue" style="display: inline;">${article.articleAnswerD}</p>
												</label></li>
	
											</ul>
										</div>
										<div class="test_content_nr_tt" id="qu_2_1">
										<i>${status.index+2}</i><font>${article.articleQuestionTwo}</font>
										(<input type="text" class="inputBtn" name="answer4" >)
										<b><class="icon iconfont">&#xe881;</b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<label for="0_answer_2_option_1"> A.
														<p class="ue" style="display: inline;">${article.articleAnswerTwoA}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_2_option_2"> B.
														<p class="ue" style="display: inline;">${article.articleAnswerTwoB}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_2_option_3"> C.
														<p class="ue" style="display: inline;">${article.articleAnswerTwoC}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_2_option_4"> D.
														<p class="ue" style="display: inline;">${article.articleAnswerTwoD}</p>
												</label></li>
	
											</ul>
										</div>
										<div class="test_content_nr_tt" id="qu_2_2">
										<i>${status.index+3}</i><font>${article.articleQuestionThree}</font>
										(<input type="text" class="inputBtn" name="answer5" >)
										<b><class="icon iconfont">&#xe881;</b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<label for="0_answer_3_option_1"> A.
														<p class="ue" style="display: inline;">${article.articleAnswerThreeA}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_3_option_2"> B.
														<p class="ue" style="display: inline;">${article.articleAnswerThreeB}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_3_option_3"> C.
														<p class="ue" style="display: inline;">${article.articleAnswerThreeC}</p>
												</label></li>
												<li class="option">
													<label for="0_answer_3_option_4"> D.
														<p class="ue" style="display: inline;">${article.articleAnswerThreeD}</p>
												</label></li>
	
											</ul>
										</div>
										<div class="test_content_nr_tt" id="qu_2_3">
										<i>${status.index+4}</i><font>${article.articleQuestionFour}</font>
										(<input type="text" class="inputBtn" name="answer6" >)
										<b><class="icon iconfont">&#xe881;</b>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option">
													<label for="0_answer_4_option_1"> A.
														<p class="ue" style="display: inline;">${article.articleAnswerFourA}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_4_option_2"> B.
														<p class="ue" style="display: inline;">${article.articleAnswerFourB}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_4_option_3"> C.
														<p class="ue" style="display: inline;">${article.articleAnswerFourC}</p>
												</label></li>
	
												<li class="option">
													<label for="0_answer_4_option_4"> D.
														<p class="ue" style="display: inline;">${article.articleAnswerFourD}</p>
												</label>
												</li>
											</ul>
										</div>
									</c:forEach>
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
										<span>共</span><i class="content_lit">10</i><span>题</span>
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
									<h2>填空题</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题</span>
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
							<div class="rt_content">
								<div class="rt_content_tt">
									<h2>阅读理解</h2>
									<p>
										<span>共</span><i class="content_lit">10</i><span>题</span>
									</p>
								</div>
								<div class="rt_content_nr answerSheet">
									<ul>
										
											<li><a href="#qu_2_0">1</a></li>
										
											<li><a href="#qu_2_1">2</a></li>
										
											<li><a href="#qu_2_2">3</a></li>
										
											<li><a href="#qu_2_3">4</a></li>
										
											<li><a href="#qu_2_4">5</a></li>
										
											<li><a href="#qu_2_5">6</a></li>
										
											<li><a href="#qu_2_6">7</a></li>
										
											<li><a href="#qu_2_7">8</a></li>
										
											<li><a href="#qu_2_8">9</a></li>
										
											<li><a href="#qu_2_9">10</a></li>	
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
	<!-- 设置单选框的值 -->
	<script type="text/javascript">
		
	
	</script>
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
				var examId = $(this).closest('.test_content_nr_tt').attr('id'); // 得到题目ID
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