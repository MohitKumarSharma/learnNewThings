package testJava;

import java.util.Calendar;

public class TestCastType {
	public static void main(String args[]) {
		long b = 2;
		long l = 0;
		
		Calendar cal =  Calendar.getInstance();
		long startTime = Calendar.getInstance().getTimeInMillis();
		long i = 0;
		while(i < 1000000000) {
			l = l + b;
			i++;
		}
		
		long endTime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println(endTime - startTime);
		//System.out.println(l);
		
	}
}
