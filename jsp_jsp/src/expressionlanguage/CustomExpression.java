package expressionlanguage;

public class CustomExpression {
	
	//1.定义TzFunction.java
	//2.这个类中定义方法必须是静态方法
	//3.在web-inf/mata-inf定义xxx.tld文件(必须)
	//4.编写...tld文件
	//通过指令<%@ taglib uri="目录">
	//使用:${tz:方法名称(参数,参数,.....)}
	
	//<description></description> 描述
	//

	/*
	  
	  	标　　签					含　　义
		<taglib>  			TLD文件的根元素
	
		<tlib-version> 		此标签库的版本
		
		<jsp-version>  		此标签库依赖的JSP版本。
		<short-name>		当在JSP中使用标签时，此标签库首选或者建议的前缀。当然可以完全忽略这个建议
		<description>		描述信息
		<display-name> 		图形工具可显示的一个简短名称
		<icon>				图形工具可显示的图标
		<uri>				指定使用该标签库中标签的URI
		<validator>			关于该库的TagLibraryValidator信息
		<listener>			指定事件监听器类
		<function>			定义一个在EL中使用的函数
		<tag>				定义一个标签
	*/	
	
	/*
	 	<function>
	 		<description> 描述 </description>
	 		<name></name>
	 		<function-class></function-class>
	 		<function-signatrue>方法签名</function-signatrue>
	 		<example>举例</example>
	 	</function>
	 
	 
	 
	 	//自定义标签:
	 	 * 1.继承tagSupport或者BodyTagSupport
	 	   2.覆盖对应标签方法
	 	   3.注册:tld文件中注册
	 	   4.引入
	 	   
	 	   
	 	   doStartTag --> 标签开始
	 	   doAfterBody -->标签体
	 	   diEndTag   ---->标签结束
	 	   
	 	   <tag>
	 	   		
        		<name>date</name>
       			<tag-class>mytag.DateTag</tag-class>
         		<body-content>empty</body-content>
    		</tag>
	 	   
	 	   
	 */
}
