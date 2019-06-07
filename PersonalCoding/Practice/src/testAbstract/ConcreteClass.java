package testAbstract;

public class ConcreteClass extends TestAbtract {
	public static void main(String[] args) {
		TestAbtract ta = new ConcreteClass();
		
		ta.sayHi("PP");
	}
	
	public ConcreteClass() {
		super("fa");
	}
	
	@Override
	public void sayHi(String _name) {
		System.out.println("Hi " + _name);
		
	}
	
}
