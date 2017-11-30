package com.tz.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReaderDemo {
	
	public static void main(String[] args) {
		
		try{
			File file = new File("f:/1.txt");
			File file2 = new File("f:/2.txt");
			
			
			FileReader fileReader = new FileReader(file);
			//数据缓冲  高效读取
			BufferedReader bReader = new BufferedReader(fileReader);
			
			String string = null;
//			while((string = bReader.readLine()) != null){
//				System.out.println(string);
//			}
			
			
//			if(file2.exists())file2.createNewFile();
			//追加 true
			FileWriter fileWriter  = new FileWriter(file2,true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			while((string = bReader.readLine()) != null){
				System.out.println(string);
				writer.write(string);
				writer.newLine();
			}
			writer.flush();
			writer.close();
			fileWriter.close();
			bReader.close();
			fileReader.close();
		}catch(IOException e){
			
			e.printStackTrace();
		}
	}

}
