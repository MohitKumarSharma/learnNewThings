package testStatic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {
	public static void main(String args[]) {
		Printer printer = new Printer();
		
		WorkerThread worker1 = new WorkerThread(printer, 0);
		WorkerThread worker2 = new WorkerThread(printer, 1);
		
		worker1.start();
		worker2.start();
	}
}

class WorkerThread extends Thread {
	public static AtomicInteger start = new AtomicInteger(0);
	Printer printer;
	
	WorkerThread(Printer _printer, int _start) {
		//this.start = _start;
		this.printer = _printer;
	}
	
	public void run() {
		while (start.get() <= 10) {
				printer.print(start);
			}
		}
	}



class Printer {
	public void print(AtomicInteger _val) {
		
		synchronized (this) {
			System.out.println(_val.get());
			_val.incrementAndGet();
			notifyAll();
			
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("abc");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}