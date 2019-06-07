package testApp;

public class MyStaticClass {
	public static String name = "Mohit";
	static {
		System.out.println("In static block");
		printMessage();
	}
	
	public void HI() {
		System.out.println("HI");
	}
	
	public static void printMessage() {
		System.out.println("From static block");
	}
	
}
