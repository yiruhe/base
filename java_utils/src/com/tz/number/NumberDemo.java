package com.tz.number;

import java.text.DecimalFormat;

public class NumberDemo {
	
	public static void main(String[] args) {
		
		DecimalFormat dFormat = new DecimalFormat("###,###");
		
		System.out.println(dFormat.format(111111111));
		
		
	}

}
