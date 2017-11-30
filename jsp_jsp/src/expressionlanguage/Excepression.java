package expressionlanguage;

public class Excepression {
	/*
	 * out: 核心标签库中最为基本的标签就是<c:out>,他可以在页面中显示一个字符串或者一个EL表达式的值,
	 * 其功能与JSP中的<%= 表达式%>类似
	 *
	<c:out>中各属性的说明如下:

		1.value : 可以指定一个字符串作为输出内容,也可以指定为EL表达式,例如:${3+5}.

				//默认忽略(true)
		2.escapeXml : 类型为boolean , 确定 , < , > , & , ‘ , “ 等字符在结构的字符串中是否被转换成字符串实体代码,默认值是true(就是是否按html中的样式进行输出,设置true就是按照字符串原样进行输出,false就是按照html标识符进行输出)

		3.default value : 可以是字符串,也可以是一个EL表达式或者jsp表达式,如果属性(value)指定的表达式或者对象为null,那么将输出这个defalut value部分的值.
		
		
		 *******************************set******************************************
	set标签:

       set标签用来在某个范围(request,session或者application)内设置值,或者设置某个对象的属性值.

       Set标签使用格式如下:

       1. 使用value 属性在一个特定的范围内指定某个变量的值,其使用格式如下:
       	<c:set var=”varName” value=”varValue” [scope=”page|request|session|application”]/>

       2. 当使用value属性在一个特定范围内指定某各变量的值时,也可以包括一个体,他的作用与out标签体的作用一样,即value指定的值为null时,默认使用体中指定的值,使用的格式如下:
       	<c:set var=”varName” value=”varValue” [scope=”page|request|session|application”]>
              default value
       	</c:set>

	   3. 设置某一个特定对象属性的使用格式如下:
			<c:set property=”propertyName” target=”target” value=”value”/>

		4. 在设置某个特定对象的一个属性时,也可以使用一个体,并且指定默认的值,使用格式如下:
      		<c:set property=”propertyName” target=”target” value=”value”>

             default value

      </c:set>

      该标签中的各属性说明如下:

      1. value : 该属性指定变量或者对象中某个属性的值,并且可以是一个表达式.

      2. var : 变量名称,value属性指定的值就保存在这个变量中.

      3. scope : 设定变量的有效范围,如果不设置,默认为page.

      4. target : 设置属性的一个对象,它必须是JavaBean 或者java.util.Map对象.

      5. property : 设置对象中的一个属性.
      
      
      
      *******************************remove****************************************
      
      remove标签

       remove标签一般和set标签配套使用,两者是相对应的,remove标签用于删除某个变量或者属性,使用格式如下:

       <c:remove var=”varName” [scope=”page|request|session|application”] />

       Remove标签中使用的各属性说明如下:

		1.scope : 设定这个需要删除的变量的所在范围.

		2. var : 需要删除的变量或者对象属性的名称.

		如果没有scope属性,即采用默认值,就相当于调用PageContext.removeAttribute(varName)方法,如果指定了这个变量所在的范围,那么系统会调用PageContext.removeAttribute(varName,scope)方法.


		*******************************catch****************************************
		
		   catch标签

		catch标签的功能和java中的try{…}catch{…}语句的功能很相似,它用于捕获嵌入到其中间语句抛出的异常,这个标签的使用格式如下:

              <c:catch var=”varName”>

                     相关操作语句

		</c:catch>   --如果操作语句中出现异常,则catch会将异常保存在 varName变量中.(变量存于pageScope)

       	流程控制标签: 包括: if , choose , when , otherwise 等.
       	
       	*******************************if****************************************
       	     if标签

              这个标签作用与java中的if语句作用相同,用于判断条件语句,主要的使用格式如下

		1.       在<c:if> 体中不包括体的使用格式:

		<c:if test=”checkCondition” var=”varName” scope=”page|request|session|application”/>

       2.  当<c:if> 体中包括体时,使用格式如下:
			<c:if test=”checkCondition” var=”varName” scope=”page|request|session|application”>
       			body content
			</c:if>
		       标签中使用的属性说明:
		
		test : 判断条件的表达式,返回类型为true 或者 false;(也就是if的条件)
		
		var : 这个变量用于保存test条件表达式判断所返回的true或者false值
		(if条件执行后所得到的boolean值将要保存在var变量中).
		
		scope : 指定var变量所在的有效范围.
		
		*******************************forEach****************************************
		forEach迭代标签
		
		该标签用来对一个collection集合中的一系列对象进行迭代输出,并且可以指定迭代次数,一般的使用格式如下:
		
		<c:forEach items=”collection” var=”varName” [varstatue=”varStatusName”] [begin=”begin”] [end=”end”] [step=”step”]>
		
		       Body content
		
		</c:forEach>
		
		这个标签使用的属性描述如下:
		
		1.var : 做循环的对象变量名，若存在items属性，则表示循环集合中对象的变量名（可选）
		
		2.items : 将要迭代的集合类名.
		
		3.varStatus : 存储迭代的状态信息,可以访问到迭代自身的信息.
		
		4.begin : 如果指定了begin值,就表示从items[begin]开始迭代;如果没有指定begin值,则从集合的第一个值开始迭代.
		
		5.end : 表示迭代到集合的end位时结束,如果没有指定end值,则表示一直迭代到集合的最后一位.
		
		6.step :循环的步长，默认为1（可选）
		
		<c:forEach var=”ItemName” items=”${Items}” begin=”3” end=”4” step=”1” varStatus=”s”>

       &nbsp;<c:out value=”${ItemName}” />的四种属性:<br>

       &nbsp;所在位置即索引: <c:out value=”${s.index}” /> <br>

       &nbsp;总共已迭代的次数: <c:out value=”${s.count}”/><br>

       &nbsp;是否为第一个位置: <c:out value=”${s.first}” /><br>

       &nbsp;是否为最后一个位置: <c:out value=”${s.last}”/>

		</c:forEach>

		代码说明:      
		s.index 用来获取计数器的值,  
		s.count用来获取这是第几次循环,  
		s.first 用来获取是否是循环开始的第一次 ,
		 s.last 用来获取是否是循环的最后一次 , first 和last 都返回boolean值.

             
		*******************************forTokens****************************************
		
		forTokens 标签

		这个标签的作用和Java中的StringTokenizer类的作用非常相似,通过items属性来指定一个特定的字符串,然后通过delims属性指定一种分隔符(可以同时指定多个),通过指定的分隔符把items属性指定的字符串进行分组,与forEach标签一样,forTokens标签也可以指定begin和end以及step属性值.
		使用格式如下:
		
		<c:forTokens items=”stringOfTokens” delims=”delimiters” var=”varName” [varStatus=”varStatusName”] [begin=”begin”] [end=”end”] [step=”step”]>
		
		              Body content
		
		</c:forTokens>
		
		标签中的各个属性描述如下:
		
		1.       var : 进行迭代的参数名称.
		
		2.       items : 指定的进行标签化的字符串.
		
		3.       varSatus : 每次迭代的状态信息.
		
		4.       delims : 使用这个属性指定的分隔符来分隔items指定的字符串.
		
		5.       begin : 开始迭代的位置.
		
		6.       end : 迭代结束的位置.
		
		7.       step : 迭代的步长.
		
		例:
		
		<c:out value=”forTokens标签实例”/>
		
		<h4>使用” | ” 作为分隔符</h4>
		
		<c:forTokens var=”token” items=”bleu,rouge|vert,jaune|blanc,rouge” delims=”|”>
		
		       &nbsp;&nbsp;<c:out value=”${token}”/>
		
		</c:forTokens>
		
		<h4>使用” | , ”作为分隔符</h4>
		
		<c:forTokens var=”token” items=”bleu,rouge|vert,jaune|blanc,rouge” delims=”|,”>
		
		       &nbsp;&nbsp;<c:out value=”${token}”/>
		
		</c:forTokens>
		
		代码说明: delims=”|,” , 即使用”|”和”,”同时作为分隔符进行使用.如果需要更多的分隔符就是使用“|,./” 在引号内输出.


		**********************************c:import***********************************
		
		
		<c:import> 标签:

		      该标签用于把其他今天文件包含到该文件当中,它与传统的<jsp:include>相类似,不同的是<jsp:include>标签只能用来包括该应用中的其他文件,而<c:import>还可以包含外部站点中的静态文件,所以它的功能更加强大.使用格式如下:
		
		      <c:import url=”url” [context=”context”] [var=”varName”] [scope=”page|request|session|application”] [varReader=”varReader”] [charEncodion=”charEncoding”]>
		
		      Body content
		
		</c:import>
		
		标签中的属性描述如下:
		
		      url: 待引用静态文件的URL地址.
		
		      context: 当采用相对路径访问一个外部静态文件时,这里的context指定这个外部文件的名称.
		
		      var: 当使用字符串输出时,把输出的内容存储在这个var指定的变量中.
		
		      scope: 指定var参数变量的有效范围.
		
		      varReader: 这个属性指定的参数变量类型是Reader,可以用于读取文件的内容. 接受文本的java.io.Reader类变量名（可选）
		
		      charEncoding: 引入文件所采用的字符编码.
		
		Import标签即可以采用相对路径也可以采用绝对路径来引用本地点中的任何静态文件,还可以使用绝对路径引用外部站点中的静态文, 甚至可以是ftp站点中的文件,例如:<c:import var=”myurl” url=”http://www.163.com” />就是引用http://www.163.com 站点的主页面.
		
		可以把引用文件中的内容赋值给var属性指定的变量,然后进行读取,也可以赋值给varReader指定的Reader类型的变量,然后进行相应的读取.
		
		有时引入的文件在本地显示会出现乱码,这时可以通过charEncoding来指定这些内容所采用的字符集编码.
				
		
		<c:url> 标签用于得到一个 URL 地址。它的属性和描述如表 9.10 所示：
			表9.10 <c:url>标签属性和说明
			
			属性			|		描述
			---------------------------------
			value		|		页面的URL地址
			---------------------------------
			context		|上下文路径名字	Web Context该属性用于得到不同Context下的URL地址，当出现context属性时，必须以“/”开头，此时也需要url属性以“/”开头（可选）
			---------------------------------
			charEncoding|		URL的字符集（可选）
			----------------------------------
			var			|		存储URL的变量名（可选）
			-----------------------------------
			scope		|		变量名作用范围（可选）
			-----------------------------------
			下面看一个示例：
			<c:url value="/MyHtml.html" var="urlPage" />
			<a href="${urlPage}">link</a>
			得到了一个 URL 后，以 EL 表达式放入 <a> 标签的 href 属性，达到链接的目的。
			
			
			
			
			============================================================
			<c:redirect>和<c:param>标签:
		
		      Redirect标签用来进行页面之间的重定向,它与传统JSP程序重的<jsp:redirect>标签功能相类似,param标签是与redirect一起使用的,它用来进行参数值的传递,redirect标签的使用格式如下:
		      <c:redirect url=”url” [context=”context”]/>
		
		      在redirect标签中指定param参数的使用格式如下: 这里的context是指上下文路径
		
		      <c:redirect url=”url” []context=”context”>
		
		             <c:param name=”paramName” value=”value”/>
		
		      </c:redirect>
		
		例:  [通过创建c_redirect1.jsp  和 c_redirect2.jsp  两个文件说明]
		
		      c_redirect1.jsp文件内容如下:
		
		             <c:redirect url=”c_redirect2.jsp” >
		
		                    <c:param name=”userName” value=”admin”/>
		
		             </c:redirect>
		
		      c_redirect2.jsp 文件内容如下:
		
		             <body>
		
		                    userName=<c:out value=”${param.userName}”>
		
		             </body>
		
		      c_redirect1.jsp页面文件内容不会显示,因为直接重定向到c_redirect2.jsp,重定向c_redirect2.jsp后,页面中输出 userName=admin

*/
}
