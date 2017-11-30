package demo;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport{
	
	//在标签处理类中应该将这个属性,作为成员变量,并且提供getter,setter,可以获取属性的值,设置属性的值
	
	//要么处理doStart,或doEnd 或两个一起
	
	@Override
	public int doStartTag() throws JspException{
		
		//getOut返回一个JSPwriter
		try {
			//向页面输出字符串
			super.pageContext.getOut().println("hello word");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		System.out.println("end..............");
		
		//处理后面的代码
		return EVAL_PAGE;
	}
	
}