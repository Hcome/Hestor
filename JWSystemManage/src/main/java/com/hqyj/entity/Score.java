package com.hqyj.entity;

public class Score {
    private Integer scoreId;
    
    private Integer scoreNunber;
    //是否及格
    private String isPass;
    
    private Integer fkStudentId;

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

	public Integer getFkStudentId() {
		return fkStudentId;
	}

	public void setFkStudentId(Integer fkStudentId) {
		this.fkStudentId = fkStudentId;
	}

}