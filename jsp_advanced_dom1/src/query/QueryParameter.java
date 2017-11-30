package query;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class QueryParameter extends GenericQuery{
	private String name;
	private Integer minScore;
	private Integer maxScore;
	private Integer departmentId;
	private String keyword;
	
	@Override
	public void customizedParameter(){
		if (name != null && !"".equals(name)) {

			super.setParameter(" name LIKE ?", "%"+name+"%");
		}

		if (minScore != null) {

			super.setParameter("score >=?",minScore);
				
		}

		if (maxScore != null) {

			super.setParameter("score <= ?", maxScore);
			
		}
		
		if(departmentId != null){
			
			super.setParameter("part_id = ?",departmentId);
			
		}
		
		if(keyword != null && !"".equals(keyword)){
			
			super.setParameter("(name LIKE ? or department LIKE ?)","%"+keyword+"%","%"+keyword+"%");
		}
		
		//super.setOrderBy("part_id",OrderBy.ASC);
		//super.setOrderBy("score",OrderBy.ASC);
	}

}
