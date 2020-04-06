package com.hqyj.entity;
/**
 * 试卷
 */
import java.util.Date;

public class ExamPaper {
	
	private int examPaperId;
	//试卷的内容
	private String examPaperText;
	//试卷的难易程度
	private String examPaperType;
	//试卷生成的日期
	private Date examPaperUpLoadDate;
	
	private int fkTeacherId;

	public int getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(int examPaperId) {
		this.examPaperId = examPaperId;
	}

	public String getExamPaperText() {
		return examPaperText;
	}

	public void setExamPaperText(String examPaperText) {
		this.examPaperText = examPaperText;
	}

	public String getExamPaperType() {
		return examPaperType;
	}

	public void setExamPaperType(String examPaperType) {
		this.examPaperType = examPaperType;
	}

	public Date getExamPaperUpLoadDate() {
		return examPaperUpLoadDate;
	}

	public void setExamPaperUpLoadDate(Date examPaperUpLoadDate) {
		this.examPaperUpLoadDate = examPaperUpLoadDate;
	}

	public int getFkTeacherId() {
		return fkTeacherId;
	}

	public void setFkTeacherId(int fkTeacherId) {
		this.fkTeacherId = fkTeacherId;
	}
	
}
