package com.mentoringproject;

import com.mentoringproject.hogwarts.web.HogwartsController;
import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;

public class DocumentXMLGenerator {
	
	public static void main(String args[])
	{
		new DeveloperDocumentXMLParser().buildDocument();
		new TaskDocumentXMLParser().buildDocument();
		
//		HogwartsController controller = new HogwartsController();
//		
//		controller.retrieveResults("Slytherin");
	}
}
