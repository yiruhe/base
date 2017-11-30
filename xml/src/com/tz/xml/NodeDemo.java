package com.tz.xml;


import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class NodeDemo {


    @Test
    public void test() {

    	//w3c包:
    	//DOM:Document Object Model:文档对象模型
    	//要操作XML就先获取Document对象
    	//DOM在做增删改查的时候性能比较低(线性搜索),
    	
    	
//        Element:表示元素对象
        //Document:当前的文档对象
//        Attr:属性
        //text:文本

        File file = new File(".");

        System.out.println(file.getAbsolutePath());

        //利用DocumentBuilderFactory 工厂构建  DocumentBuilder 根据DocumentBuilder拿到dom对象

        //把一个简单类型转化成数据类型---> 解析
//        getElementById()  ——>必须要使用xml约束来限定ID的唯一性

    }

    @Test
    public void testRead() throws Exception {

        //获取xml文件
        File file = new File("src/com/tz/xml/nodeDemo.xml");

        //通过工厂获取文档解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //获取解析器
        DocumentBuilder builderDom = factory.newDocumentBuilder();
        //获取到文档对象document对象中也有getElementsByTagName这是获取文档中的
        Document dom = builderDom.parse(file);


        //获取根节点 这个是获取这个节点的子节点的
        //文档的子节点,这就是根元素
        Element root = dom.getDocumentElement();

        Assert.assertEquals(dom, root);


        NodeList list = root.getElementsByTagName("student");

        System.out.println(list.getLength());

        //获取第一个节点
        Element node = (Element) list.item(0);

        //得到该节点下所有的node
        NodeList children = node.getChildNodes();

        System.out.println(children.getLength()); //7包含 --> \n
        System.out.println(children.item(0));

        NodeList nameList = node.getElementsByTagName("name");

        Element name = (Element) nameList.item(0);

        String text = name.getTextContent();

        Assert.assertEquals("back", text);

    }

//    @Test
//    public void testDeleteName() throws Exception {
//
//        //1.获取xml文件路径
//
//        File file = new File("src/com/tz/xml/nodeDemo.xml");
//
//        //2.先拿到文档解析器
//
//        //先获取文档解析器工厂
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        //获取解析器
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        //解析xml
//        Document dom = builder.parse(file);
//
//        //获取文档的根节点
//
//        Element root = dom.getDocumentElement();
//
//        //获取student节点集合
//        NodeList rootChildrenElementList = root.getElementsByTagName("student");
//
//        //获取第一个student的
//        Element studentA = (Element) rootChildrenElementList.item(0);
//
//        //获取student的name
//        Element aName = (Element) studentA.getElementsByTagName("name").item(0);
//        //获取name的text
//        String aNameText = aName.getTextContent();
//
//        System.out.println(aNameText);
//
//        //替换该name
//        aName.setTextContent("Hello");
//
//			同步操作:
//        //获取transformer
//        //通过transformerFactory 获取transformer的实例
//
//        TransformerFactory transFactiry = TransformerFactory.newInstance();
//
//
//        Transformer transformer = transFactiry.newTransformer();
//
//
//        transformer.transform(new DOMSource(dom), new StreamResult(file));
//
//
//    }
//
//    @Test
//    public void testAppendChildren() throws Exception {
//
//        //1.获取xml文档解析器
//        //1.1 通过xml文档工厂获取文档解析器的实例
//
//        File file = new File("src/com/tz/xml/nodeDemo.xml");
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//
//        //获取到文档对象
//        Document document = documentBuilder.parse(file);
//
//        //获取文档的直接子节点
//        Element root = document.getDocumentElement();
//
//        // NodeList studentNodeList = root.getElementsByTagName("student");
//
//        //System.out.println(studentNodeList.getLength());
//
//        //创建一个文档碎片
//        DocumentFragment fragment = document.createDocumentFragment();
//
//        //创建一个student
//        Element newStudent = document.createElement("student");
//        //创建一个name元素
//        Element newName = document.createElement("name");
//        //创建一个Gender元素
//        Element newGender = document.createElement("gender");
//        //创建一个newAge元素
//        Element newAge = document.createElement("age");
//
//        //设置attribute属性
//        newStudent.setAttribute("num", "e");
//        //给newName添加一个文本
//        newName.setTextContent("西门吹雪");
//        //添加Gender
//        newGender.setTextContent("man");
//        //添加age
//        newAge.setTextContent("20");
//
//        //重新构建元素顺序
//
//        //返回添加的节点
//        newStudent.appendChild(newName);
//        newStudent.appendChild(newGender);
//        newStudent.appendChild(newAge);
//
//        fragment.appendChild(newStudent);
//        //把学生添加到
//        root.appendChild(fragment);
////        创建一个transform 吧内存中的DOM输出到xml文件中
//
    		//同步操作
//        //last:创建一个Transformer转换器
//        //通过transform工厂创建一个转换器
//
//        //创建出工厂对象
//        TransformerFactory transformerfactory = TransformerFactory.newInstance();
//        //利用工厂对象创建转换器实例
//        Transformer transformer = transformerfactory.newTransformer();
//
//        //转换
    		//DOMSource: 内存中的document对象
    		//StringResult:disk中的文件 -->流出到哪里
//        transformer.transform(new DOMSource(document), new StreamResult(file));
//
//
//    }
//
//    @Test
//    public void testNewDocument() throws Exception {
//
//        File file = new File("src/com/tz/xml/nodeTestDemo.xml");
//
//        Document document;
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentbuilder = factory.newDocumentBuilder();
//
//        if (file.exists()) {
//            document = documentbuilder.parse(file);
//        } else {
//
//            document = documentbuilder.newDocument();
//
//        }
//
//        document.setXmlVersion("1.0");
//
//        Element namespace = document.createElementNS("http://www.w3", "contacts");
//
//        //QName无非是有着特定格式的xml元素，其作用主要是增加了名字空间，比如有同样的元素名称，而名字空间不同的情况
//        //这个方法的会自动创建xmlns的xmlns的别名,后面是实现这个别名
//        namespace.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation", "http://www.w3 node.xsd");
//
//        document.appendChild(namespace);
//
//        namespace.appendChild(document.createElement("student"));
//
//
//        //创建出工厂对象
//        TransformerFactory transformerfactory = TransformerFactory.newInstance();
//        //利用工厂对象创建转换器实例
//        Transformer transformer = transformerfactory.newTransformer();
//
//        //转换
//        transformer.transform(new DOMSource(document), new StreamResult(file));
//
//
//    }

}
