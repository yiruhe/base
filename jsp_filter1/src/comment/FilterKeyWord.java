package comment;

public class FilterKeyWord {
	
 	private  static String[] keyWord = new String[]{"草","不要脸"};
 	
 	
 	
 	public static String dispose(String comment){
 		
 		//比对字符串中是否含有关键字
 		for(String key:keyWord){
 			
 			if(comment.indexOf(key) != -1){
 				
 				 comment = comment.replace(key,"*");
 			}
 			
 		}
 		
 		
 		return comment;
 		
 	}
	
	
	

}
