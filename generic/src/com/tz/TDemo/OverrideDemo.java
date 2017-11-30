package com.tz.TDemo;

public class OverrideDemo {
	
	
	
			int age;
	
			public OverrideDemo(int age){
		
				this.age = age;
			}




	public static void main(String[] args){
		OverrideDemo p1 = new OverrideDemo(18);
		OverrideDemo p2 = new OverrideDemo(18);
		
		System.out.println(p1.equals(p2));
	}



	
	
	
	@Override
	public boolean equals(Object obj){
		if(obj != null){
			if(this == obj){
				
				return true;
			}
			if(obj instanceof OverrideDemo){
				
				OverrideDemo o = (OverrideDemo)obj;
				
				if(o.age == this.age){
					
					return true;
					
				}
			}
		}
		
		return false;
		
		
	}

}


	

