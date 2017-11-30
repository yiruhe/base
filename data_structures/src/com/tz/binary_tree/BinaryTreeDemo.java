package com.tz.binary_tree;


public class BinaryTreeDemo {

    //树:选择一个数据作为根节点,而后比根节点放在左,大放在右
    //遍历取出(左中右)


    private class Node{
        private Comparable data;
        private Node left;
        private Node right;

        Node(Comparable data){

            this.data = data;


        }

        void addNode(Node newNode){

            if(this.data.compareTo(newNode.data)<0){

                if(this.left == null){
                    this.left = newNode;

                }else{

                    this.left.addNode(newNode);


                }


            }else{

                if(this.right == null){

                    this.right = newNode;
                }else{

                    this.right.addNode(newNode);

                }

            }


        }

        void print(){


            if(this.left != null){

                this.left.print();

            }
                System.out.println(((Book)this.data).getter());

            if(this.right != null){

                this.right.print();

            }


        }

    }

    private Node root; //设置根节点

    public void add(Object obj){

        Comparable com = (Comparable)obj;

        Node newNode = new Node(com); //创建新节点,保存数据

        if(this.root == null){

            this.root= newNode;

        }else{

            this.root.addNode(newNode);

        }



    }

    public void print(){

        if(this.root == null){


//            System.out.println(null); //为什么不能打印null? 因为有三个可以接受引用类型的重载函数,编译器无法判断
            System.out.println((String)null);

        }else{


            this.root.print();

        }

    }


    public static void main(String[] args){

        BinaryTreeDemo b = new BinaryTreeDemo();

        b.add(new Book(10));
        b.add(new Book(30));
        b.add(new Book(20));
        b.add(new Book(50));
        b.add(new Book(40));

        b.print();





    }

}


class Book implements Comparable<Book>{

    private int price;


    Book(int price){

        this.price = price;

    }

    public int compareTo(Book o){

        if(this.price>o.price){

            return 1;
        }else if(this.price <o.price){

            return -1;
        }

        return 0;

    }

    public int getter(){


        return this.price;

    }


}
