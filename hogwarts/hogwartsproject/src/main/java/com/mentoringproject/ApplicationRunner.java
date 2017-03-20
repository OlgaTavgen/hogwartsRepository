package com.mentoringproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mentoringproject.classloading.MyOwnClassLoader;
import com.mentoringproject.hogwarts.common.service.HogwartsGetPropertyVaules;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO;
import com.mentoringproject.troubleshooting.TestMemoryLeak;
import com.mentoringproject.troubleshooting.TestThread;
import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;
import com.sun.research.ws.wadl.Application;

@SpringBootApplication
public class ApplicationRunner
{
	
	public static void main(String args[]) throws IOException
	{
		// generate xmls
//		new DeveloperDocumentXMLParser().buildDocument();
//		new TaskDocumentXMLParser().buildDocument();
	
		// test deadlock
//		TestThread.startThreads();
		
		// test memory leak
//		TestMemoryLeak.populateMap();
		
//		final HogwartsDeveloper developer = new HogwartsDeveloper();
//		
//		developer.setFirstName("First Name");
//		developer.setLastName("Last Name");
//		developer.setNickname("Nickname");
//		developer.setPrimarySkill("Primary Skill");
//		
//		HogwartsDeveloperDTO developerDTO = new HogwartsDeveloperDTO(developer);
//		
//		System.out.println(developerDTO.getClass().getClassLoader());
		
//		MyOwnClassLoader loader = new MyOwnClassLoader();
//        Class<?> c = loader.findClass("com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO");
//        Object ob = c.newInstance();
//        Method md = c.getMethod("show");
//        md.invoke(ob);
//        
//        System.out.println(c.getClass());
		
//		HogwartsGetPropertyVaules properties = new HogwartsGetPropertyVaules();
//		properties.getPropValues();
		
		SpringApplication.run(Application.class, args);		
	}	
}
