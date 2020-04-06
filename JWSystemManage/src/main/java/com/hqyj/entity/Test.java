package com.hqyj.entity;
/**
 * 试题
 */
import java.util.Date;

public class Test {
	
	private int testId;
	private String testText;
	//试题的类型
	private String testType;
	//试题难易程度
	private String testIsDifficulty;
	private Date testUpLoadDate;
	private int fkTeacherId;
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestText() {
		return testText;
	}
	public void setTestText(String testText) {
		this.testText = testText;
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
	public int getFkTeacherId() {
		return fkTeacherId;
	}
	public void setFkTeacherId(int fkTeacherId) {
		this.fkTeacherId = fkTeacherId;
	}
	

}
