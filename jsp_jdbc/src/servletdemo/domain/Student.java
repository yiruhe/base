package servletdemo.domain;

public class Student {
	
	 	private Long id;
	    private String name;
	    private String department;
	    private Integer score;


	    

	    public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getDepartment() {
			return department;
		}




		public void setDepartment(String department) {
			this.department = department;
		}




		public Integer getScore() {
			return score;
		}




		public void setScore(Integer score) {
			this.score = score;
		}




	@Override
	public String toString(){
		
		
		return "student[id="+id+",name="+name+",department="+department
				+",score="+score
				+ "]";
		
	}

	
	
	

}
