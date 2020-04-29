package com.hqyj.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.entity.ArticleTest;
import com.hqyj.entity.FillBlanksTest;
import com.hqyj.entity.MultipleChoiceTest;
import com.hqyj.entity.Score;
import com.hqyj.entity.Student;
import com.hqyj.service.ArticleTestService;
import com.hqyj.service.FillBlanksTestService;
import com.hqyj.service.GenerateChoiceService;
import com.hqyj.service.ScoreService;
import com.hqyj.service.StudentService;
import com.hqyj.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService ts;
	@Autowired
	private FillBlanksTestService fts;
	@Autowired
	private ArticleTestService ats;
	@Autowired
	private StudentService ss;
	@Autowired
	private ScoreService scores;
	@Autowired
	private GenerateChoiceService gcs;
	
	
	@RequestMapping(value = "/selectById")
	public String selectTestById(HttpServletRequest request) {
		
		List<MultipleChoiceTest> choiceList = ts.selectTestById();
		List<FillBlanksTest> fillList = fts.selectFillBlanksTestAll();
		List<ArticleTest> list = ats.selectArticleTest();
		
		request.getSession().setAttribute("choiceList", choiceList);
		request.getSession().setAttribute("fillList", fillList);
		request.getSession().setAttribute("articleList", list);
		return "startExam";
		
	}
	@RequestMapping("/getTestTypeName")
	public String getTestTypeName(HttpServletRequest request) {
		String str = request.getParameter("listItem");
		request.getSession().setAttribute("testTypeName", str);
		if (str != null && str.length() > 0) {
			if ("选择题".equals(str)) {
				return "addChoice";
			}else if ("填空题".equals(str)) {
				return "addfill";
			}
		}
		return "addArticleTest";
	}
	
	@RequestMapping("/addMultipleChoiceTest")
	public String addMultipleChoiceTest(MultipleChoiceTest test,FillBlanksTest test2,ArticleTest test3,HttpServletRequest request) {
		
		String testTypeName = (String) request.getSession().getAttribute("testTypeName");
			if ("选择题".equals(testTypeName)) {
				test.setTestType(testTypeName);;
				int num = ts.insertChoiceTest(test);
				System.out.println(num);
			}else if("填空题".equals(testTypeName)){
				test2.setFillblanksType(testTypeName);
				int num = fts.insertFillBlanksTest(test2);
				System.out.println(num);
			}else if("阅读理解".equals(testTypeName)){
				test3.setArticleType(testTypeName);
				int num = ats.insertArticleTest(test3);
				System.out.println(num);
			}
		return "Test";
	}
	/**
	 * 用于接收考生完成测试的题目模块
	 * 考试完成后提交试卷就会提交成绩
	 * @return
	 */
	@RequestMapping(value = "/finishTest")
	public String finishTest(HttpServletRequest request) {
		
		
		int score = 0;
		int j = 0;
		List<String> list = new ArrayList<String>();
		
		//GenerateChoice choice = new GenerateChoice();
		
		//获取选择题的正确选项
		@SuppressWarnings("unchecked")
		List<MultipleChoiceTest> listChoiceTests = (List<MultipleChoiceTest>) request.getSession().getAttribute("choiceList");
		if (listChoiceTests != null) {
			for (MultipleChoiceTest multipleChoiceTest : listChoiceTests) {
				String answer = multipleChoiceTest.getTestRightAnswer();
				list.add(answer);
			}
		}
		//获取选择题的学生的选项
		String[] choices = request.getParameterValues("answer1");
		//计算选择题的总分
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(choices[j++])) {
				score = score+3;
			}
		}
		
		//获取随机的填空的答案
		list.clear();
		@SuppressWarnings("unchecked")
		List<FillBlanksTest> fillList = (List<FillBlanksTest>) request.getSession().getAttribute("fillList");
		for (FillBlanksTest fillBlanksTest : fillList) {
			String answer = fillBlanksTest.getFillblanksAnswer();
			list.add(answer);
		}
		//获取考生填空题的答案
		String[] fills = request.getParameterValues("answer2");
		//计算填空题的答案
		for (int i = 0; i < list.size(); i++) {
			j = 0;
			if (list.get(i).equals(fills[j++])) {
				score = score + 3;
			}
		}
		
		/**
		 * 下面是计算阅读题的总分数，由于一个题目有多个答案，所以在这里分开计算
		 */
		@SuppressWarnings("unchecked")
		List<ArticleTest> strArticle = (List<ArticleTest>) request.getSession().getAttribute("articleList");
		//计算选择题第一小题的得分
		list.clear();
		for (ArticleTest articleTest : strArticle) {
			list.add(articleTest.getArticleAnsweroneRight());
		}
		String[] articleOne = request.getParameterValues("answer3");
		for (int i = 0; i < list.size(); i++) {
			j = 0;
			if (list.get(i).equals(articleOne[j++])) {
				score = score + 5;
			}
		}
		
		//计算选择器第二小题的得分
		list.clear();
		for (ArticleTest articleTest : strArticle) {
			list.add(articleTest.getArticleAnswerTwoRight());
		}
		String[] articleTwo = request.getParameterValues("answer4");
		for (int i = 0; i < list.size(); i++) {
			j = 0;
			if (list.get(i).equals(articleTwo[j++])) {
				score = score + 5;
			}
		}
		
		//计算选择题第三小题的得分
		list.clear();
		for (ArticleTest articleTest : strArticle) {
			list.add(articleTest.getArticleAnswerThreeright());
		}
		String[] articleThree = request.getParameterValues("answer5");
		for (int i = 0; i < list.size(); i++) {
			j = 0;
			if (list.get(i).equals(articleThree[j++])) {
				score = score + 5;
			}
		}
		
		//计算选择题第四小题的得分
		list.clear();
		for (ArticleTest articleTest : strArticle) {
			list.add(articleTest.getArticleAnswerFourRight());
		}
		String[] articleFour = request.getParameterValues("answer6");
		for (int i = 0; i < list.size(); i++) {
			j = 0;
			if (list.get(i).equals(articleFour[j++])) {
				score = score + 5;
			}
		}
		
		System.out.println("这位同学的总分是："+score);
		
		String userName = (String) request.getSession().getAttribute("userName");
		System.out.println(userName+"+++++++++++++++++++++++");
		
		
		//执行对成绩表的插入操作
		Score score2 = new Score();
		score2.setScoreNunber(score);
		score2.setFkStudentId(ss.queryStudentIdByUserName(userName));
		//对学生的分数进行判断
		if (score >= 0&&score < 60) {
			score2.setIsPass("不及格");
		}else if(score >= 60 && score <= 100){
			score2.setIsPass("通过");
		}
		//添加成绩
		int num = scores.insertScore(score2);
		System.out.println("影响的行数"+num);
		/*
		 * for (String string : values) { choice.setGenerateStudentAnswer(string); int
		 * num = gcs.insertChoice(choice); System.out.println("影响的行数"+num++); }
		 */
		return "startExam";	
	}
}
