package ScannerDemo;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;
public class PropertiesDemo {

	
	
	public static void main(String[] args) throws IOException{
		
		//创一个配置文件
		
		Properties pro = new Properties();
		//拿到这样一个文件
		pro.load(new FileInputStream("f:/1.properties"));
		
		System.out.println(pro.getProperty("username"));
		
		System.out.println(pro.getProperty("user"));
		
		System.out.println(pro.containsKey("username"));
		
		System.out.println(pro.containsValue("18"));
		
	}
}
