package com.hqyj.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.ClassRoom;

public interface ClassroomService {
	
	PageInfo<ClassRoom> queryClassRoomAll(int pageNum);

}
