package com.tz.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class InputStreamDemo {

		/*
					输入 inputStream 输出outputStream  
					
					字节流  stream: 
		*				用于文件复制粘贴和处理二进制数据 -->图片/视频、音频
		* 				以一个字节来读  byte[]
		* 
		* 
		* 			字符流    
		* 				用于操作文本内容，列如添加删除修改里面的内容
		* 				以两个byte的单位进行读取和写入 char[]
		*/
		public static void main(String[] args) {
			
			FileInputStream input = null;
			try{
				
				//创建文件对象
				File files = new File("F:/a/2.txt");
				
				//创建一个文件流输入对象
				input = new FileInputStream(files);
				//read() 方法
				//input.read();
				
				//int len = input.read(); //返回读到的字节数
//				int len =0;  
//				while((len = input.read())!= -1){
//					System.out.println((char)len);
//				}
				
				//read(byte[]) 方法  // 返回读取的长度
				//如果1024不够，又会重新开辟新的1024数组
//				byte[] bs = new byte[1024];  //128
//				int len = 0;
//				while((len = input.read(bs)) != -1){
////					System.out.println(len);
//					System.out.println(new String(bs));
//				}
//				files.length(); 返回文件字节数 long类型
				long fsLength = files.length();
				byte[] bt = new byte[1024]; //每次读取1024字节
				float num = 0f;
				while((num = input.read(bt))!= -1){
					//进度
//					System.out.println(num/fsLength);
					System.out.println(new DecimalFormat("#.##").format(num/fsLength));
				}

				input.close();

			}catch(IOException e){
				
				e.printStackTrace();
			}finally{
				try{
					
					if(input != null)input.close();
					
				}catch(IOException e){
					
					e.printStackTrace();
				}
			}
		}

}
