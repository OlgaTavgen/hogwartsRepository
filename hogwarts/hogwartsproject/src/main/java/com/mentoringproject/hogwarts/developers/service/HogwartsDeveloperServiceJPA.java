package com.mentoringproject.hogwarts.developers.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mentoringproject.hogwarts.developers.model.HogwartsDeveloper;
import com.mentoringproject.hogwarts.developers.model.jpa.HogwartsDeveloperJPA;

@Repository
@Transactional(readOnly = false)
public class HogwartsDeveloperServiceJPA
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addDeveloper(final String firstName, final String lastName, final String nickname, final String primarySkill, final String level)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		
		entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		HogwartsDeveloperJPA developer = new HogwartsDeveloperJPA();
		
		developer.setFirstName(firstName);
		developer.setLastName(lastName);
		developer.setNickname(nickname);
		developer.setPrimarySkill(primarySkill);
		developer.setLevel(level);
		
		entityManager.persist(developer);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	}
	
	@Transactional
	public void updateDeveloper(final String lastName, final String level)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	      
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin( );
	    
	    HogwartsDeveloper developer = entityManager.find( HogwartsDeveloper.class, lastName);
	      
	    //before update
	    developer.setLevel(level);
	    entityManager.getTransaction().commit();
	      
	    //after update
	    entityManager.close();
	    factory.close();
	}
	
	@Transactional
	public void deleteDeveloper(final HogwartsDeveloperJPA developerJPA)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
		
		entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
	      
	    HogwartsDeveloper developer = entityManager.find(HogwartsDeveloper.class, developerJPA);
	    
	    entityManager.remove(developer);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    emfactory.close();
	}
}
