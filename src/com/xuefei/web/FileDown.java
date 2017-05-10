package com.xuefei.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuefei.entity.FileBean;
import com.xuefei.service.FileService;
import com.xuefei.serviceImpl.FileServiceImpl;

public class FileDown extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		int myid=Integer.parseInt(id);
		FileService fs=new FileServiceImpl();
		FileBean filebean = fs.findById(myid);
		InputStream ips = new FileInputStream(filebean.getPath());
		response.setHeader("content-disposition", "attachment;filename="+filebean.getName());
		ServletOutputStream ops = response.getOutputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=ips.read(b))!=-1){
			ops.write(b, 0, len);
		}
		ips.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
