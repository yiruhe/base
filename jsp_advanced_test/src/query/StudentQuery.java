package query;

import lombok.Data;


@Data
public class StudentQuery extends GenericQuery{
	
	private String name;
	private Integer minScore;
	private Integer maxScore;
	private Integer engineerId;
	private String keyWord;
	
	//设置sql的参数
	public void addConditions(){
		

		if(name != null && !"".equals(name)){
			
			super.addQuery("name LIKE ?","%"+name+"%");
		}
		
		if(minScore != null){
			super.addQuery("score >= ?",minScore);
		
		}
		
		if(maxScore != null){
			
			super.addQuery("score <= ?",maxScore);
			
		}
		if(engineerId != null){
			
			super.addQuery("part_id = ?",engineerId);
			
		}
		if(keyWord != null && !"".equals(keyWord)){
		
			super.addQuery("(name LIKE ? OR department LIKE ?)","%"+keyWord+"%","%"+keyWord+"%");
		}
		
		//排序：
		
		//super.addOrderBy("part_id",OrderBy.ASC);
		//super.addOrderBy("score",OrderBy.DESC);
		
	}
	
	
}