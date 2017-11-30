package ScannerDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ScannerDemo {
	
	public static void main(String[] args) throws IOException {
		//inputStreamReader   //字节流通向字符流
		//System.in 
		
		InputStreamReader in = new InputStreamReader(System.in);
		
		BufferedReader bReader = new BufferedReader(in);
		
		System.out.println("输入名字");
		
		String name = bReader.readLine();
		
		System.out.println("输入年龄");
		
		int age = Integer.parseInt(bReader.readLine());
		
		System.out.println("名字"+name+" 年龄"+age);
		
		bReader.close();
		
		in.close();
	}

}
