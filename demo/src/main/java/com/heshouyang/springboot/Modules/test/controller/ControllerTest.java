package com.heshouyang.springboot.Modules.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.heshouyang.springboot.Modules.test.vo.configBean;

@Controller
@RequestMapping("/first")
public class ControllerTest {
	
	//在程序当中定义我们所自定义的logback，使其输出
	private final static Logger LOGGER = LoggerFactory.getLogger(ControllerTest.class); 
	
	@Value("${server.port}")
	private int port;
	@Value("${com.heshouyang.name}")
	private String name;
	@Value("${com.heshouyang.age}")
	private int age;
	@Value("${com.heshouyang.desc}")
	private String desc;
	@Value("${com.heshouyang.random}")
	private String random;
	
	@Autowired
	private configBean configBean;
	
	@RequestMapping("/logTest")
	@ResponseBody
	private String logTest() {
		LOGGER.trace("This is trace log");
		LOGGER.debug("This is debug log");
		LOGGER.info("This is info log");
		LOGGER.warn("This is warn log");
		LOGGER.error("This is error log");
		
		return "This is logTest Demo";
	}
	
	@RequestMapping("/config")
	@ResponseBody
	public String configTest() {
		StringBuffer sb = new StringBuffer();
		sb.append(port).append("--")
			.append(name).append("--")
			.append(age).append("--")
			.append(desc).append("--")
			.append(random).append("</br>");
		sb.append(configBean.getName()).append("--")
			.append(configBean.getAge()).append("--")
			.append(configBean.getDesc()).append("--")
			.append(configBean.getRandom()).append("</br>");
		return sb.toString();
	}
	
	@RequestMapping("/index")
	public String testIndexSimple(ModelMap map) {
		map.addAttribute("template","test/index");
		return "index";
		
	}
	@RequestMapping(value = "/download")
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) {
		try {
			Resource resource = new UrlResource(
					Paths.get(String.format("E:\\\\upLoad\\\\%s", fileName)).toUri());
			//判断文件是否存在或者是否可读
			if (resource.exists() && resource.isReadable()) {
				ResponseEntity responseEntity = ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_TYPE,"application/octet-stream")
						.header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", 
								resource.getFilename()))
						.body(resource);
				return responseEntity;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 以包装类 IOUtils 输出文件
	 */
	@RequestMapping("/download2")
	public void downloadFile2(HttpServletRequest request, 
			HttpServletResponse response, @RequestParam String fileName) {
		String filePath = "D:/upload" + File.separator + fileName;
		File downloadFile = new File(filePath);
		
		try {
			if (downloadFile.exists()) {
				response.setContentType("application/octet-stream");
				response.setContentLength((int)downloadFile.length());
				response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
						String.format("attachment; filename=\"%s\"", fileName));
				
				InputStream is = new FileInputStream(downloadFile);
				IOUtils.copy(is, response.getOutputStream());
				response.flushBuffer();
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/upBatchLoad",consumes = "multipart/form-data")
	//接收文件类型的参数,RedirectAttribute解决重定向页面之间的跳转的问题。虽然是form表单的形式，modelAndAttribute是以键值对的形式传递参数
	public String upBatchFile(@RequestParam MultipartFile[] files,RedirectAttributes redirectAttributes) {
		
		boolean isEmpty = true;
		
		try {
			for (MultipartFile file : files) {
				if (file.isEmpty()) {
					continue;
				}
				String filename = file.getOriginalFilename();
				File desc = new File(String.format("E:\\upLoad\\%s", filename));
				file.transferTo(desc);
				isEmpty = false;
			}
			
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "upload faild");
			return "redirect:/first/index";
		}
		if (isEmpty) {
			redirectAttributes.addFlashAttribute("message", "upload select files");
		}else {
			redirectAttributes.addFlashAttribute("message", "upload successful");
		}
		
		return "redirect:/first/index";
		
	}
	
	@RequestMapping(value = "/upLoad",consumes = "multipart/form-data")
	//接收文件类型的参数,RedirectAttribute解决重定向页面之间的跳转的问题。虽然是form表单的形式，modelAndAttribute是以键值对的形式传递参数
	public String upLoadFile(@RequestParam MultipartFile file,RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "please select file");
			return "redirect:/first/index";
		}
		String filename = file.getOriginalFilename();
		
		File dest = new File(String.format("E:\\upLoad\\%s", filename));
		try {
			file.transferTo(dest);
			redirectAttributes.addFlashAttribute("message", "upload successful");
		} catch (IllegalStateException | IOException e) {
			LOGGER.debug(e.getMessage());
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "upload faild");
		}
		return "redirect:/first/index";
		
	}
	@RequestMapping("/goTest")
	@ResponseBody
	private String testGo() {
		
		return "spring Boot";
	}
}
