package com.mentoringproject.concurrency.phaser;

import java.util.concurrent.Phaser;

public class PhaserThread implements Runnable
{
	Phaser phsr;
	String name;
	
	public PhaserThread(Phaser p, String n)
	{
		phsr = p;
		name = n;
		phsr.register();
		
		new Thread(this).start();
	}
	
	public void run()
	{
		System.out.println("Thread " + name + " Beginning Phase One");
		
		phsr.arriveAndAwaitAdvance(); // Signal arrival.
		
		// Pause a bit to prevent jumbled output. This is for illustration
		// only. It is not required for the proper operation of the phaser.
		try
		{
			Thread.sleep(10);
		} 
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		System.out.println("Thread " + name + " Beginning Phase Two");
		
		phsr.arriveAndAwaitAdvance(); // Signal arrival.
		
		// Pause a bit to prevent jumbled output. This is for illustration
		// only. It is not required for the proper operation of the phaser.
		try 
		{
			Thread.sleep(10);
		} 
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		System.out.println("Thread " + name + " Beginning Phase Three");
		phsr.arriveAndDeregister(); // Signal arrival and deregister.
	}
}
