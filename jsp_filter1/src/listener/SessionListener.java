package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		//客户端只会创建一次
		
		System.out.println("创建了客户端");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		/**
		 * 
		 * 默认:只有等待这个对象超时的时候才会被回收,调用这个方法,关闭客户端是没有用的
		 * 
		 * 或者调sessioninvalidate方法
		 */
		
		System.out.println("session销毁了");
		
	}
	
	
}