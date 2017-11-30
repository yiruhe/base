package com.javabean;

/**
 * Created by Administrator on 2017/3/26.
 */
public class BeanTestDemo {

    private int age;
    private String name;
    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gander) {
    this.gender = gander;
    }


    public BeanTestDemo(String name,String gender,int age){

            this.name = name;
            this.gender = gender;
            this.age = age;
    }

    public BeanTestDemo(){

    }


}
