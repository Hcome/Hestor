package com.hqyj.entity;

/**
 * 班级实体类
 * @author Administrator
 *
 */
public class Clazz {
	
	private int clazzId;
	private String clazzNema;
	private String fkTeacherId;
	private Student student;
	


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getClazzId() {
		return clazzId;
	}
	
	public void setClazzId(int clazzId) {
		this.clazzId = clazzId;
	}
	
	public String getClazzNema() {
		return clazzNema;
	}
	
	public void setClazzNema(String clazzNema) {
		this.clazzNema = clazzNema;
	}
	
	public String getFkTeacherId() {
		return fkTeacherId;
	}
	
	public void setFkTeacherId(String fkTeacherId) {
		this.fkTeacherId = fkTeacherId;
	}
}
