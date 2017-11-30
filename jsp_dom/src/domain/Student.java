package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
public class Student{
	
	private Long id;
	private String name;
	private String department;
	private Integer	score;
	
	private DepartmentName departmentDirectory;
	
}