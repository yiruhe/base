package com.tz.iterator;

public abstract class IteratorDemo {

    IteratorDemo(){
        System.out.println("B");
    }
	public static void main(String[] args){


        IteratorDemo a = new A();

	}

}

class  A extends IteratorDemo{

    public A(){

        System.out.println("A");

        }
}
