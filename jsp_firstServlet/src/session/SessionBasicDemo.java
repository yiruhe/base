package session;

public class SessionBasicDemo {
	
	//如果服务器之间需要共享Session,此时Session中的对象,必须实现java.io.serializable
	//若要把多个数据存在Session中,我们就可以封装成对象
	
	
	//删除Session(用户注销登录)
	//删除
	//session对象.removeAttrbute();
	//销毁
	//session对象.invalidate();
	
	//<session-config>
	//<session-timeout>1</session-timeout>
	//</session-config>
	
	//超时管理:
	//many seconds 后自动销毁Session
	//session对象.setMaxInactiveInterval( seconds ); //时间后销毁
	//Tomcat服务器默认超时时间为:30分钟
	
	//URL重写:
		//cookie禁用后,session也会无效,因为session依赖于cookie
	//  /session/js;jssionid=xxxxxxxxx;    //在地址栏加上sessionid同样可以找到session对象
	// String =	response.encode("/session/js");  自动的在资源后拼接
	

	

}
