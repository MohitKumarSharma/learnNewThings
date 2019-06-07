package testThread;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumberUsing3Thread {
	public static void main(String[] args) {
		Printer printer1 = new Printer(0);
		Printer printer2 = new Printer(1);
		Printer printer3 = new Printer(2);
		
		printer1.start();
		printer2.start();
		printer3.start();
	}
}

class Printer extends Thread {
	private static int counter = 0;
	private int id;
	private static Object lock = new Object();

	public Printer(int _id) {
		this.id = _id;
	}
	
	public void run() {
		synchronized (lock) {
			while (counter < 99) {
				try {
					if (counter % 3 != this.id) {
						lock.wait();
					} 
					
					System.out.println(counter++);
					
					lock.notifyAll();
					
					// counter.wait();
					
				} catch (Exception _e) {
					_e.printStackTrace();
				}
			}
			
			
		}
	}
}