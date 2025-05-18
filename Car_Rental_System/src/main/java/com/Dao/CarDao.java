package com.Dao;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Engine;

public class CarDao 
{
	public static void addCar(int year,int month,int day)
	{
		EntityManagerFactory	emf =Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		

		
		Car c= new Car();
		c.setBrand("Lamborgini");
		c.setModel("Aventador");
		c.setRegisteredDate(LocalDate.of(year, month, day));
		
		
		et.begin();
		em.persist(c);
		et.commit();
		
		
	}
	
	
	
	public static void addCarOrEngine(int year,int month,int day)
	{
		EntityManagerFactory	emf =Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		

		Engine e = new Engine();
		e.setCc(1800);
		e.setType("diesel");
		
		Car c= new Car();
		c.setBrand("Mercedes");
		c.setModel("benz");
		c.setEngine(e);
		c.setRegisteredDate(LocalDate.of(year, month, day));
		
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
		
		
	}
	
	
	public static void findCarById(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Car c = em.find(Car.class, id);
		System.out.println(c.getCid());
		System.out.println(c.getBrand());
		System.out.println(c.getModel());
		System.out.println(c.getRegisteredDate());
		et.commit();
	}
	
	
	public static void findCar(LocalDate date)// perfect method
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
	 
		Car c= new Car();
		 
		c.setEngine(e);
		
		String s ="Select s from Car s where s.registeredDate=?1";//jpql query
		Query q = em.createQuery(s);
	
		et.begin();
		q.setParameter(1, date);
		List<Car> li = q.getResultList();
		li.forEach(al->System.out.println(al));
//		c.setRegisteredDate(LocalDate.of(year, month, day));
		et.commit();
	}
	
	
	
	public static void allocateEngine(int cid , int eid)// perfect method to change engine id from car
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql ="Update Cars_table  set engine_engine_id=?1 where car_id=?2 "; //here jpql query is not supporting
																  // bcaz of object type of engine
		// we are passing integer data to object which is not possible Hence we go for native query/sql query
		
		//Query q = em.createQuery(s);
		Query q = em.createNativeQuery(sql,Car.class);
		et.begin();
		q.setParameter(1, eid);
		q.setParameter(2, cid);
		int count =q.executeUpdate();
		System.out.println(count);
		et.commit();
		
	}
	
	
	public static void deallocateEngine(int cid)// perfect method
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql ="Update Car  set engine=?1 where cid=?2 ";
		Query query = em.createQuery(jpql);
		et.begin();
		query.setParameter(1, null);
		query.setParameter(2, cid);
		int count =query.executeUpdate();
		System.out.println(count);
		et.commit();
	}
	
	
	public static void deleteCar(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		 et.begin();
		 Car	c=em.find(Car.class, id);
		 em.remove(c);
		 et.commit();
	}
	
	
	
	
	public static void carDetails()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		String jpql="Select s from Car s ";
		Query q = em.createQuery(jpql);
	List<Car> li = q.getResultList();
	li.forEach(al->System.out.println(al));// lambda expression
	et.commit();
	}
}
