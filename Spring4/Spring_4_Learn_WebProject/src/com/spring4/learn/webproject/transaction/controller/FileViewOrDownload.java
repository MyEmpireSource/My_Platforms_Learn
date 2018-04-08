package com.spring4.learn.webproject.transaction.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring4.learn.webproject.util.FileContentType;
import com.spring4.learn.webproject.util.Util;

@Controller
@RequestMapping("/viewOrDownload")
public class FileViewOrDownload {
	// https://blog.csdn.net/wuruijie321/article/details/78055572
	
	private static Map<String, String> FILE_INFO_MAP = new HashMap<String, String> () {
		{
			put("txt", "3.txt"); // GBK
			put("json", "SjWebProjectMobile.postman_collection.json"); //UTF-8
			put("jpg", "4.jpg");
			put("pdf", "5.pdf");
			put("sql", "ry.sql"); //GBK
		};
	};
	
	//viewOrDownload/viewShowOrDownload?chooseFileType=pdf&isView=true&encoding=utf-8&isText=false
	@RequestMapping(value = "/viewShowOrDownload", method = {RequestMethod.POST, RequestMethod.GET})
	public void viewShowOrDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		System.out.println(request.getParameterMap().toString());
		System.out.println(request.getParameterNames().toString());
		System.out.println(request.getParameterValues("chooseFileType"));
		
		System.out.println(request.getAttributeNames().toString());
		
		System.out.println(request.getAttribute("chooseFileType"));
		System.out.println(request.getAttribute("isView"));
		System.out.println(request.getAttribute("encoding"));
		System.out.println(request.getAttribute("isText"));
		*/
		//文件类型
		String chooseFileType = request.getParameter("chooseFileType");
		//是否是预览
		String isView = request.getParameter("isView");
		//response.head.content-type 编码
		String encoding = request.getParameter("encoding");
		//是否以文本来处理
		String isText = request.getParameter("isText");
		
		isView = Util.isNullOrSpaces(isView) ? "true" : isView;
		isText = Util.isNullOrSpaces(isText) ? "false" : isText;
		encoding = Util.isNullOrSpaces(encoding) ? "utf-8" : encoding;
		
		//文件存放地址物理地址
		String filePath = request.getServletContext().getRealPath("/Files");
		
		String fileName = FILE_INFO_MAP.get(chooseFileType);
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		////根据文件按类型设置content-type
		response.setContentType(FileContentType.FILE_CONTENT_TYPE_MAP.get(fileType) == null 
				? "application/octet-stream" : FileContentType.FILE_CONTENT_TYPE_MAP.get(fileType));
		
		
		if ("false".equals(isView)) {
			//下载
			String encodeFileName = URLEncoder.encode(fileName, "UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + encodeFileName + "\"");
		}
		
		byte[] buffer = new byte[1024];
		int readLenght = 0;
		
		if ("true".equals(isText) || fileType.equals("txt") || fileType.equals("sql") || fileType.equals("json") || fileType.equals("vsd")) {
			response.setHeader("content-type", "text/html;charset=" + encoding);
		}
	
		File file = new File(filePath + "/" + fileName);
		
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(file);
		
		while((readLenght = is.read(buffer)) != -1) {
			os.write(buffer, 0, readLenght);
		}
		
		os.flush();
		os.close();
		is.close();
	}
	
	/**
	 * 
	 * @Title: uploadFile
	 * @Description: 上传文件
	 * 
	 * @Params:
	 *   @param request
	 *   @param response
	 *   @throws IOException
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年3月30日 下午3:29:24
	 * @ChangeDate: 2018年3月30日 下午3:29:24
	 * @Author: ZCX
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<MultipartFile> mFileList = request.getFiles("file");
		
		System.out.println(request.getParameterMap());
				
		String att_1 = request.getParameter("att_1");
		String att_2 = request.getParameter("att_2");
		
		System.out.println(att_1);
		System.out.println(att_2);
		
		String filePath = request.getServletContext().getRealPath("/fileUpload");
		
		for (MultipartFile file : mFileList) {
			System.out.println(file.getName());
			System.out.println(file.getContentType());
			System.out.println(file.getOriginalFilename());
			//System.out.println(URLEncoder.encode(file.getOriginalFilename(), "UTF-8"));
			//System.out.println(new String(file.getOriginalFilename().getBytes(), "UTF-8"));
			System.out.println(file.getSize());
			
			file.transferTo(new File(filePath + "/" + file.getOriginalFilename()));
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("{'msg':'OK'}");
	}
	
}
