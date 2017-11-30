package forward;

public class forward {
	
	//web主键之间的跳转:
		//请求转发:(forward)
		//URL重定向(redirect):
	
	//语法:
//		request.getRequestDispathcher(String path).forward(request);
	// 参数:path,表示跳转的路径(资源名称)

	//请求转发:
		//转发路径:没有 /,表示当前的相对路径,在当前路径寻找资源
		//前面加/就是根路径寻找
	
	
	//请求转发特点:
		//1.浏览器地址栏不发生改变
		//2.请求转发只发送一个请求
		//3.共享同一个请求数据
		//4.最终响应给浏览器的由Servlet2来决定(没有必要在第一个请求里写响应,无效)
		//5.请求转发不能跨域访问,只能跳转到当前应用中的资源
		//6.请求转发可以访问WEB-INF目录中的资源
	
	//重定向:
		//1.浏览器地址发生改变
		//2.URL重定向
		//3.因为URL重定向是两个独立的请求
		//4.最终应该浏览器的由Servlet2来决定
		//5.URL重定向能跨域
		//6.URL重定向不能访问WEB-INF目录中的资源
	
	//请求包含(include):
//		在一个页面可以包含其他页面的内容
//		在Servlet中没有意义,在jsp有意义
//		request.getRequestDispatcher().include()
	
}
