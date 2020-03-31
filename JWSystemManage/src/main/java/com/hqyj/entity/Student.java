package com.hqyj.entity;

public class Student {
   
	private Integer studentId;

    private Integer studentNum;

    private String studentName;

    private String studentGender;

    private Integer studentAge;

    private String studentTel;

    private String studentEmail;

    private Integer fkUserId;

    private Integer fkDivisionId;
    
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNum=" + studentNum + ", studentName=" + studentName
				+ ", studentGender=" + studentGender + ", studentAge=" + studentAge + ", studentTel=" + studentTel
				+ ", studentEmail=" + studentEmail + ", fkUserId=" + fkUserId + ", fkDivisionId=" + fkDivisionId + "]";
	}

	public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender == null ? null : studentGender.trim();
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentTel() {
        return studentTel;
    }

    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel == null ? null : studentTel.trim();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }

    public Integer getFkDivisionId() {
        return fkDivisionId;
    }

    public void setFkDivisionId(Integer fkDivisionId) {
        this.fkDivisionId = fkDivisionId;
    }
}