package testThread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class CustomBlockingQueue<T> {
	private Queue<T> queue;
	private int size;
	ReentrantLock rLock;
	Condition emptyQueue;
	Condition fullQueue;
	
	public CustomBlockingQueue(int _size) {
		queue = new LinkedList<T>();
		this.size = _size;
		rLock = new ReentrantLock();
		emptyQueue = rLock.newCondition();
		fullQueue = rLock.newCondition();
	}
	
	public  void add(T item) {
		if (rLock.tryLock()) {
			if (this.size == this.queue.size()) {
				try {
					System.out.println("Waiting for space");
					fullQueue.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.queue.add(item);
			
			emptyQueue.signalAll();
			rLock.unlock();
		}
		
	}
	
	public  T remove() {
		if (rLock.tryLock()) {
			if (this.size == 0) {
				try {
					System.out.println("No element left");
					emptyQueue.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			T item = this.queue.poll();
			
			
			fullQueue.signalAll();
			
			rLock.unlock();
			return item;
		}
		
		return null;
	}
}

public class CustomBlockingQueueTest {
	public static void main(String[] args) throws InterruptedException {
		CustomBlockingQueue<Integer> cqueue = new CustomBlockingQueue<Integer>(3);
		
		Producer producer = new Producer(cqueue);
		Consumer consumer  = new Consumer(cqueue);
		producer.start();
		consumer.start();
		
		producer.join();
		consumer.join();
		
		System.out.println("finished execution");
	}
}

class Producer extends Thread {
	CustomBlockingQueue<Integer> queue;
	
	public Producer(CustomBlockingQueue<Integer> _queue) {
		this.queue = _queue;
	}
	
	public void run() {
		int i = 0;
		while (true) {
			System.out.println("Added " + i);
			this.queue.add(i);
			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}

class Consumer  extends Thread {
	CustomBlockingQueue<Integer> queue;
	
	public Consumer(CustomBlockingQueue<Integer> _queue) {
		this.queue = _queue;
	}
	
	public void run() {
		while (true) {
			int item = this.queue.remove();
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Removed " + item);
		}
	}
}
