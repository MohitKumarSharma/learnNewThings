package testAbstract;

public abstract class TestAbtract {
	public TestAbtract(String _t) {
		this.callMohit();
	}
	
	public void callMohit() {
		System.out.println("Calling Mohit");
	}
	
	public abstract void sayHi(String _name);
}
