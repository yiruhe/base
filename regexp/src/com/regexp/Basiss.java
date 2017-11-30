package com.regexp;


import org.junit.Test;

public class Basiss {


    @Test
    public void testMatch(){

        String str = "a";

        String reg = "a";
//        (.)\1  // \1 即为反向分组，代表前一个分组相同的匹配结果字符
        //重复左边的括号中匹配的值
        //多组:从左往右数开括号 捕获组的编号也是按照“(”出现的顺序，从左到右，从1开始进行编号的 。
        //   正则表达式中，对前面捕获组捕获的内容进行引用，称为反向引用
        //java.util.regexp
        //捕获组:会保存在内存中
        //(?:expression):非捕获组  不保存在内存中
        
        //断言是匹配位置的
        //(?=\d+) 后面是数字   //\d+ 是不计入结果内容的
        //(?!\d+) 后面不是数字
        
        
//        java.uitl.regexp 包
        
        System.out.println(str.matches(reg));

       
        
    }

}
