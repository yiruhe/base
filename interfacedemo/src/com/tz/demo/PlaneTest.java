package com.tz.demo;

public class PlaneTest {

	public static void PlaneFly(Plane plane){
		
		plane.fly();
	}
	public static void main(String[] args) {
		//Copter copter = new Copter();
		//Jet copter = new Jet();
		//传入一个对象
		PlaneTest.PlaneFly(new Copter());
	}
}
