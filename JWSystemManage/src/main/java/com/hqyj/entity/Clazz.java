package com.hqyj.entity;

import java.util.List;

/**
 * 班级实体类
 * @author Administrator
 *
 */
public class Clazz {
	
	private int clazzId;
	private String clazzNema;
	private String fkTeacherId;
	private List<Student> students;
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
