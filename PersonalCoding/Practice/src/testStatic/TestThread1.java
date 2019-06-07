package testStatic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread1 {
	public static void main(String args[]) throws InterruptedException {
		Printer1 printer = new Printer1();
		
		WorkerThread1 wt1 = new WorkerThread1(printer, new AtomicInteger(0));
		WorkerThread1 wt2 = new WorkerThread1(printer, new AtomicInteger(1));
		
		wt1.start();
		Thread.sleep(10);
		wt2.start();
	}
}


class WorkerThread1 extends Thread {
	public AtomicInteger start = new AtomicInteger(0);
	Printer1 printer;
	
	WorkerThread1(Printer1 _printer, AtomicInteger _start) {
		this.start = _start;
		this.printer = _printer;
	}
	
	public void run() {
		while (this.start.get() <= 10) {
				printer.print(start);
				this.start.addAndGet(2);
			}
		}
	}



class Printer1 {
	ReentrantLock rLock = new ReentrantLock();
	Condition condition = rLock.newCondition();
	
	
	public void print(AtomicInteger _val) {
		
		rLock.lock();
		System.out.println(_val.get() + " t1" );
		condition.signalAll();
		
		try {
			condition.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}