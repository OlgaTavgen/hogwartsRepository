package com.mentoringproject.concurrency.cyclicbarrier;

public class CyclicBarrierAction implements Runnable
{
	public void run() 
	{
		System.out.println("Barrier Reached!");
	}
}
