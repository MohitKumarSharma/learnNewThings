package testStatic;

import testApp.MyStaticClass;

public class MyMainClass {
	public static void main(String args[]) throws ClassNotFoundException {
		MyStaticClass myStatic = null;
		System.out.println("Befor calling");
		Class clas = Class.forName("hdca.MyStaticClass");
		
		System.out.println("Test static block ");
		
		String a = "1001";
		
		System.out.println(a.charAt(1));
		System.out.println(a.charAt(0));
		
		if ((a.charAt(1) & a.charAt(0)) == 48) {
			System.out.println("abc");
		}
		System.out.println((char)((int)a.charAt(1) & (int)a.charAt(0)));
	}
}
