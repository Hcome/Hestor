package com.hqyj.entity;
/**
 * 作为学生考试填空题提交的实体类
 * @author Administrator
 *
 */
public class GenerateFill {

	private Integer generateFillId;
	//填空问题
	private String generateFillQuestion;
	//学生回答的答案
	private String generateFillAnswer;
	//题目的类型
	private String generateFillType;
	
	public Integer getGenerateFillId() {
		return generateFillId;
	}
	public void setGenerateFillId(Integer generateFillId) {
		this.generateFillId = generateFillId;
	}
	public String getGenerateFillQuestion() {
		return generateFillQuestion;
	}
	public void setGenerateFillQuestion(String generateFillQuestion) {
		this.generateFillQuestion = generateFillQuestion;
	}
	public String getGenerateFillAnswer() {
		return generateFillAnswer;
	}
	public void setGenerateFillAnswer(String generateFillAnswer) {
		this.generateFillAnswer = generateFillAnswer;
	}
	public String getGenerateFillType() {
		return generateFillType;
	}
	public void setGenerateFillType(String generateFillType) {
		this.generateFillType = generateFillType;
	}

}
