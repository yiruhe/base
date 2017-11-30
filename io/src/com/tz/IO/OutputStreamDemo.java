package com.tz.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {
	
	public static void main(String[] args) {
		
		
//		File file = new File("f:/1.txt");
//		try{
//			
//			FileOutputStream out = new FileOutputStream(file);
//			String content = "哈哈哈";
//			byte[] bt = content.getBytes();
//			out.write(bt);
//			out.close();
//		}catch(IOException e){
//			
//			e.printStackTrace();
//		}
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			//输入
			File file = new File("E:/javase/视频/Day12_数组排序/Day12_02-冒泡排序.wmv.pbb");
			//输出
			File file2 = new File("E:/javase/视频/Day12_数组排序/Day12_02.wmv.pbb");
			
			 in = new FileInputStream(file); 
			 out = new FileOutputStream(file2); 
			 
			 byte[] bt = new byte[1024];
			 int len = 0;
			 while((len = in.read(bt)) != -1){
				 
				 out.write(bt,0,len);
			 }
			 System.out.println("完成");
		}catch(IOException e){
			
			e.printStackTrace();
			
		}finally{
			try{
				
				out.close();
				in.close();
			}catch(IOException e){
				
				e.printStackTrace();
			}
		}
	
	}

}
