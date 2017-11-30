package domain;

import lombok.Data;



@Data
public class Student{
	
	private Integer Id;
	private String  name;
	private String department;
	private Integer score;
	private Engineer engineerDir;
	
}