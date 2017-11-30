package com.tz.xml;

import java.util.HashSet;
import java.util.TreeSet;


public class Basis {

    //只能有一个根标签
    //standalone="yes" 不需要依赖  默认no
	//为no 只能写xml不能写约束

    //<![CDATA[数据内容]]>  解析器不会对CDATA中的内容进行解析,原封不动的



    //约束类型
    // dtd ".dtd"
    // schema ".xsd"  //代替dtd


	//schema约束比dtd约束更强大
//    <xs:命名空间 根节点>
//		所有的schema约束使用schema作为根元素
//        xmlns(xml name space): 约束当前的xml的命名空间(必有)  命名空间就是规范
//    targetNamespace:自定义的规范
//    不使用targetNamespace 就不可以使用xsi:noNamespaceSchemaLocation引用命名空间
//    xml设置XSD验证的方式不一样
//    带命名空间的xml用 schemaLocation="命名空间 xsd文件" 设置不带命名空间的使用noNamespaceSchemaLocation="xsd"文件设置。

    //如果设置为qualified：
//    在XML文档中使用局部元素时，必须使用限定短名作为前缀

//    如果设置为unqualified：
//    在XML文档中使用局部元素时，可以省略限定短名



//      xsi是XML Schema Instances的意思
    //每一个Schema可以有且只有一个默认命名空间
//      xsi:schemaLocation="命名空间 约束文件位置"
    // 名称空间是W3C推荐标准提供的一种统一命名XML文档中的元素和属性的机制。使用名称空间可以明确标识和组合XML文档中来自不同标记词汇表的元素和属性，避免了名称之间的冲突。
//    <xs:schema xmlns:xs="w3c对schema的约束">




    //------------------------
//    xml缺省命名空间声明xmlns="值"就是和声明的XML Schema的命名空间相结合来规定该XML文档。
//    xmlns:xsi=”http://www.w3.org/2001/XMLSchema-instance”定义一个Schema的实例命名空间。只有作了这个定义才能使用schemaLocation属性。
    //xmlns="http://www.w3school.com.cn"
//    规定了XML默认命名空间的声明。此声明告知schema验证器，在此XML文档中使用的所有元素都被声明于 "http://www.w3school.com.cn" 这个命名空间。

//    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//    定义一个Schema的实例命名空间，（只有作了这个定义才能使用schemaLocation属性）您就可以使用 schemaLocation 属性了。
    public static void main(String[] args){


        //使用DOM4j
        Character a = 48;

        System.out.println(111111111111.0D);


    }

}
