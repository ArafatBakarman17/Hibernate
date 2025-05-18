package com.Dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Engine;
public class EngineDao 
{
	public static void addEngine()
	{
		EntityManagerFactory	emf =Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		

	Engine e = new Engine();
		e.setCc(1500);
		e.setType("diesel");
			
		
		et.begin();
		em.persist(e);
		et.commit();
		
		
	}
	
	public static void deleteEngine(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		 et.begin();
		 Engine	e=em.find(Engine.class, id);
		 em.remove(e);
		 et.commit();
	}
	
	
	
	public static void EngineDetails()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		String jpql="Select s from Engine s ";
		Query q = em.createQuery(jpql);
	List<Engine> li = q.getResultList();
	li.forEach(al->System.out.println(al));
	et.commit();
	}
}
