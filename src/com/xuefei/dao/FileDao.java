package com.xuefei.dao;

import java.util.List;

import com.xuefei.entity.FileBean;

public interface FileDao {
	public abstract void saveFile(List<FileBean> list);
	public abstract List<FileBean> findAll();
	public abstract FileBean findById(int id);
}
