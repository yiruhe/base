package upload;

public class Basic {

//	servlet3.0: 支持文件注解上传
	//@MultipartConfig
	
	/*
	 * 根据HTML5 规范中所叙述的，enctype具有以下三种选项，其中最后一项text/plain是相比4.01新增的。
	 * 
	 * 1.application/x-www-form-urlencoded 2.multipart/form-data 3.text/plain
	 * 
	 * 1.application/x-www-form-urlencoded(默认)
	 * 这是默认的编码类型，使用该类型时，会将表单数据中非字母数字的字符转换成转义字符，
	 * 如"%HH"，然后组合成这种形式key1=value1&key2=value2；所以后端在取数据后，要进行解码。
	 * 使用get方式提交时，把表单数据(name1=value1&name2=value2...)以键值对append到url后，用 '?'
	 * 分割url和参数。
	 * 
	 * 2.multipart/form-data：
	 * 
	 * 表单数据被编码为一条消息，页上的每个<input>对应消息中的一个部分，
	 * 用boundary=---------------------------
	 * 36243265420146"分割各个部分（boundary值由浏览器生成）。 它不会对字符进行编码，一般用于传输二进制文件（图片、视频、、、）
	 * 
	 * 该类型用于高效传输文件、非ASCII数据和二进制数据，将表单数据逐项地分成不同的部分，用指定的分割符分割每一部分。
	 * 每一部分都拥有Content-Disposition头部，指定了该表单项的键名和一些其他信息；
	 * 并且每一部分都有可选的Content-Type，不特殊指定就为text/plain。
	 */

	
	/*
	 * 		1. 	Content-disposition 是 MIME 协议的扩展，MIME 协议指示 MIME 用户代理如何显示附加的文件。
	 * 			Content-disposition其实可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名，
	 * 			文件直接在浏览器上显示或者在访问时弹出文件下载对话框。
	 * 
	 * 			格式说明： 
				content-disposition = "Content-Disposition" ":" disposition-type *( ";" disposition-parm ) 
	 * 
	 * 			字段说明： 
					Content-Disposition为属性名 
					disposition-type是以什么方式下载，如attachment为以附件方式下载 
					disposition-parm为默认保存时的文件名 	
					
					
					
				当然filename参数可以包含路径信息，但User-Agnet会忽略掉这些信息，只会把路径信息的最后一部分做为文件名。当你在响应类型为application/octet- stream情况下使用了这个头信息的话，那就意味着你不想直接显示内容，而是弹出一个"文件下载"的对话框，接下来就是由你来决定"打开"还是"保存" 了。
				
				注意事项：
				1.当代码里面使用Content-Disposition来确保浏览器弹出下载对话框的时候。 response.addHeader("Content-Disposition","attachment");一定要确保没有做过关于禁止浏览器缓存的操作。如下： 
  
				response.setHeader("Pragma", "No-cache");
				response.setHeader("Cache-Control", "No-cache");
				response.setDateHeader("Expires", 0); 
				不然会发现下载功能在opera和firefox里面好好的没问题，在IE下面就是不行。
					
	 * 
	 * 
	 */
}
