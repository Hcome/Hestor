package com.hqyj.entity;

public class Student {
   
	private Integer studentId;

    private Integer studentNum;

    private String studentName;

    private String studentGender;

    private Integer studentAge;

    private String studentTel;

    private String studentEmail;
    
    private String studentDepartClass;
    
    private Integer fkUserId;
    
    private String fkClassName;
    
    private Integer fkClassroomId;
    
    private Score score;
    
	public Integer getFkClassroomId() {
		return fkClassroomId;
	}

	public void setFkClassroomId(Integer fkClassroomId) {
		this.fkClassroomId = fkClassroomId;
	}

	public String getFkClassName() {
		return fkClassName;
	}

	public void setFkClassName(String fkClassName) {
		this.fkClassName = fkClassName;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getStudentDepartClass() {
		return studentDepartClass;
	}

	public void setStudentDepartClass(String studentDepartClass) {
		this.studentDepartClass = studentDepartClass;
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

}