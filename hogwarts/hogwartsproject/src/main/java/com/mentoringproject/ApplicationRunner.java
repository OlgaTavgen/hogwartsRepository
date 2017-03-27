package com.mentoringproject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mentoringproject.classloading.MyOwnClassLoader;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO;
import com.mentoringproject.soapwebservice.IPLocationFinder;
import com.mentoringproject.soapwebservice.net.webservicex.GeoIP;
import com.mentoringproject.soapwebservice.net.webservicex.GeoIPService;
import com.mentoringproject.soapwebservice.net.webservicex.GeoIPServiceSoap;
import com.mentoringproject.troubleshooting.TestMemoryLeak;
import com.mentoringproject.troubleshooting.TestThread;
import com.shared.service.DeveloperDocumentXMLParser;
import com.shared.service.TaskDocumentXMLParser;

public class ApplicationRunner
{
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException,
    NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException 
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
		
//		if (args.length != 1)
//		{
//			System.out.println("You need to pass in one IP address");
//		}
//		else 
//		{
//			String ipAddress = args[0];
//			GeoIPService ipService = new GeoIPService();
//			GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
//			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
//			System.out.println(geoIP.getCountryName());
//		}
		
		IPLocationFinder.findLocation(args);
	}	
}
