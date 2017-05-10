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
		//����ļ�����������
		up.setHeaderEncoding("utf-8");
		List<FileItem> list=null;		
		try {
			list =(List<FileItem>)up.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//���ļ��浽uploadĿ¼
		List<FileBean> mylist = FileUtil.getList(list, uploadPath);
		//���ļ���Ϣ���浽���ݿ�
		FileService fs=new FileServiceImpl();
		fs.saveFile(mylist);
		//���ϴ��ɹ����ļ���Ϣת����ҳ��
		request.setAttribute("list", mylist);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
