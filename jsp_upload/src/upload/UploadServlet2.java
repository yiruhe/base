package upload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet2 extends HttpServlet {

	// 1.单个文件
	// 2.总文件大小

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 传入request
		try {

			//表达文本信息
			Map<String,String> user = new HashMap<>();
			
			//图片信息
			Map<String,String> image = new HashMap<>();
			
			UploadUtils.upload(request,user,image);
			
			System.out.println(user);
			
			System.out.println(image);

			// 捕获logicException
		} catch (LogicException e) {
			// 获取信息
			 String information = e.getMessage();

			 request.setAttribute("message",information);

			request.getRequestDispatcher("/upload.jsp").forward(request,response);

		}

	}

}
