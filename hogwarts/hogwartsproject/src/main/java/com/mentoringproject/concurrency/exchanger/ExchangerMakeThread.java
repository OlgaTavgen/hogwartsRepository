package com.mentoringproject.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerMakeThread implements Runnable
{
	Exchanger<String> ex;
	String str;
	
	public ExchangerMakeThread(Exchanger<String> c) 
	{
		ex = c;
		str = new String();
		new Thread(this).start();
	}
	
	public void run()
	{
		char ch = 'A';
		
		for(int i = 0; i < 3; i++) 
		{
			// Fill Buffer
			for(int j = 0; j < 5; j++)
			{
				str += ch++;
				
				try
				{
					// Exchange a full buffer for an empty one.				
					str = ex.exchange(str);
				} 
				catch(InterruptedException exc)
				{
					System.out.println(exc);
				}					
			}
		}
	}
}
