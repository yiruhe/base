package comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MessageWrapper extends HttpServletRequestWrapper{

	
	//父类没有定义无参构造,若要初始化父类必须向父类传递参数
	public MessageWrapper(HttpServletRequest request) {
		super(request);
		
	}

	//覆盖父类的属性
	@Override
	public String getParameter(String name){
		
		//获取参数对应的值,
		String content = super.getParameter(name);
		
		//对值做处理
		return FilterKeyWord.dispose(content);
	}
}
