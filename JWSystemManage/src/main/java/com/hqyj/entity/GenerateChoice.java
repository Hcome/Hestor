package com.hqyj.entity;
/**
 * 
 * 存储学生提交试卷的选择题
 * @author Administrator
 *
 */
public class GenerateChoice {
	/**
	 * 选择题的问题对应的答案以及学生提交的答案
	 */
	private Integer generateChoiceId;

	private String generateChoiceQuestion;
	
	private String generateChoiceAnswerA;

	private String generateChoiceAnswerB;
	
	private String generateChoiceAnswerC;
	
	private String generateChoiceAnswerD;

	private String generateStudentAnswer;
	//试题的类型，用来标记分表存储的标识
	private String generateChoiceType;

	public Integer getGenerateChoiceId() {
		return generateChoiceId;
	}

	public void setGenerateChoiceId(Integer generateChoiceId) {
		this.generateChoiceId = generateChoiceId;
	}

	public String getGenerateChoiceQuestion() {
		return generateChoiceQuestion;
	}

	public void setGenerateChoiceQuestion(String generateChoiceQuestion) {
		this.generateChoiceQuestion = generateChoiceQuestion;
	}

	public String getGenerateChoiceAnswerA() {
		return generateChoiceAnswerA;
	}

	public void setGenerateChoiceAnswerA(String generateChoiceAnswerA) {
		this.generateChoiceAnswerA = generateChoiceAnswerA;
	}

	public String getGenerateChoiceAnswerB() {
		return generateChoiceAnswerB;
	}

	public void setGenerateChoiceAnswerB(String generateChoiceAnswerB) {
		this.generateChoiceAnswerB = generateChoiceAnswerB;
	}

	public String getGenerateChoiceAnswerC() {
		return generateChoiceAnswerC;
	}

	public void setGenerateChoiceAnswerC(String generateChoiceAnswerC) {
		this.generateChoiceAnswerC = generateChoiceAnswerC;
	}

	public String getGenerateChoiceAnswerD() {
		return generateChoiceAnswerD;
	}

	public void setGenerateChoiceAnswerD(String generateChoiceAnswerD) {
		this.generateChoiceAnswerD = generateChoiceAnswerD;
	}

	public String getGenerateStudentAnswer() {
		return generateStudentAnswer;
	}

	public void setGenerateStudentAnswer(String generateStudentAnswer) {
		this.generateStudentAnswer = generateStudentAnswer;
	}

	public String getGenerateChoiceType() {
		return generateChoiceType;
	}

	public void setGenerateChoiceType(String generateChoiceType) {
		this.generateChoiceType = generateChoiceType;
	}

}
