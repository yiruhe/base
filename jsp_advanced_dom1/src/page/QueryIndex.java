package page;

public class QueryIndex {

	private Integer beginIndex;
	private Integer endIndex;
	
	
	
	public static QueryIndex getQueryIndex(int countIndex,int currentPage,int totalPage){

		//计算指定显示数的中心
		int distance = countIndex / 2;
		
		
		//计算显示开始页    
		//单数时:
		//例: 显示 10  当前页5
		//第一页就是 5 -  4
		//而这里的中间值是5 ,所以减去1;就是开始页
		int startPage =currentPage -  (countIndex % 2 == 0 ? 
				
						distance - 1 : distance);
		
		//计算显示结束页
		int endPage = currentPage + distance;
		
		if(startPage < 1){
			
			startPage = 1;
			
			if(totalPage < countIndex){
				
				endPage = totalPage;
				
			}else{
				
				endPage = countIndex;
			}
		}
		
		if(endPage > totalPage){
			
			endPage = totalPage;
			
			if((endPage - countIndex) > 0){
				
				startPage = endPage - countIndex + 1;
				
			}else{
				
				startPage = 1;
			}
			
		}
		
		
		return new QueryIndex(startPage,endPage);
	}
	
	
	public QueryIndex(Integer beginIndex,Integer endIndex){
		
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
		
	}
	
	
	public Integer getBeginIndex(){
		
		return this.beginIndex;
	}
	
	public Integer getEndIndex(){
		
		return this.endIndex;
	}
	
}
