package com.hqyj.entity;

public class Score {
    private Integer scoreId;
    
    private Integer scoreNunber;
    //是否及格
    private String isPass;
    
    private String fkStudentId;

	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Integer getScoreNunber() {
		return scoreNunber;
	}

	public void setScoreNunber(Integer scoreNunber) {
		this.scoreNunber = scoreNunber;
	}

	public String getIsPass() {
		return isPass;
	}

	public void setIsPass(String isPass) {
		this.isPass = isPass;
	}

	public String getFkStudentId() {
		return fkStudentId;
	}

	public void setFkStudentId(String fkStudentId) {
		this.fkStudentId = fkStudentId;
	}

}