package upload;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response){
		
		
		String parameter = request.getParameter("name");
		
		try{
			
			String fileName = new String(parameter.getBytes("ISO8859-1"),"utf-8");
			
		
			
			String filePath = request.getServletContext().getRealPath("/download/"+fileName);
			
			
			System.out.println(fileName);
			//IE
			//fileName = URLEncoder.encode(fileName,"UTF-8");
			
			//非IE   //header中只支持ASCII,不支持utf-8,而ISO-8859-1向下兼容
			fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
			//告诉浏览器这是一个下载到本地的文件
			response.setContentType("application/x-msdownload");
			//设置disposition 浏览器打开方式
			response.setHeader("Content-Disposition","attachment; filename="+fileName);
			
			
			InputStream input = new FileInputStream(filePath);
			ServletOutputStream out = response.getOutputStream();
			
			byte[] byteArray = new byte[1024];
			int len;
			
			while(input.read(byteArray) != -1){
				
				out.write(byteArray);
				
			};
			
			input.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
}
