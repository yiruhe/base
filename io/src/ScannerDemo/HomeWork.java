package ScannerDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;
public class HomeWork {
	
	
	public static void main(String[] args) {
		InputStreamReader in = null;
		BufferedReader bReader = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
			in = new InputStreamReader(System.in); 
			
			bReader = new BufferedReader(in);
			
			//定义一个输出文件日志
			File file = new File("f:/jery/homework/1.txt");
			File fparent = file.getParentFile();
			if(fparent != null && !fparent.exists()){
				
				fparent.mkdirs();
			}
			
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			String string = null;
			while(!"quit".equals(string = bReader.readLine())){
				
				bw.write(string);
				bw.newLine();
			}
			
		}catch(IOException e){
			
			e.printStackTrace();
			
		}finally{
			try{
				
				if(bw != null)bw.close();
				if(fw != null)fw.close();
				if(bReader != null)bReader.close();
				if(in != null)in.close();
				
			}catch(IOException e){
				
				e.printStackTrace();
			}
			
		}
		
		
	}

}
