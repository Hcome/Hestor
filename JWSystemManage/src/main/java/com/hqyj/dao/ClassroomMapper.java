package com.hqyj.dao;

import java.util.List;

import com.hqyj.entity.ClassRoom;

public interface ClassroomMapper {

	/**
	 * 查询全部符合考试的教师信息
	 * @return
	 */
	List<ClassRoom> queryClassRoomAll();
}
