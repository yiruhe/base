package com.tz.inside;

/**
 *
 * Created by Administrator on 2017/1/28 0028.
 */
public class InsideClassTest {


    private String age = "18";

	//内部类可以访问外部类的方法
	//内部类不能直接访问内部类的成员,但是可以通过实例去访问




	// 通过 "类名.this.属性名字" 拿到外部类的属性
	// 在jdk1.7和之前，都是要加上final 的
	// 如果一个局部内类部想要访问外部方法中的变量，成员，必须加上final
	// 把内部类看成成员就可以了
	// 外部类只有public 缺省 两种
	// 实例内部类不能有static

	// 局部内部类
	// 不能使用访问修饰符(public,private,protected,static)
	// 访问的局部变量 必须是final, jdk1.8 是自动上的

	// 加上final的原因： 目的保持引用
	// 当方法完毕时，栈帧销毁，但是堆里面的对象还存在，对象还引用着方法的属性，为了避免使用final；
	//使用final修饰就会存在于方法区


	// 匿名内部类
	// 只能实现一个
	// 在这里我们看到使用匿名内部类我们必须要继承一个父类或者实现一个接口，当然也仅能只继承一个父类或者实现一个接口
	// 匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效。
	//匿名内部类，没有构造方法，构造方法要和类名一样，匿名内部类没有名字，所以没有构造函数，但是会调用父类构造
	//匿名内部类是一种特殊的局部内部类;
	//直接使用new来生成一个对象的引用



	//  局部变量：

//          ①局部变量只定义在局部范围内，如：函数内，语句内等，只在所属的区域有效。
//
//			②局部变量存在于栈内存中，作用的范围结束，变量空间会自动释放。
//
//			③局部变量没有默认初始化值

//	因为局部变量 本身就是 一个访问权限 的设定。 只能在局部调用，也就是说局部变量的生命周期在{}之中除了这个方法外界是没办法访问你这个变量，所以不需要用任何修饰符修饰，比如private ,public protend,等但是能加final,也不能加static,静态的关键词
//	因为static只能修饰成员变量和成员方法，在局部变量中用static修饰，又不能直接被类调用，而static关键字就是不直接过对象而用类就可以直接调用的，所以局部变量前不能加static关键字

	//非static的内部类，在外部类加载的时候，并不会加载它，所以它里面不能有静态变量或者静态方法。
//1、static类型的属性和方法，在类加载的时候就会存在于内存中。
	//		2、要使用某个类的static属性或者方法，那么这个类必须要加载到jvm中。

	public static void main(String[] args) {

		A a = new A();
		a.aSay();

		//先创建内部类对象,才可以创建内部类
		//  Outter.Innter obj = new Outter().new Inner();


        //java8:自动添加final;
        String name = "nick";

        class A{


            void say () {


                //局部方法外的变量不用
                System.out.println(new InsideClassTest().age);
                //局部内部类的访问会使局部变量用final修饰
                System.out.println(name);

            }


        }

        new A().say();


	}

}

class A {

	private String name = "I Am A";

	class B {

		private String bname = "I am B";

		public void say(final String username) {

			System.out.println(bname);

		}

	}

	public void aSay() {

		// 通过外部类直接访问了内部类的私有属性
		//这和Java的实现方式有关
		System.out.println(new B().bname);
		new B().say("nike");

	}

}