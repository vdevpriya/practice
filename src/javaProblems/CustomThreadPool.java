package javaProblems;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
	
	private final BlockingQueue<Runnable> taskQueue;
	private final TaskRunner[] threadPool;
	private boolean isAlive;
	
	CustomThreadPool(int num) {
		this.isAlive = true;
		this.taskQueue = new LinkedBlockingQueue<>();
		this.threadPool = new TaskRunner[num];
		for (TaskRunner runnerThread : threadPool) {
			runnerThread = new TaskRunner();
			Thread t = new Thread(runnerThread);
			t.start();
		}
	}
	
	void killThreadPool() {
		this.isAlive = false;
	}
	
	void addTask(Runnable task) throws InterruptedException {
		taskQueue.put(task);
	}

	class TaskRunner implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isAlive) {
				try {
					taskQueue.take().run();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
