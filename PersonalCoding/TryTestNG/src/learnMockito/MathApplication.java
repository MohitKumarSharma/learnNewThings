package learnMockito;

public class MathApplication {
	CalculatorService service;
	
	public MathApplication(CalculatorService _service) {
		this.service = _service;
	}
	
	public int add(int a, int b) {
		return service.add(a, b);
	}
	
	public int subtract(int a, int b) {
		return service.subtract(a, b);
	}
}
