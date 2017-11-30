package page;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;


@Getter
public class PageList{

	//表的数据
	private List data;
	//总页数
	private Integer totalPage;
	//每页的数据条数
	private Integer pageSize = 10;
	
	//开始页  //开始页是固定的不用更改
	private Integer beginPage = 1;
	
	//当前页
	private Integer currentPage = 1;
	
	
	//下一页
	private Integer nextPage;
	//上一页
	private Integer previousPage;
	//最后一页 //总的页数
	private Integer endPage;
	
	private Integer beginIndex;
	private Integer endIndex;
	
	//每页显示多少的items
	private List<Integer>  pageListItems = Arrays.asList(5,10,20);
	
	public PageList(List data,
			
			Integer totalPage,
			
			Integer currentPage,
			
			Integer pageSize){
		
			this.data = data;
			this.totalPage = totalPage;
			this.currentPage = currentPage;
			this.pageSize = pageSize;
		
			//计算最后一页
			if(totalPage % pageSize == 0){
				
				endPage = totalPage / pageSize;
			}else{
				
				endPage = totalPage / pageSize + 1;
				
			}
			//上一页
			if(currentPage > 1){
				
				this.previousPage =  currentPage - 1;
				
			}else{
				
				this.previousPage = 1;
				
			}
		
			//下一页  
			if(currentPage < endPage){
				
				this.nextPage = currentPage + 1;
				
			}else{
				
				this.currentPage = endPage;
			}
			
			//设置分页显示的页数
			PageIndex contentIndex = PageIndex.getPageIndex(10, currentPage,endPage);
			
			this.beginIndex = contentIndex.getBeginIndex();
			this.endIndex = contentIndex.getEndIndex();
		
	}
	
}