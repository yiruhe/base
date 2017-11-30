package extend;
/*
 * 如果子类的方法和父类的方法相同，子类会覆盖子类
 * 
 * */
public class Super extends SuperParent {
	//父类的构造方法需要两个方法初始化，此时没有获取，父级的初始化失败
	//会导致子类的失败
	public Super(){
		System.out.println("I am son");
	}
	public Super(float x,float y){
		//默认就会调用 super(); 没传参的
		//super 就是父类的引用，也就是指向父类
		System.out.println("I am son");
		
	}
	
	public static void main(String[] args){
		Super me = new Super();
		
	}
}
