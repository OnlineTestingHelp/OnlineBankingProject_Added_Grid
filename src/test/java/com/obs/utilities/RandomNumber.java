package com.obs.utilities;

import java.util.Random;

public class RandomNumber {
	
	public static long getRandomNumber() {
		Random num = new Random();
		long number = num.nextLong();
		
		
		return number;
		
	}
}
