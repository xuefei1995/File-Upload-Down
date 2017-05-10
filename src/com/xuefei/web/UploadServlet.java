package com.xuefei.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xuefei.entity.FileBean;
import com.xuefei.service.FileService;
import com.xuefei.serviceImpl.FileServiceImpl;
import com.xuefei.util.FileUtil;

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tempPath = this.getServletContext().getRealPath("/temp");
		String uploadPath=this.getServletContext().getRealPath("/upload");
		
		DiskFileItemFactory factory=new DiskFileItemFactory(10*1024,new File(tempPath));
		ServletFileUpload up=new ServletFileUpload(factory);
		//解决文件名中文乱码
		up.setHeaderEncoding("utf-8");
		List<FileItem> list=null;		
		try {
			list =(List<FileItem>)up.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//把文件存到upload目录
		List<FileBean> mylist = FileUtil.getList(list, uploadPath);
		//把文件信息保存到数据库
		FileService fs=new FileServiceImpl();
		fs.saveFile(mylist);
		//把上传成功的文件信息转发到页面
		request.setAttribute("list", mylist);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
