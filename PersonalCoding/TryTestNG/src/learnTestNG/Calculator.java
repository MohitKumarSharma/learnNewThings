package learnTestNG;

public class Calculator {
	int band;
	
	public Calculator(int _band) {
		this.band = _band;
	}
	
	public int add(int a, int b) {
		return (a + b)/this.band;
	}
	
	public int mul(int a, int b) {
		return (a*b)/this.band;
	}
	
	public int subtract(int a, int b) {
		return a - b;
	}
	
	public int div(int a, int b) {
		return a/b;
	}
}
