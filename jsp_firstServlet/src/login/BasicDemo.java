package login;

public class BasicDemo {
	
	//在Tomcat中,对于POST和GET请求,都默认才有ISO-8859-1的编码方式
	//该ISO-8859-1不支持中文,所以乱码
	
	//解决方案:
		//1.按照ISO-8859-1把乱码恢复成二进制形式
		//data = username.getBytes("ISO-8859-1");
		//再把二进制形式的数据使用UTF-8重新编码
		//String username = new String(data,"UTF-8");

		//针对于POST请求方式:
		//request.setCharacterEncoding("UTF-8");
		//注意:只针对POST有效,2:必须放在获取任意参数之前
	
		//针对于GET请求:
			//修改Tomcat中的server.xml配置文件修改端口的元素,对GET方式的默认编码有效,POST无效
			//URIEncoding="utf-8"

		//ServletResponse接口:响应对象,封装了获取响应信息的方法
		//HttpServletResponse接口:ServletResponse的子接口,可以处理Http响应的方法
		//HttpServletRequset接口:请求对象,封装了获取所有请求的信息方法
		//HttpServletRequest接口:是HttpServletRequset的子接口,处理HTTP协议请求的方法
	
	//outputStream,outputWrite  字节流,字符流
	//above:这两个流不能同时存在
	
	//输出数据时,使用println(),那么这时候浏览器不知道你的
	//数据类型是什么,所以ln会换行,而在html中<br /> 才是换行
	//所以在设置输出数据的时候指定MIME类型和编码
	
	
	//当客户端并没有使用ISO8859-1，而Servlet容器仍然使用ISO8859-1来解析数据时，就会出现筹码问题。
	//开发者可以调用setCharacterEncoding方法来告诉容器应该使用哪种字符集来解析数据，而且必须在从request中解析任何数据或读取任何输入之前调用，
	//否则对已经读取的数据的字符集无影响。
	
	//get的参数是放在Http的header中的,编码就是URL的编码
	//解码字符要么是Header中的ContentType定义的Charset,要么默认
	//要使用Content-Type中定义的编码,就要使用connector中设置编码
	//这里设置的编码仅仅对QueryString有效
	//tomcat在解码的时候会获取这里的参数
	
	//get的参数是放在BODY中的,编码格式会通过Content-Type(页面的)进行编码
	//Tomcat在解析Parameter参数集合之前会去获取,header的content-type
	//请求头,post请求默认情况下不会含有charset信息
}
