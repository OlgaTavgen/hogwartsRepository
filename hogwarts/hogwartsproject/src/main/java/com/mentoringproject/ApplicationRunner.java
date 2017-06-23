package com.mentoringproject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mentoringproject.classloading.MyOwnClassLoader;
import com.mentoringproject.concurrency.countdownlatch.CountDownLatchThread;
import com.mentoringproject.concurrency.cyclicbarrier.CyclicBarrierAction;
import com.mentoringproject.concurrency.cyclicbarrier.CyclicBarrierThread;
import com.mentoringproject.concurrency.exchanger.ExchangerMakeThread;
import com.mentoringproject.concurrency.exchanger.ExchangerUseThread;
import com.mentoringproject.concurrency.phaser.PhaserThread;
import com.mentoringproject.concurrency.semaphore.DecThread;
import com.mentoringproject.concurrency.semaphore.IncThread;
//import com.mentoringproject.hogwarts.developers.dao.HogwartsDeveloperDaoImplTest;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO;
import com.mentoringproject.springcore.Hogwarts;
import com.mentoringproject.troubleshooting.TestMemoryLeak;
import com.mentoringproject.troubleshooting.TestThread;
import com.shared.model.teams.TeamEnum;
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
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring-beans.xml");
//		Hogwarts hogwarts = (Hogwarts) context.getBean("HogwartsBean");
//		System.out.println(hogwarts);
		
//		try {
//      Class.forName("com.mysql.jdbc.Driver");
//      System.out.println("Loaded driver");
//      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hogwarts?user=root&password=hogwarts");
//      System.out.println("Connected to MySQL");
//      
//      Statement st = con.createStatement();
//      ResultSet rs = st.executeQuery("select * from tasks");
//      
//      while(rs.next()) {
//          System.out.println( rs.getString("task_id"));
//      }
//      st.close();
//      rs.close();
//      con.close();
//      
//      con.close();
//} 
//catch (Exception ex) {
//      ex.printStackTrace();
//}
	
//		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring-beans.xml");
//		HogwartsDeveloperDaoImplTest hogwartsDeveloperDaoImpl = (HogwartsDeveloperDaoImplTest) context.getBean("hogwartsDeveloperDaoImpl");
		
//		hogwartsDeveloperDaoImpl.addDeveloper("Olga", "Tavgen", "java", "otavgen", "2", 3);
		
//		hogwartsDeveloperDaoImpl.deleteDeveloper("Olga");
		
//		System.out.println("firstName " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen").getFirstName());
		
//		hogwartsDeveloperDaoImpl.updateDeveloperFirstName("Olga2", "Olga");		
//		System.out.println("changed firstName " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen").getFirstName());
		
//		hogwartsDeveloperDaoImpl.updateDeveloperLastName("Tavgen2", "Olga2");		
//		System.out.println("changed lastName " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen2").getLastName());
//		
//		hogwartsDeveloperDaoImpl.updateDeveloperPrimarySkill("java2", "Olga2");
//		System.out.println("changed primarySkill " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen2").getPrimarySkill());
//		
//		hogwartsDeveloperDaoImpl.updateDeveloperLevel("level2", "Olga2");		
//		System.out.println("changed Level " + hogwartsDeveloperDaoImpl.getDeveloper("Tavgen2").getLevel());
		
//		System.out.println("get all developers " + hogwartsDeveloperDaoImpl.getDevelopers());
		
		
		
//		System.out.println("simple change");
		
		//test Semaphore
		Semaphore semaphore = new Semaphore(1);
		
		new IncThread(semaphore, "A");
		new DecThread(semaphore, "B");
		
		//test CountDownLatch
		CountDownLatch latch = new CountDownLatch(5);
		
		System.out.println("testing the CountDownLatch is started");
		
		new CountDownLatchThread(latch);
		
		try
		{
			latch.await();
		}
		catch(InterruptedException e)
		{
			System.out.println("exception");
		}
		finally
		{
			System.out.println("testing the CountDownLatch is finished");
		}
		
		//test CyclicBarrier
		CyclicBarrier cb = new CyclicBarrier(3, new CyclicBarrierAction());
		
		System.out.println("testing the CyclicBarrier is started");
		
		new CyclicBarrierThread(cb, "A");
		new CyclicBarrierThread(cb, "B");
		new CyclicBarrierThread(cb, "C");
		
		//test Exchanger
		Exchanger<String> exgr = new Exchanger<String>();
		
		new ExchangerUseThread(exgr);
		new ExchangerMakeThread(exgr);
		
		//test Phaser
		Phaser phsr = new Phaser(1);
		int curPhase;
		
		System.out.println("Starting");
		new PhaserThread(phsr, "A");
		new PhaserThread(phsr, "B");
		new PhaserThread(phsr, "C");
		
		// Wait for all threads to complete phase one.
		curPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("Phase " + curPhase + " Complete");
		
		// Wait for all threads to complete phase two.
		curPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("Phase " + curPhase + " Complete");
		
		// Wait for all threads to complete phase three.
		curPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("Phase " + curPhase + " Complete");
		
		// Deregister the main thread.
		phsr.arriveAndDeregister();
		
		if(phsr.isTerminated())
		System.out.println("The Phaser is terminated");
	}	
}
