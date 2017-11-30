package mode;
//如果要使用某个包中的类，就要使用import;
//导入包面的具体类里面所有静态成员变量  --> 静态导入
//静态导入   就是吧一个类中的静态成员，通过静态导入的 方式，可以当做自己的成员一样使用

//先执行 父类的静态代码块  再是子类静态  然后再是父类普通  子类普通  再是构造    父类优先

public class Mode {
	/*
	 *不能写方法
	 * 	{ //代码块
		
		}
		static{ //静态代码块
			//无法访问非静态
		}
	*/
	private int b;
	private static int a;
	public Mode(){
		
		System.out.println(3);
		
	}
	{
		a = 222;
		 b = 2;
		 System.out.print(2);
	}
	static{//静态是跟类绑定的所以先执行
		a = 20;
		System.out.print(1);
	}
	
	public static void main(String[] args){
		Mode pMode = new Mode();
		//System.out.print(pMode.b+"...");
	}
	
}
