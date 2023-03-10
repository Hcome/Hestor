package com.hqyj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.hqyj.entity.Admin;
import com.hqyj.entity.Role;
import com.hqyj.entity.Student;
import com.hqyj.entity.Teacher;
import com.hqyj.entity.User;
import com.hqyj.model.vo.Result;
import com.hqyj.model.vo.SearchInfo;
import com.hqyj.model.vo.UserAndRole;
import com.hqyj.service.AdminService;
import com.hqyj.service.RoleService;
import com.hqyj.service.StudentService;
import com.hqyj.service.TeacherService;
import com.hqyj.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;
	@Autowired
	private StudentService ss;
	@Autowired
	private TeacherService ts;
	@Autowired
	private AdminService as;

	@RequestMapping(value = "/queryUser")
	@ResponseBody
	public PageInfo<User> queryUser(SearchInfo searchInfo) {
		System.out.println(searchInfo.getCurrentPage());
		PageInfo<User> info = us.selectUserAll(searchInfo.getCurrentPage());
		return info;
	}
	
	@RequestMapping("/goQueryUser")
	public String goQueryUser() {
		return "userList";
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	public Result deleteUserById(User user) {
		return us.deleteUserById(user.getUserId());
	}

	@RequestMapping("queryUserById")
	public String selectUserById(User user, HttpServletRequest request) {
		User u = us.selectUserById(user.getUserId());
		List<Role> roles = rs.selectRoleAll();
		request.getSession().setAttribute("u", u);
		request.getSession().setAttribute("roles", roles);
		return "userUpdate";
	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, String[] roleId,HttpServletRequest request) {
		//????????????userid????????????id??????session????????????????????????????????????
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("roleId", roleId);
		//??????user????????????
		int num = us.updateUser(user);
		if (num > 0) {
			//?????????????????????????????????
			int num1 = us.deleteUserAndRole(user.getUserId());
			if (num1 > 0) {
				for (String str : roleId) {
					Integer rId = Integer.parseInt(str);
					if (rId!=null) {
						//??????????????????????????????????????????
						UserAndRole ur = new UserAndRole();
						ur.setUserId(user.getUserId());
						ur.setRoleId(rId);
						us.insertUserAndRole(ur);
					}
				}
				
			}
		}
		//?????????????????????????????????
		for (String str : roleId) {
			int role = Integer.parseInt(str);
			if (role == 1) {
				return "addAdmin";
			}else if (role == 2) {
				return "addTeacher";
			}else if(role == 3){
				return "addStudent";
			}else if (role == 1&& role == 2) {
				return "addAdmin";
			}
		}
		return "redirect:goQueryUser";
	}
	/**
	 * ?????????????????????????????????????????????????????????
	 * @param teacher
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addAdminAndTeacher",method=RequestMethod.POST)
	public String addAdminAndTeacher(Admin admin,HttpServletRequest request) {
		
		int userid = (int) request.getSession().getAttribute("userId");
		String[] role = (String[]) request.getSession().getAttribute("roleId");
		System.out.println(userid+"_+_+_+_++_++_+_++_+");
		
		for (String str : role) {
			
			int roleId = Integer.parseInt(str);
			if (roleId == 1) {
				admin.setFkUserId(userid);
				int num2 = as.insertAdmin(admin);
				System.out.println("?????????????????????"+num2);
			}else if (roleId == 2) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(admin.getAdminId());
				teacher.setFkUserId(admin.getFkUserId());
				teacher.setTeacherAge(admin.getAdminAge());
				teacher.setTeacherEmail(admin.getAdminEmail());
				teacher.setTeacherGender(admin.getAdminGender());
				teacher.setTeacherName(admin.getAdminName());
				teacher.setTeacherNum(admin.getAdminNum());
				teacher.setTeacherTel(admin.getAdminTel());
				int num2 = ts.insertTeacher(teacher);
				System.out.println("?????????????????????"+num2);
			}
		}
		return "adminList";	
	}
	/**
	 * ??????????????????
	 * @param teacher
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addTeacher",method=RequestMethod.POST)
	public String addTeacher(Teacher teacher,HttpServletRequest request) {
		
		int userid = (int) request.getSession().getAttribute("userId");
		String[] role = (String[]) request.getSession().getAttribute("roleId");
		System.out.println(userid+"________________________");
		
		for (String str : role) {
			int roleId = Integer.parseInt(str);
			if (roleId == 2) {
				teacher.setFkUserId(userid);
				int num1 = ts.insertTeacher(teacher);
				System.out.println("?????????????????????"+num1);
			}
		}
		return "teacherList";	
	}
	/**
	 * ??????????????????
	 * @param student
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addStu")
	public String addStudent(Student student,HttpServletRequest request) {
		
		int userid = (int) request.getSession().getAttribute("userId");
		String[] role = (String[]) request.getSession().getAttribute("roleId");
		System.out.println(userid+"~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for (String str : role) {
			int roleId = Integer.parseInt(str);
			if (roleId == 3) {
				student.setFkUserId(userid);
				int num1 = ss.insertStudent(student);
				System.out.println("?????????????????????"+num1);
			}
		}
		return "studentList";	
	}
	//???????????????????????????????????????
	@RequestMapping(value = "/goQueryUsersAndRoles")
	public String goQueryUsersAndRoles() {
		return "unKownUserList";
	}
	@RequestMapping(value = "/queryUsersAndRoles")
	@ResponseBody
	public PageInfo<User> queryUsersAndRoles(SearchInfo searchInfo) {
		
		PageInfo<User> pageInfo = us.queryUsersAndRoles(searchInfo.getCurrentPage());
		return pageInfo;
	}
}
