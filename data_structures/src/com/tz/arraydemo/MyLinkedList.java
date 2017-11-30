package com.tz.arraydemo;


public class MyLinkedList {

    private Node first = null;
    private Node last = null;
    private int  size =0;

    //node节点
    private class Node{

        Node previous = null;
        Node next = null;
        Object element = null;

        Node(Object element){

            this.element= element;
        }

    }

    //添加元素
    public void addElement(Object element){

        Node node = new Node(element);

        if(size == 0){

            this.first = node;
            this.last = node;

        } else {

            //添加新元素:
            //把最后一个的下一个和node衔接起来
            this.last.next = node;
            //吧node作为最后一个,它的previous就是当前的last对象
            node.previous = this.last;
            //最后把node变为最后一个,并存储到this.last
            this.last = node;

        }

        size++;

    }
    //addFirst
    public void addFirst(Object o){

        Node node = new Node(o);

        if(size == 0){

            this.first = node;
            this.last = node;

        }else{

            //把第一个对象作为第二个对象
            node.next = this.first;

            this.first.previous = node;
            this.first = node;

        }

        size++;


    }


    //打印
    public void print(){


        StringBuilder sb = new StringBuilder(size*2+1);

        sb.append("[");

        Node template = this.first;

        while(template != null){

            sb.append(template.element);

            //如果template.next 为空 那么三目运算的结果就是 "]";
            sb.append((template =template.next) != null ? ",":"]");


        }

        System.out.println(sb.toString());

    }

    //查询
    public Node  getNode(String  o){

        Node node = this.first;

        for(int i=0;i<size;i++){

            if(!node.element.equals(o)){
                if(node.next == null){

                    return null;

                }

                node = node.next;

            }

        }

        return node;

    }

    public void remove(String s){

        Node node = this.getNode(s);

        if(node == this.first){

            this.first = this.first.next;
            this.first.previous = null;

        }
        else if(node == this.last){

             this.last = this.last.previous;
             this.last.next = null;

        }else{


            node.previous.next = node.next;

            node.next.previous = node.previous;

        }

        size--;

    }

    public static void main(String[] args){

        MyLinkedList list = new MyLinkedList();

        list.addElement("A");
        list.addElement("B");
        list.addElement("C");
        list.addFirst("A");

        list.print();

//        System.out.println(list.getNode("C").element);

        list.remove("A");

        list.remove("C");
        System.out.println(list.getNode("B").previous.previous);
        list.print();

    }

}
