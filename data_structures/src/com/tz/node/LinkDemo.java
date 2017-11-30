package com.tz.node;


public class LinkDemo {


    private Node root = null;
    //计数:
    private int count = 0;
    //
    private int foot = 0;
    int a =0;

    //使用内部类第一节点，服务Link类
    private class Node {
        private String data = null;
        private Node next = null;

        Node(String data) {

            this.data = data;

        }

        void addNext(Node node) {

            if (this.next == null) {

                this.next = node;

            } else {

                //向尾部添加node类节点
                this.next.addNext(node);
            }


        }


        void getNext() {

            System.out.println(this.data);

            if (this.next != null) {

                this.next.getNext();
            }
        }

        public boolean containsNode(String data) {

            //检测data和对象的data是否相等
            return this.data.equals(data) ||
                    //检测有没有下一个对象,如果有就调用下一个对象的contains方法
                    this.next != null &&
                            this.next.containsNode(data);

        }

        //根据index取得值
        public String getNode(int index) {

            if (LinkDemo.this.foot++ == index) {

                return this.data;

            } else {

                return this.next.getNode(index);
            }

        }

        //删除节点
        public void removeNode(Node previous, String data) {

            if (data.equals(this.data)) {

                previous.next = this.next;

                count--;

            } else {

                if(this.next != null){

                    this.next.removeNode(this,data);

                }


            }

        }

    }

    public void add(String data) {

        //不保存空值
        if (data == null) return;

        Node node = new Node(data);

        if (root == null) {

            root = node;

        } else {

            this.root.addNext(node);

        }
        //每次成功添加就统计一次数据大小
        count++;

    }

    //判断链表是否是空
    public boolean isEmpty() {

        return count == 0;
    }

    //size判断
    public int size() {

        return this.count;
    }

    //打印链表

    public void print() {

        if (isEmpty()) {

            System.out.println("链表是空的");

        } else {

            root.getNext();

        }

    }

    //判断元素是否存在
    public boolean contains(String data) {


        return !(this.root == null || data == null) &&

                this.root.containsNode(data);

    }

    //查询索引上的data值
    public String get(int index) {

        if (index > count) {

            return null;
        }

        this.foot = 0;

        return this.root.getNode(index);


    }

    //remove

    public void remove(String data){

        if(!this.contains(data))return;

        if(data.equals(this.root.data)){

            this.root = this.root.next;
            this.count--;
        } else {

            this.root.removeNode(this.root,data);

        }

    }

}


