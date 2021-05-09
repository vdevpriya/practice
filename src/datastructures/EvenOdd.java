package datastructures;

public class EvenOdd {
	
	public static Boolean flag = false;
	public static int limit = 10;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenOdd lock = new EvenOdd();
		Even e = new Even(lock);
		Odd o = new Odd(lock);
		e.start();
		o.start();
	}

}


class Even extends Thread
{
	int num = 2;
	EvenOdd lock;
	
	Even(EvenOdd l)
	{
		lock = l;
	}
	
	@Override
	public void run()
	{
		while(num<=EvenOdd.limit)
		{
			synchronized (lock) {
				while(!EvenOdd.flag)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					System.out.println(Thread.currentThread().getName()+num);
					num = num + 2;
					EvenOdd.flag = false;
					lock.notifyAll();
			}
		}
	}
}


class Odd extends Thread
{
	int num = 1;
	EvenOdd lock;	
	
	Odd(EvenOdd l)
	{
		lock = l;
	}
	
	@Override
	public void run()
	{
		
		while(num<=EvenOdd.limit)
			synchronized(lock)
			{
				while(EvenOdd.flag)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+num);
				num=num+2;
					EvenOdd.flag = true;
					lock.notifyAll();
			}
	}
}
