package extend;

public class Student extends Person{

	private int stuId;
	public void study(){
		System.out.print("我是学生");
	}
	public void say(){
		System.out.println(this.username+"=="+this.age+"=="+this.sex);
	}
}
