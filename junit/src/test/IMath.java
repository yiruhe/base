package test;

/**
 * Created by Administrator on 2017/3/10.
 *
 *
 * @author  Ben
 */
public interface IMath {
//    @author、@version 说明类 这两个标记分别用于指明类的作者和版本

    //@param、@return 和 @exception 的使用
    //这三个标记都是只用于方法的。@param 描述方法的参数，@return 描述方法的返回值，@exception 描述方法可能抛出的异常

    /**
     * @param a 加数
     * @param  b 被加数
     * @return int
     */
    int plus(int a, int b);

    /**
     * @
     * @return
     */
    int minus();
}
