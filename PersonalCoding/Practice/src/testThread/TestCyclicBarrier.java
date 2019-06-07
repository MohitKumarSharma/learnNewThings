package testThread;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->  {System.out.println("Stopped for refilling");});
		
		Biker mohit = new Biker("Mohit", cyclicBarrier);
		Biker aniketh = new Biker("Aniketh", cyclicBarrier);
		Biker parag = new Biker("Parag", cyclicBarrier);
		
		mohit.start();
		aniketh.start();
		parag.start();
		
	}
}

class Biker extends Thread {
	private String name;
	private CyclicBarrier barrier;
	
	public Biker(String _name, CyclicBarrier _barrier) {
		this.name = _name;
		this.barrier = _barrier;
	}
	
	public void run() {
		try {
			System.out.println(this.name + " has left Rampur");
			this.barrier.await();
			
			System.out.println(this.name + " has reached first checkpoint Mathura");
			
			this.barrier.await();
			
			System.out.println(this.name + " has reached first checkpoint ahmadnagr");
			
			this.barrier.await();
			
			System.out.println(this.name + " has reached destination pune");
			
		} catch (Exception _e) {
			_e.printStackTrace();
		}
	}
}
