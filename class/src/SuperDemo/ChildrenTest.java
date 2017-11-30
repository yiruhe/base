package SuperDemo;

public class ChildrenTest extends ParentTest {
	@Override
	protected void run(){
		System.out.println("childrenTest Run");
		
	}
	
	public static void main(String[] args){
		//子类覆盖父类的方法
//		ChildrenTest oneTest = new ChildrenTest();
//		oneTest.run();
		ParentTest twoTest = new ChildrenTest();
		twoTest.run();
		/*
		 * 多态的实例只能调用被子类覆盖的方法和父类公开或受保护或同包下缺省的变量和方法
		 * 静态不能被覆盖
		 * 
		 * 静态多态 就是 方法的重载
		 * 
		 * 
*/		
		
	}

}
