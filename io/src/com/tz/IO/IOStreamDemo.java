package com.tz.IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
public class IOStreamDemo {
	private static List<File> lists = new ArrayList<File>();
	public static void main(String[] args){
		
		File file = new File("f:/1.txt");
		System.out.println(file.getPath());
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		//一个汉字两个字节
		System.out.println(file.length());
		//是不是一个只读文件
		System.out.println(file.canRead());
		//是不是可写文件
		System.out.println(file.canWrite());
		//是不是隐藏文件
		System.out.println(file.isHidden());
		System.out.println(new Date(file.lastModified()));
		try{
			if(!file.exists()){
				file.createNewFile();
			}else{
				System.out.println("存在");
			}
			
		}catch(IOException e){
			
			e.printStackTrace();
		}
		
		
		//目录创建
		File file2 = new File("f:/a");
//		if(!file2.exists()){
//			file2.mkdirs();
//		}
//		删除文件
//		file2.delete();
		
		
//		for(String string: file2.list()){
//			
//			System.out.println(string);
//			
//		}
		
//		for(File f:file2.listFiles()){
//			
//			System.out.println(f.getAbsolutePath());
//		}
		
		 IOStreamDemo.getFiles(file2);
		
		System.out.println(lists);
	}
	
	public static void getFiles(File dir){
		
		File[] files = dir.listFiles();
		
		for(File file:  files){
			
			if(file.isFile()){
				
				IOStreamDemo.lists.add(file);
			}
			
			if(file.isDirectory()){
				
				IOStreamDemo.getFiles(file);
			}
			
		}
		
		
	}

}
