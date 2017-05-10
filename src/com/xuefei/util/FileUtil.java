package com.xuefei.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

import com.xuefei.entity.FileBean;

public class FileUtil {
	public static List<FileBean> getList(List<FileItem> list,String uploadPath){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		List<FileBean> mylist=new ArrayList<FileBean>();
		if(list!=null){
			for (FileItem item : list) {
				//��ȡΨһ�ļ���
				String name = item.getName();
				name=name.substring(name.lastIndexOf("."));
				String uuid = UUID.randomUUID().toString();
				String filename=uuid+name;
				//��ȡ�ļ���С
				long size = item.getSize();
				String sizeStr = "";
				if(size>=1024 && size<1024*1024){
					sizeStr = (size/1024.0)+"KB";
				}else if(size>1024*1024 && size<=1024*1024*1024){
					sizeStr = (size/(1024*1024.0))+"MB";
				}else if(size >= 1024*1024*1024){
					sizeStr = (size/(1024*1024.0*1024))+"GB";
				}else{
					sizeStr = size+"B";
				}
				//��ȡ�ļ�����
				String type = item.getContentType();
				//��ȡ�ļ�����ʱ��
				String time=sdf.format(new Date());
				//��ȡ�ļ�����·��
				String path=uploadPath+"/"+filename;
				
				//�����ļ�
				try {
					InputStream in = item.getInputStream();
					FileUtils.copyInputStreamToFile(in, new File(path));
				} catch (IOException e) {
					e.printStackTrace();
				}
								
				item.delete();
				FileBean fb=new FileBean();
				fb.setName(filename);
				fb.setSize(sizeStr);
				fb.setType(type);
				fb.setTime(time);
				fb.setPath(path);
				mylist.add(fb);
			}			
		}
		return mylist;
	}
}
