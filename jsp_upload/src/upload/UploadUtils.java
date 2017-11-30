package upload;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;




import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class UploadUtils {

	public static void upload(HttpServletRequest request,Map<String,String> userInfo,
			Map<String,String> imageInfo) {

		if (!ServletFileUpload.isMultipartContent(request)) {

			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 超过这个指定的大小,就写入临时文件
		factory.setSizeThreshold(20 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置单个文件上大小
		upload.setFileSizeMax(10 * 1024);

		// 多个文件大小
		upload.setSizeMax(30 * 1024);

		try {

			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();

			while (iter.hasNext()) {

				FileItem item = iter.next();
				
				
				String filedName = item.getFieldName();
			

				if (item.isFormField()) {

					String value = item.getString("utf-8");
					//用户数据
					userInfo.put(filedName,value);

				} else {

					// 获取文件名
					String name = item.getName();
					//图片数据

					// 解决ie6问题
					String extension = FilenameUtils.getExtension(name);
					String baseName = UUID.randomUUID() + "." + extension;

					System.out.println(extension);
					String mime = request.getServletContext().getMimeType(name);
					System.out.println(mime.substring(0, mime.indexOf("/")));

					if (!mime.substring(0, mime.indexOf("/")).equals("image")) {

						throw new LogicException("请上传图片");

					}

					String path = request.getServletContext().getRealPath(
							"/images");
					
					//文件名字
					imageInfo.put(filedName,baseName);
					//文件路径
					imageInfo.put(filedName+"Path","/images"+baseName);

					item.write(new File(path, baseName));

				}

			}

		}catch (LogicException e) {

			// 重新抛出异常
			throw e;

		}catch (FileSizeLimitExceededException e) {

			throw new LogicException("上传文件太大!", e);

		} catch (SizeLimitExceededException e) {

			throw new LogicException("文件总大小,过大", e);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
