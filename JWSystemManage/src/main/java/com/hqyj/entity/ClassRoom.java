package com.hqyj.entity;
/**
 * 教室
 * @author Administrator
 *
 */
public class ClassRoom {

	private int classRoomId;
	private String classRoomName;
	//教室容纳的人数
	private String classRoomNumber;
	//教室是否处于空闲状态
	private String classRoomStutas;
	public int getClassRoomId() {
		return classRoomId;
	}
	public void setClassRoomId(int classRoomId) {
		this.classRoomId = classRoomId;
	}
	public String getClassRoomName() {
		return classRoomName;
	}
	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}
	public String getClassRoomNumber() {
		return classRoomNumber;
	}
	public void setClassRoomNumber(String classRoomNumber) {
		this.classRoomNumber = classRoomNumber;
	}
	public String getClassRoomStutas() {
		return classRoomStutas;
	}
	public void setClassRoomStutas(String classRoomStutas) {
		this.classRoomStutas = classRoomStutas;
	}
}
