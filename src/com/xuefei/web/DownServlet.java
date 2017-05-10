package com.xuefei.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuefei.entity.FileBean;
import com.xuefei.service.FileService;
import com.xuefei.serviceImpl.FileServiceImpl;

public class DownServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileService fs=new FileServiceImpl();
		List<FileBean> list = fs.findAll();
		request.setAttribute("filelist", list);
		request.getRequestDispatcher("/down.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
