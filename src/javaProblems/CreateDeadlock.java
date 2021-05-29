package javaProblems;

import java.util.LinkedList;

public class CreateDeadlock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CreateDeadlock cd = new CreateDeadlock();
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					cd.method1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				cd.method2();
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
	
	
	LinkedList<String> list1 = new LinkedList<>();
	LinkedList<String> list2 = new LinkedList<>();
	
	public void method1() throws InterruptedException {
		System.out.println("Obtaining lock on list1 by thread"+Thread.currentThread().getName());
		synchronized (list1) {
			System.out.println("Obtained lock on list1 by thread"+Thread.currentThread().getName());
			while(list2.isEmpty()) {
				list1.wait();
			}
			System.out.println("Obtaining lock on list2 by thread"+Thread.currentThread().getName());
			synchronized (list2) {
				System.out.println("Obtained lock on list2 by thread"+Thread.currentThread().getName());
			}
			
		}
	}
	
	public void method2() {
		System.out.println("Obtaining lock on list2 by thread"+Thread.currentThread().getName());
		synchronized (list2) {
			System.out.println("Obtained lock on list2 by thread"+Thread.currentThread().getName());
			list2.add("item1");
			System.out.println("Obtaining lock on list1 by thread"+Thread.currentThread().getName());
			synchronized (list1) {
				System.out.println("Obtained lock on list1 by thread"+Thread.currentThread().getName());
			}
		}
	}

}
