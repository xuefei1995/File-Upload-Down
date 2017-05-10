package com.xuefei.serviceImpl;

import java.util.List;

import com.xuefei.dao.FileDao;
import com.xuefei.daoImpl.FileDaoImpl;
import com.xuefei.entity.FileBean;
import com.xuefei.service.FileService;

public class FileServiceImpl implements FileService {
	FileDao dao=new FileDaoImpl();
	@Override
	public void saveFile(List<FileBean> list) {
		dao.saveFile(list);
	}

	@Override
	public List<FileBean> findAll() {
		List<FileBean> list = dao.findAll();
		return list;
	}

	@Override
	public FileBean findById(int id) {
		FileBean fb = dao.findById(id);
		return fb;
	}

}
