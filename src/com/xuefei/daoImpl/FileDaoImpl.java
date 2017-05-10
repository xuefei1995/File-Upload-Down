package com.xuefei.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xuefei.dao.FileDao;
import com.xuefei.entity.FileBean;
import com.xuefei.util.JdbcUtil;

public class FileDaoImpl implements FileDao {

	@Override
	public void saveFile(List<FileBean> list) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="INSERT INTO file_list(NAME,size,TYPE,TIME,path) VALUE(?,?,?,?,?)";		
		for (FileBean fb : list) {
			Object[] obj={fb.getName(),fb.getSize(),fb.getType(),fb.getTime(),fb.getPath()};
			try {
				qr.update(sql, obj);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FileBean> findAll() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="SELECT * FROM file_list";
		Object[] obj={};
		List<FileBean> list=null;
		try {
			list = (List<FileBean>)qr.query(sql, new BeanListHandler(FileBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public FileBean findById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="SELECT * FROM file_list WHERE id=?";
		FileBean fb=null;
		try {
			fb=(FileBean)qr.query(sql, new BeanHandler(FileBean.class), new Object[]{id});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fb;
	}

}
