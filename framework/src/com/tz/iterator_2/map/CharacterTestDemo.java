package com.tz.iterator_2.map;


import java.util.Map;
import java.util.HashMap;


public class CharacterTestDemo {



    public static void main(String[] args){

        String str = "dksfjmskldfjasldmald";

        char[] charArr = str.toCharArray();

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(Character k:charArr){

            if(map.containsKey(k)){


                map.put(k,map.get(k)+1);



            }else{

                map.put(k,1);

            }


        }

        System.out.println(map);


    }
}
