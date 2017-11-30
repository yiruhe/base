package upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class UploadServlet extends HttpServlet {

	// 1.上传控件所在的<form>表单的method,必须为post
	// 因为get方式传参大小有限(2kb) post没有限制

	// 2.IE6
	// IE6问题,通过FileItem.getName方法获取上传文件名字会带有路径

	// 3.缓存大小和临时目录:
	// 超过了多少就不存放在内存中了(默认10kb)
	// 放在tomcat/temp文件夹

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// enctype="application/x-www-form-urlencoded" 默认
		// 当默认提交的时候,只是获取文件名字

		// enctype="multipart....."时,getparameter 无法获取
		// String name = request.getParameter("user");
		// String pass = request.getParameter("password");
		// String file = request.getParameter("file");

		// System.out.println(name+"===="+pass+"==="+file);

		// check request

		if (!ServletFileUpload.isMultipartContent(request)) {

			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 超过这个指定的大小,就写入临时文件
		factory.setSizeThreshold(20 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {

			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {

				FileItem item = iter.next();

				if (item.isFormField()) {

					//表单名
					String name = item.getName(); 
					// 为value设置编码
					String value = item.getString("utf-8");

					System.out.println(value);

				} else {

					// 获取文件名
					String name = item.getName(); 

					System.out.println(name);

					// 解决ie6问题
					String baseName = UUID.randomUUID().toString();
					String extension = FilenameUtils.getExtension(name);

					System.out.println(extension);

					// 方式1:
					// String mime = "PNG;JPG;BMP";

					// if(!Arrays.asList(mime.split(";")).contains(extension)){

					// request.setAttribute("message","请传入图片");

					// 跳转至上传页面
					// request.getRequestDispatcher("/upload.jsp").forward(request,response);
					// }

					// 方式2:
					String mime = super.getServletContext().getMimeType(name);

					if (!mime.substring(0, mime.indexOf("/")).equals("image")) {

						request.setAttribute("message", "不是图片");

						request.getRequestDispatcher("/upload.jsp").forward(
								request, response);
						;

						System.out.println("不是图片");

						return;
					}

					String path = super.getServletContext().getRealPath(
							"/images");

					item.write(new File(path, baseName + "." + extension));

					// 判断文件数据是否在内存中
					System.out.println(item.isInMemory());
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}