package com.hqyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.ClassRoom;
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
}
