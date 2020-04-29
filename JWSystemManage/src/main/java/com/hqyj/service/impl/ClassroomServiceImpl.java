package com.hqyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.dao.ClassroomMapper;
import com.hqyj.entity.ClassRoom;
import com.hqyj.model.vo.Result;
import com.hqyj.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService{
	
	@Autowired
	private ClassroomMapper cm;

	@SuppressWarnings("static-access")
	@Override
	public PageInfo<ClassRoom> queryClassRoomAll(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		List<ClassRoom> list = cm.queryClassRoomAll();
		PageInfo< ClassRoom> info = new PageInfo<ClassRoom>(list);
		return info;
	}

	@Override
	public int insertClass(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		return cm.insertClass(classRoom);
	}

	@Override
	public int updateClassroomByClassroomId(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		return cm.updateClassroom(classRoom);
	}

	@Override
	public ClassRoom queryClassroomByClassroomId(Integer clssroomId) {
		
		return cm.queryClassroomByClassroomId(clssroomId);
	}

	@Override
	public Result deleteClassroomByClassroomId(Integer classroomId) {
		int num = cm.deleteClassroomByClassroomId(classroomId);
		if (num > 0) {
			return new Result("200", "删除成功");
		}else {
			return new Result("500", "删除失败");
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public PageInfo<ClassRoom> seleClassRoomsIsNull(int pageNum) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum,3);
		
		List<ClassRoom> list = cm.seleClassRoomsIsNull();		
		PageInfo<ClassRoom> info = new PageInfo<>(list);
		return info;
	}
	
	public List<ClassRoom> findClassRoomIsNull() {
		List<ClassRoom> list = cm.seleClassRoomsIsNull();
		return list;
	}
}
