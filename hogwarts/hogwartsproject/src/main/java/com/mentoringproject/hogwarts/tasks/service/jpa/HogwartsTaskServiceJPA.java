package com.mentoringproject.hogwarts.tasks.service.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.tasks.model.HogwartsTask;
import com.mentoringproject.hogwarts.tasks.model.jpa.HogwartsTaskJPA;

@Repository
@Transactional(readOnly = false)
public class HogwartsTaskServiceJPA
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addTask(final String id, final String description, final String estimate, final String priority, final String severity)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		
		entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		HogwartsTaskJPA task = new HogwartsTaskJPA();
		
		task.setId(id);
		task.setDescription(description);
		task.setEstimate(estimate);
		task.setPriority(priority);
		task.setSeverity(severity);
		
		entityManager.persist(task);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	}
	
	@Transactional
	public void updateTask(final String estimate)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	      
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin( );
	    
	    HogwartsTaskJPA task = entityManager.find( HogwartsTaskJPA.class, estimate);
	      
	    //before update
	    task.setEstimate(estimate);
	    entityManager.getTransaction().commit();
	      
	    //after update
	    entityManager.close();
	    factory.close();
	}
	
	@Transactional
	public void deleteTask(final HogwartsTaskJPA hogwartsTaskJPA)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		
		entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
	      
	    HogwartsDeveloper developer = entityManager.find(HogwartsDeveloper.class, hogwartsTaskJPA);
	    
	    entityManager.remove(developer);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    emfactory.close();
	}
}
