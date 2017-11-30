package page;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;



@Getter
public class PageList{
	
	
	//存储数据的集合
	private List dataList;
	
	//当前页
	private Integer currentPage = 1;
	//上一页
	private Integer previousPage;
	//下一页
	private Integer nextPage;
	
	//首页
	private Integer beginPage = 1;
	
	//每页的大小
	private Integer pageSize = 10;
	
	//最后一页/总页数
	private Integer endPage;
	
	//总数据大小
	private Integer totalData;
	
	
	//显示的开始索引
	private Integer beginIndex;
	
	private Integer endIndex;
	
	private List pageItems = Arrays.asList(5,10,15);
	
	public PageList(List dataList,
			Integer totalData,
			Integer currentPage,
			Integer pageSize){
		
		this.dataList = dataList;
		this.totalData = totalData;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		
		//计算总页数/末页
		this.endPage = this.totalData % this.pageSize == 0 ?
						this.totalData / this.pageSize : this.totalData / this.pageSize +1;
		
		//计算上页
		this.previousPage = this.currentPage > this.beginPage ? this.currentPage - 1 : 1;
		
		//计算下页
		this.nextPage = this.currentPage < this.endPage ? this.currentPage + 1 : this.endPage;
		
		
		QueryIndex index = QueryIndex.getQueryIndex(10, currentPage,endPage);
		
		this.beginIndex = index.getBeginIndex();
		this.endIndex = index.getEndIndex();
		
	}
	
	
}