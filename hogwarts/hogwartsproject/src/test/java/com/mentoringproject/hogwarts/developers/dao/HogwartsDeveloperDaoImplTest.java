//package com.mentoringproject.hogwarts.developers.dao;
//
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static org.mockito.Mockito.*;
//
//import static org.fest.assertions.Assertions.assertThat;
//
//public class HogwartsDeveloperDaoImplTest
//{
//	@Mock
//	private JdbcTemplate jdbcTemplate;
//	
//	private static HogwartsDeveloperDaoImpl hogwartsDeveloperDaoImpl;
//
//	
//	@BeforeAll
//	public static void init()
//	{
//		hogwartsDeveloperDaoImpl = new HogwartsDeveloperDaoImpl();
//	}
//	
//	@AfterAll
//	public static void cleanUp()
//	{
//		System.out.println("Clean Up");
//	}
//	
//	
//	@BeforeEach
//	public void beforeEach()
//	{
//		System.out.println("Before each test beforeEach() method is called");
//		assertThat(hogwartsDeveloperDaoImpl).isNotNull();
//	}
//	
//	@AfterEach
//	public void afterEach()
//	{
//		System.out.println("After each test afterEach() method is called");
//		assertThat(hogwartsDeveloperDaoImpl).isNotNull();
//	}
//	
//	@Test
//	public void testAddDeveloper()
//	{
//		Mockito.when(jdbcTemplate.update(anyString(), anyString(), anyString(), anyString(), anyInt())).thenReturn(1);
//		
//		hogwartsDeveloperDaoImpl.addDeveloper("firstName", "lastName", "nickname", "primarySkill", "level", 1);
//		
////		assertThat(jdbcTemplate.)
//	}
//
//}
