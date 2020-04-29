package com.hqyj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.ClassRoom;
import com.hqyj.model.vo.Result;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.service.ClassroomService;

@Controller
@RequestMapping(value = "/classroom")
public class ClassroomController {
	
	@Autowired
	private ClassroomService cs;
	
	@RequestMapping(value = "/goQueryClassRoomAll")
	public String goQueryClassRoomAll() {
		return "classroomList";
	}
	@RequestMapping("queryClassRoomAll")
	@ResponseBody
	public PageInfo<ClassRoom> queryClassRoomAll(SearchInfo searchInfo) {
		
		PageInfo<ClassRoom> info = cs.queryClassRoomAll(searchInfo.getCurrentPage());
		return info;
	}
	
	@RequestMapping("/addClassroom")
	public String addClass(ClassRoom classRoom) {
		int num = cs.insertClass(classRoom);
		System.out.println("受影响的行数"+num);
		return "classroomList";
	}
	@RequestMapping("/queryClassroomByClassroomId")
	public String  queryClassroomByClassroomId(Integer id,HttpServletRequest request) {
		ClassRoom classRoom = cs.queryClassroomByClassroomId(id);
		request.getSession().setAttribute("classRoom", classRoom);
		return "updateClassroom";
	}
	@RequestMapping("/updateClassroomByClassroomId")
	public String updateClassroomByClassroomId(ClassRoom classRoom,HttpServletRequest request) {
		ClassRoom classRoom1 = (ClassRoom) request.getSession().getAttribute("classRoom");
		classRoom.setClassRoomId(classRoom1.getClassRoomId());
		cs.updateClassroomByClassroomId(classRoom);
		return "classroomList";
	}
	@RequestMapping("/deleteClassroomByClassroomId")
	@ResponseBody
	public Result deleteClassroomByClassroomId(Integer classroomId) {
		Result result = cs.deleteClassroomByClassroomId(classroomId);
		return result;
	}
	
	/**
	 * 查询所有的空闲教室
	 */
	@RequestMapping("/goFindAllClassroomIsNull")
	public String goFindAllClassroomIsNull() {
		return "classroomList2";
	}
	@RequestMapping("/findAllClassroomIsNull")
	@ResponseBody
	public PageInfo<ClassRoom> findAllClassroomIsNull(SearchInfo searchInfo) {
		PageInfo<ClassRoom> info = cs.seleClassRoomsIsNull(searchInfo.getCurrentPage());
		return info;
	}
}
