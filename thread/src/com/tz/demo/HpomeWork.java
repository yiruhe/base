package com.tz.demo;

public class HpomeWork {
	public static void main(String[] args) {
		
		Cus cus = new Cus();
		Thread t1 = new Thread(cus);
		Thread t2 = new Thread(cus);
		t1.start();
		t2.start();
	}

}
class Bank{
	private int num;
	public void add(int n){
		
		synchronized(Bank.class){
			
			num = num + n;
			System.out.println(num);
			
		}
	
	}
}

class Cus implements Runnable{
	private Bank bank = new Bank();
	public void run(){
		
		for(int i=0;i<3;i++){
			bank.add(100);
		}
	}
	
	
	
}