package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.ClassRoom;

public interface ClassroomMapper {

	/**
	 * 查询全部符合考试的教师信息
	 * @return
	 */
	List<ClassRoom> queryClassRoomAll();
	/**
	 * 添加教室信息
	 */
	int insertClass(ClassRoom classRoom);
	/**
	 * 
	 * 修改教室信息
	 */
	int updateClassroom(ClassRoom classRoom);
	/**
	 * 根据id查询教室信息
	 */
	ClassRoom queryClassroomByClassroomId(Integer clssroomId);
	/**
	 * 删除教室信息
	 */
	int deleteClassroomByClassroomId(Integer classroomId);
	/**
	 * 查询所有的空闲教室
	 */
	List<ClassRoom> seleClassRoomsIsNull();
}
