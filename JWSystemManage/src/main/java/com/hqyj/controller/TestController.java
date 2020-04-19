package com.hqyj.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hqyj.entity.ArticleTest;
import com.hqyj.entity.FillBlanksTest;
import com.hqyj.entity.GenerateChoice;
import com.hqyj.entity.MultipleChoiceTest;
import com.hqyj.entity.Teacher;
import com.hqyj.service.AdminService;
import com.hqyj.service.ArticleTestService;
import com.hqyj.service.FillBlanksTestService;
import com.hqyj.service.GenerateChoiceService;
import com.hqyj.service.TeacherService;
import com.hqyj.service.TestService;
import com.mchange.lang.StringUtils;

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
	private GenerateChoiceService gcs;
	
	
	@RequestMapping(value = "/selectById")
	public String selectTestById(HttpServletRequest request) {
		
		HashSet<MultipleChoiceTest> choiceSet = ts.selectTestById();
		HashSet<FillBlanksTest> fillSet = fts.selectFillBlanksTestAll();
		HashSet<ArticleTest> articleSet = ats.selectArticleTest();
		
		request.getSession().setAttribute("choiceSet", choiceSet);
		request.getSession().setAttribute("fillSet", fillSet);
		request.getSession().setAttribute("articleSet", articleSet);
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
	 * @return
	 */
	@RequestMapping(value = "/finishTest")
	public String finishTest(HttpServletRequest request) {
		GenerateChoice choice = new GenerateChoice();
		HashSet<MultipleChoiceTest> set = (HashSet<MultipleChoiceTest>) request.getSession().getAttribute("choiceSet");
		String[] values = request.getParameterValues("answer1");

		for (String string : values) {
			choice.setGenerateStudentAnswer(string);
			int num = gcs.insertChoice(choice); 
			System.out.println("影响的行数"+num++); 
		}
		/*
		 * for (int i = 0; i < 10; i++) { MultipleChoiceTest test =
		 * set.iterator().next(); if (!set.isEmpty()) {
		 * choice.setGenerateChoiceQuestion(test.getTestQuestion());
		 * choice.setGenerateChoiceAnswerA(test.getTestAnswerA());
		 * choice.setGenerateChoiceAnswerB(test.getTestAnswerB());
		 * choice.setGenerateChoiceAnswerC(test.getTestAnswerC());
		 * choice.setGenerateChoiceAnswerD(test.getTestAnswerD()); }
		 * 
		 * int num = gcs.insertChoice(choice); System.out.println("影响的行数"+num++); }
		 */
		return "startExam";	
	}
}
