package expression.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDemo {
	
	private String name= "Katy";
	private Integer age=10;
	private String[] hobby = {"c","html","css"};
	private List<String> list = Arrays.asList("java","c","C++");
	private Map<String,String> map = new HashMap<String,String>(){
		
		{
		
			this.put("score","80");
			this.put("department","math");
			this.put("www.baidu.com","baidu");
			
		}
		
	};

}
