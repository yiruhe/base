package com.tz.iterator;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

/**
 *
 * Created by Administrator on 2017/1/24 0024.
 */
public class Test {

   public static void  main(String[] args){


       SortedSet users = new TreeSet<UserAge>(new Comparator<UserAge>(){

            @Override
           public int compare(UserAge b1,UserAge b2) {

                if (b1.age > b2.age) {

                    return -1;

                } else if (b2.age > b1.age) {

                    return 1;

                }

                return 0;
            }
       });

       users.add(new UserAge(15));
       users.add(new UserAge(13));
       users.add(new UserAge(120));
       users.add(new UserAge(111));
       users.add(new UserAge(11));

       Iterator iterator = users.iterator();

       while(iterator.hasNext()){

           System.out.println(iterator.next());

       }

   }
}

class UserAge{
    int age = 0;

    public UserAge(int age){

        this.age = age;

    }

    @Override
    public String toString(){

        return "UserAge"+this.age;
    }
}
