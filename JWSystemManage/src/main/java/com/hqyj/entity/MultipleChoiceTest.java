package com.hqyj.entity;
/**
 * 选择试题
 */
import java.util.Date;

public class MultipleChoiceTest {
	
	private Integer testId;
	
	private String testQuestion;
	
	//试题的四个选项
	private String testAnswerA;
	
	private String testAnswerB;
	
	private String testAnswerC;
	
	private String testAnswerD;
	//正确答案
	private String testRightAnswer;
	
	private String testType;
	//试题难易程度	
	private String testIsDifficulty;
	
	private Date testUpLoadDate;
	
	private String fkUserName;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	

	public String getFkUserName() {
		return fkUserName;
	}

	public void setFkUserName(String fkUserName) {
		this.fkUserName = fkUserName;
	}

	public String getTestQuestion() {
		return testQuestion;
	}

	public void setTestQuestion(String testQuestion) {
		this.testQuestion = testQuestion;
	}

	public String getTestAnswerA() {
		return testAnswerA;
	}

	public void setTestAnswerA(String testAnswerA) {
		this.testAnswerA = testAnswerA;
	}

	public String getTestAnswerB() {
		return testAnswerB;
	}

	public void setTestAnswerB(String testAnswerB) {
		this.testAnswerB = testAnswerB;
	}

	public String getTestAnswerC() {
		return testAnswerC;
	}

	public void setTestAnswerC(String testAnswerC) {
		this.testAnswerC = testAnswerC;
	}

	public String getTestAnswerD() {
		return testAnswerD;
	}

	public void setTestAnswerD(String testAnswerD) {
		this.testAnswerD = testAnswerD;
	}

	public String getTestRightAnswer() {
		return testRightAnswer;
	}

	public void setTestRightAnswer(String testRightAnswer) {
		this.testRightAnswer = testRightAnswer;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestIsDifficulty() {
		return testIsDifficulty;
	}

	public void setTestIsDifficulty(String testIsDifficulty) {
		this.testIsDifficulty = testIsDifficulty;
	}

	public Date getTestUpLoadDate() {
		return testUpLoadDate;
	}

	public void setTestUpLoadDate(Date testUpLoadDate) {
		this.testUpLoadDate = testUpLoadDate;
	}
}
