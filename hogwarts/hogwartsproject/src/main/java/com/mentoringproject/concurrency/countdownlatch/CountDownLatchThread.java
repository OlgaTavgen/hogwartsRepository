package com.mentoringproject.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThread implements Runnable
{
	CountDownLatch latch;
	
	public CountDownLatchThread(CountDownLatch latch)
	{
		this.latch = latch;
		new Thread(this).start();
	}
	
	public void run()
	{
		for(int i = 0; i<5; i++) 
		{
			System.out.println(i);
			latch.countDown(); // decrement count
		}
	}
}
