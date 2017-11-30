package com.tz.arraydemo;


import java.util.Arrays;

public class PlayerDemo
{

    private  Object[] arr =  null;
    private  int count = 0;


    //初始化

    public PlayerDemo(){

        this(10);
    }
    public PlayerDemo(int size){

        if(size <0){

            throw new IllegalArgumentException("请输入合法的数");
        }
            arr = new Object[size];

    }
    //添加元素
    public PlayerDemo add(Object num){

        if(count == arr.length){

            arr = Arrays.copyOf(arr,arr.length * 2+2);
        }

        arr[count++] = num;

        return this;
    }

    //重写toString方法;
    public void print()
    {

        if(count == 0){

            System.out.println("[]");

            return;
        }

        StringBuilder stringBuilder = new StringBuilder(count*3-1);

        stringBuilder.append("[");

        for(int i=0;i<count;i++){

            stringBuilder.append(arr[i]);

            if(i != count-1){

                stringBuilder.append(",");

            }else{

                stringBuilder.append("]");
            }

        }
            System.out.println(stringBuilder.toString());


    }

    //根据索引查询球员
    public Object getIndex(int index){

        if(index >= count || index < 0){

            throw new IllegalArgumentException("数组越界");

        }

        return arr[index];
    }

    //根据球员编号，查询
    public int getPlayerNumber(int playerNumber)
    {

        for(int i=0;i<count;i++){

//            if(arr[i] == playerNumber){
//
//                return i;
//            }
        }

        return -1;
    }

    //根据球员编号修改，替换球员
    public void setPlayerNumber(int oldPlayer,int newPlayer){

       this.getIndex(this.getPlayerNumber(oldPlayer));

    }
    //删除球员
    public boolean deletePlayer(int index)
    {

        if(index < count) {

            System.arraycopy(arr,index+1,arr,index,count - index-1);

            arr[count-1] = null;

            count--;

            return true;
        }

        return false;
    }



    public static void main(String[] args)
    {

        PlayerDemo p =new PlayerDemo(5);
        p.add(1);
        p.add(2);
        p.add(3);
        p.add(4);
        p.add(5);
        p.add(5);
        p.add(5);
        p.add(5);
        p.add(5);
        p.add(5);
        p.print();
        System.out.println(p.getIndex(0));
        p.print();



    }


}
