package ScannerDemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class HomeWork2Demo {
	
	public static void main(String[] args) {
	
		
		try{
			while(true){
				System.out.println("请输入用户名密码");
				
				InputStreamReader in = new InputStreamReader(System.in);
				//缓冲的读取流
				BufferedReader bReader = new BufferedReader(in);
				String username = bReader.readLine();
				String password = bReader.readLine();
				
				//获取配置文件对象
				Properties pr = new Properties();
//				FileInputStream inStream = new FileInputStream("F:/jery/homework/user.properties"); 
//				String url = HomeWork2Demo.class.getResource("/").getPath();
				InputStream urlString = HomeWork2Demo.class.getResourceAsStream("/user.properties");
				pr.load(new InputStreamReader(urlString,"utf-8"));
				
				//判断密码用户名
				if(!pr.containsKey(username)){
					
					System.out.println("用户不存在");
					
				}else if(!pr.getProperty(username).equals(password)){
					
					System.out.println("密码错误");
					
				}else{
					
					System.out.println("登录成功");
					break;
				}
				
			}
		}catch(IOException e){
		
			e.printStackTrace();
			
		}finally{
			
			
			
		}
	}

}
