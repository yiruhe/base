package page;

public class PageIndex {
	
	private Integer beginIndex;
	private Integer endIndex;
	
	/**
	 * 
	 * @param totalIndexCount 显示的索引数量
	 * @param currentPage   当前的页
	 * @param totalPage		总的页数
	 * @return
	 */
	
	public static PageIndex getPageIndex(
			Integer totalIndexCount,  //指定显示的index的数量
			Integer currentPage,  
			Integer totalPage){
		
		System.out.println(totalPage);
		
		//计算显示的开始页
		//分别计算奇数和偶数情况
		Integer startPageIndex = currentPage -
				(totalIndexCount % 2 == 0 ? totalIndexCount / 2 - 1:totalIndexCount / 2);
		
		
		//计算显示的结束页
		Integer endPageIndex = currentPage + totalIndexCount/2;
	
		//假如currentPage的页数为1
		if(startPageIndex < 1){
			//把为负数的起始页改为1
			startPageIndex =1;
			
			//在继续判断显示当前index结束的够不够,
			if(totalPage >= totalIndexCount){
				
				//如果总的页数大于可以显示指定的显示的数目
				endPageIndex = totalIndexCount;
				
			}else{
				
				//否则(指定显示的数目大于数据库中数据能显示的页数):
				
				//就只显示可显示的页数
				endPageIndex = totalPage;
				
			}
		}
		
		System.out.println(endPageIndex+"_______________");
		System.out.println(totalPage+"_______________");
//		假如到达了最后一页:最后的页数会大于 总的页数
		if(endPageIndex > totalPage){
			
			//把最后的值改为可显示的值
			System.out.println("==============");
			endPageIndex = totalPage;
			
			
			//根据当前最后一页的值,计算出当前指定显示index范围的beginIndex
			
			//判断总数是否可以完整显示出当前的beginindex,假如总数大于可显示数
			if((endPageIndex - totalIndexCount) > 0){
				
				//最后的数减去可显示的数,然后加1
				startPageIndex = endPageIndex - totalIndexCount + 1;
			
			}else{
				//否则就显示1;总数小于可显示数
				startPageIndex = 1;
			}
			
			
		}
		
	
		return new PageIndex(startPageIndex, endPageIndex);
		
		
	}

	
	public PageIndex(Integer beginIndex, Integer endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}
	
	public Integer getBeginIndex() {
		return beginIndex;
	}
	
	public Integer getEndIndex() {
		return endIndex;
	}
	
}
