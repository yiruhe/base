package com.tz.iterator;

/**
 * Created by Administrator on 2017/1/22 0022.
 */
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;
public class TreeSetDemo {


    public static void main(String[] args) {
        //bigDecimal

//        SortedSet num = new TreeSet();
//
//        num.add(100);
//        num.add(2);
//        num.add(66);
//
//        num.add(12);
//        Iterator iterator = num.iterator();
//
//        while (iterator.hasNext()) {
//
//            System.out.println(iterator.next());
//        }

        SortedSet users = new TreeSet();

        users.add(new User(15));
        users.add(new User(13));
        users.add(new User(120));
        users.add(new User(111));
        users.add(new User(11));

        Iterator iterator = users.iterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }


    }
}

class User implements Comparable{

    int age;
    User(int age){
        this.age = age;
    }


    public String toString(){

        return "User[age"+age+"]";
    }

    public int compareTo(Object o){

        int age = this.age;
        int age1 = ((User)o).age;

        return age - age1;
    }


}

class CompareDemo  implements Comparator<User>{
    @Override
    public int compare(User o1,User o2){

        if(o1.age > o2.age){

            return 1;
        }else if(o1.age <o2.age){

            return -1;

        }

        return 0;
    }


}
