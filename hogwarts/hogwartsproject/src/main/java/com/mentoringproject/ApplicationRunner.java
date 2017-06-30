package com.mentoringproject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mentoringproject.classloading.MyOwnClassLoader;
import com.mentoringproject.concurrency.countdownlatch.CountDownLatchThread;
import com.mentoringproject.concurrency.cyclicbarrier.CyclicBarrierAction;
import com.mentoringproject.concurrency.cyclicbarrier.CyclicBarrierThread;
import com.mentoringproject.concurrency.exchanger.ExchangerMakeThread;
import com.mentoringproject.concurrency.exchanger.ExchangerUseThread;
import com.mentoringproject.concurrency.forkjoin.MyRecursiveAction;
import com.mentoringproject.concurrency.phaser.PhaserThread;
import com.mentoringproject.concurrency.semaphore.DecThread;
import com.mentoringproject.concurrency.semaphore.IncThread;
import com.mentoringproject.hogwarts.developers.dao.HogwartsDeveloperDaoImpl;
//import com.mentoringproject.hogwarts.developers.dao.HogwartsDeveloperDaoImplTest;
import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.developers.web.HogwartsDeveloperDTO;
import com.mentoringproject.hogwarts.tasks.dao.HogwartsTaskDaoImpl;
import com.mentoringproject.springcore.Hogwarts;
import com.mentoringproject.troubleshooting.TestMemoryLeak;
import com.mentoringproject.troubleshooting.TestThread;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.shared.model.developers.Developer;
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
	
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/spring-beans.xml");
		HogwartsDeveloperDaoImpl hogwartsDeveloperDaoImpl = (HogwartsDeveloperDaoImpl) context.getBean("hogwartsDeveloperDaoImpl");
		
		HogwartsTaskDaoImpl hogwartsTaskDaoImpl = (HogwartsTaskDaoImpl) context.getBean("hogwartsTaskDaoImpl");
		
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
		
		//test Fork/Join
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);

		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
		forkJoinPool.invoke(myRecursiveAction);
		
		//streams
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered strings:" + filtered);
		
		int count =  (int) strings.parallelStream().filter(string -> !string.isEmpty()).count();
		System.out.println("Count for non-empty strings:" + count);
		
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		//hogwarts developers stuff
		List<Developer> developers = hogwartsDeveloperDaoImpl.getDevelopers();
		
		List<Developer> filteredDevelopers = developers.stream().filter(developer -> !developers.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered developers:" + filteredDevelopers);
				
		int developersCount = (int) developers.parallelStream().filter(developer -> !developers.isEmpty()).count();
		System.out.println("Count for developers:" + developersCount);	
		
		// mongo db
		
		 try{
				
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "mongodb" );
	         System.out.println("Connect to database successfully");
	         
	         boolean auth = db.authenticate("OlgaTavgen", "mongoPassword");
	         System.out.println("Authentication: "+auth);
	         
	         DBCollection hogwartsCollection = db.createCollection("hogwartsCollection");
	         System.out.println("Hogwarts Collection created successfully");
	         
	         BasicDBObject doc1 = new BasicDBObject("title", "HogwartsDoc1").
	                 append("description", "Developers Document").
	                 append("developers", hogwartsDeveloperDaoImpl.getDevelopers()).
	                 append("mockFiled", "");
	         
	         BasicDBObject doc2 = new BasicDBObject("title", "HogwartsDoc2").
	                 append("description", "Tasks Document").
	                 append("tasks", hogwartsTaskDaoImpl.getTasks()).
	                 append("mockFiled", "");
	         
	         hogwartsCollection.insert(doc1);
	         hogwartsCollection.insert(doc2);
	         System.out.println("Documents' count that were inserted: " + hogwartsCollection.getCount());
	         
	         // get all documents in collection ()
	         DBCursor cursor = hogwartsCollection.find();
	         int i = 1;
				
	         while (cursor.hasNext()) { 
	            System.out.println("Inserted Document: "+i); 
	            System.out.println(cursor.next()); 
	            i++;
	         }
	         
	         // update documents
	         while (cursor.hasNext()) { 
	        	 BasicDBObject updateDocument = (BasicDBObject) cursor.next();
	             
	             BasicDBObject update = updateDocument.append("updated", "true");
	             
	             hogwartsCollection.update(updateDocument, update); 
	          }
	 			
	          System.out.println("Document updated successfully");
	          cursor = hogwartsCollection.find();
	 			
	          int j = 1;
	 			
	          while (cursor.hasNext()) { 
	             System.out.println("Updated Document: "+j); 
	             System.out.println(cursor.next()); 
	             j++;
	          }
				
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }	
	}	
}
