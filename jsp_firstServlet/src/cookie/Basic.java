package cookie;

public class Basic {
	//Http协议是无状态连接,服务端不知道上一次是哪一个客户端请求了自己.
		//无状态连接带来的问题:
			//在一次会话总,我们可以查看对个资源,每个资源都会先发送请求,
			//再响应,每次请求都是客户端发出的
		//也就是说,在一次会话中，多个请求无法共享数据,无法跟踪用户的会话信息
	
	//解决方案:
//		1.使用参数的传递机制,在每一个请求之间使用参数来传递需要共享的数据
		//http://localhost/param/list?username=lucy
//	可以解决问题,但是请求需要共享的数据全部要暴露在浏览器的地址栏中.,不安全.
	//为什么会显示在浏览器地址栏中显示？
		//因为请求的请求行的数据,

	
	//创建Cookie对象:
	//cookie中属性名和属性值都不能使用中文
		//Cookie cookie = new Cookie(String name,String value);
		//唯一的名字
//	cookie是客户端技术,把数据存储在客户端
	//每次请求都会带上对应域名的cookie
	//客户端响应时会带上Set-Cookie
	
	//把Cookie放入响应中,响应给browser,把共享的数据存储在Browser当中
		//response.addCookie(cookie);
	
	//修改Cookie
	// 1.创建一个同名的Cookie去覆盖
	// 2.获取该Cookie对象,通过SetValue方法
	
	
	//Cookie的分类
	//会话Cookie：关闭浏览器就消失    缺省情况
	//持久化Cookie：有一定期限,关闭浏览器不会消失
	
//	设置cookie存活时间
		//seconds == 0 删除cookie
		//seconds < 0 会话cookie
		//seconds > 0 存活指定seconds
	
	
	//cookie的domain(域):
	
		//Cookie 的path是在同一主机中指定共享Cookie,如果主机不同name一定不能共享Cookie
		//Cookie在创建的时候,会根据当前的Servlet的相对路径来设置自己的路径,所以就修改Cookie的保存路径
		//Servlet("/cookie/login") ： servlet2("/test/demo")
		//此时Servlet中的Cookie是不会请求发送getServlet2，因为路径不同
	
		//此时,Servlet,只会把Cookie传给/cookie开头的资源
	
		//如果要共享cookie那么:
			//二级域名配置虚拟(virtual)主机就好了
	
		//1.设置Cookie的path为“/”例如  cookie.setPath("/");在整个baidu.com就可以传递了
		//2.设置Cookie的domain,例如:cookie.setDomain(".baidu.com")其中没有指定域名前缀,这样所有二级域名都可使用
			//比如:在music.baidu.com主机中某个项目保存了cookie
			//在map.baidu.com主机就可以取出
		//需要配置两个虚拟主机,二级域名配置虚拟主机即可
	
	


/*	2.2   Cookie两个重要属性
	　　			Cookie有两个很重要的属性:Domain和Path，用来指示此Cookie的作用域：
	　　			Domain告诉浏览器当前要添加的Cookie的域名归属，如果没有明确指明则默认为当前域名，
			  		
			  		1.比如通过访问www.vinceruan.info添加的Cookie的域名默认就是www.vinceruan.info,
			  		通过访问blog.vinceruan.info所生成的Cookie的域名就是blog.vinceruan.info。
		　　			
					2.Path告诉浏览器当前要添加的Cookie的路径归属，如果没有明确指明则默认为当前路径，
					比如通过访问www.vinceruan.info/java/hotspot.html添加的Cookie的默认路径就是/java/,
					通过blog.vinceruan.info/java/hotspot.html生成的Cookie的路径也是/java/
	
				注: 
					1.设置domain的时候，.yangbai.com和yangbai.com是一样的。
					2.cookie的作用域是domain本身以及domain下的所有子域名。
					3.设置cookie的话只能在本域名下或者domain级别高于自身的域名下才会生效！
	*
	*/


}
