package com.hqyj.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.ClassRoom;
import com.hqyj.model.vo.Result;

public interface ClassroomService {
	
	PageInfo<ClassRoom> queryClassRoomAll(int pageNum);

	int insertClass(ClassRoom classRoom);
	
	int updateClassroomByClassroomId(ClassRoom classRoom);
	
	ClassRoom queryClassroomByClassroomId(Integer clssroomId);
	
	Result deleteClassroomByClassroomId(Integer classroomId);
	
	PageInfo<ClassRoom> seleClassRoomsIsNull(int pageNum);
	
	public List<ClassRoom> findClassRoomIsNull();
}
