package com.hqyj.entity;
/**
 * 试卷
 */
import java.util.Date;
import java.util.List;

public class ExamPaper {
	
	private int examPaperId;
	//试卷的名称
	private String examPaperName;
	//试卷生成的日期
	private Date examPaperUpLoadDate;
	
	private Integer fkStudentId;
	
	private List<GenerateChoice> tests;
	
	private List<GenerateFill> fills;
	
	private List<GenerateArticle> articles;
	
	public List<GenerateChoice> getTests() {
		return tests;
	}

	public void setTests(List<GenerateChoice> tests) {
		this.tests = tests;
	}

	public List<GenerateFill> getFills() {
		return fills;
	}

	public void setFills(List<GenerateFill> fills) {
		this.fills = fills;
	}

	public List<GenerateArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<GenerateArticle> articles) {
		this.articles = articles;
	}

	public int getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(int examPaperId) {
		this.examPaperId = examPaperId;
	}

	public String getExamPaperName() {
		return examPaperName;
	}

	public void setExamPaperName(String examPaperName) {
		this.examPaperName = examPaperName;
	}

	public Date getExamPaperUpLoadDate() {
		return examPaperUpLoadDate;
	}

	public void setExamPaperUpLoadDate(Date examPaperUpLoadDate) {
		this.examPaperUpLoadDate = examPaperUpLoadDate;
	}

	public Integer getFkStudentId() {
		return fkStudentId;
	}

	public void setFkStudentId(Integer fkStudentId) {
		this.fkStudentId = fkStudentId;
	}

}
