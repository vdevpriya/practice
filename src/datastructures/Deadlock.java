package datastructures;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

	public static Lock l1 = new ReentrantLock();
	public static Lock l2 = new ReentrantLock();
	public static boolean flag = false;
	
	public static void main(String arg[])
	{
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		
		t1.start();
		t2.start();
	}
	
}


class MyThread1 extends Thread
{
	public void run()
	{
		Deadlock.l1.lock();
			System.out.println(Thread.currentThread()+"Acquired Lock l1");
			Deadlock.flag = true;
			while(Deadlock.flag);
			System.out.println(Thread.currentThread()+"Waiting for l2 lock..");
			Deadlock.l2.lock();
			{
				System.out.println(Thread.currentThread()+"Acquired Lock l2");
			}
			Deadlock.l2.unlock();
		Deadlock.l1.unlock();
	}
}

class MyThread2 extends Thread
{
	public void run()
	{
		while(!Deadlock.flag);
		Deadlock.l2.lock();
		{
			Deadlock.flag = false;
			System.out.println(Thread.currentThread()+"Acquired Lock l2");
			System.out.println(Thread.currentThread()+"Waiting for l1 lock..");
			Deadlock.l1.lock();
			{
				System.out.println(Thread.currentThread()+"Acquired Lock l1");
			}
			Deadlock.l1.unlock();
		}
		Deadlock.l2.unlock();
	}
}