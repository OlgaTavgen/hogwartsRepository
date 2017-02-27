package com.mentoringproject;

import com.mentoringproject.troubleshooting.TestMemoryLeak;
import com.mentoringproject.troubleshooting.TestThread;
import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;

public class ApplicationRunner
{
	
	public static void main(String args[])
	{
		// generate xmls
//		new DeveloperDocumentXMLParser().buildDocument();
//		new TaskDocumentXMLParser().buildDocument();
	
		// test deadlock
//		TestThread.startThreads();
		
		// test memory leak
		TestMemoryLeak.populateMap();
	}	
}
