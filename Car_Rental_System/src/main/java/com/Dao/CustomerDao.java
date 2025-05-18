package com.Dao;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Customer;
import com.entity.Engine;
public class CustomerDao 
{
	public static void addCustomer()
	{
		EntityManagerFactory	emf =Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer cs =new Customer();
 
		
		cs.setName("Sharad");
		cs.setEmail("sharad@gmail.com");
		cs.setStart(LocalDate.of(2025, 05, 20));
		cs.setEnd(LocalDate.of(2025, 05, 25));
		et.begin();
		em.persist(cs);
		et.commit();
	}
	
	
	public static void addCustomerOrCarOrEngine()
	{
		EntityManagerFactory	emf =Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e =new Engine();
		e.setType("petrol");
		e.setCc(1000);
		
		Car c=new Car();
		c.setBrand("BMW");
		c.setModel("2018");
		c.setRegisteredDate(LocalDate.now());
		c.setEngine(e);
		
		Customer cs =new Customer();
		cs.setName("Arafat");
		cs.setEmail("arafat@gmail.com");
		cs.setStart(LocalDate.of(2025, 05, 10));
		cs.setEnd(LocalDate.now());
		cs.setCar(c);
		
		
		et.begin();
		em.persist(e);
		em.persist(c);
		em.persist(cs);
		et.commit();
	}
	
	
	public static void allocateCar(int ctrid , int cid)// perfect method to change car id from customer
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql ="Update Customer_Table  set car_car_id=?1 where customer_id=?2 "; //here jpql query is not supporting
																  // bcaz of object type of engine
		// we are passing integer data to object which is not possible Hence we go for native query/sql query
		
		//Query q = em.createQuery(s);
		Query q = em.createNativeQuery(sql,Car.class);
		et.begin();
		q.setParameter(1, cid);
		q.setParameter(2, ctrid);
		int count =q.executeUpdate();
		System.out.println("count= "+count);
		et.commit();
		
	}
	
	
	public static void deallocateCar(int ctrid)// perfect method
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql ="Update Customer  set car=?1 where ctrid=?2 ";
		Query query = em.createQuery(jpql);
		et.begin();
		query.setParameter(1, null);
		query.setParameter(2, ctrid);
		int count =query.executeUpdate();
		System.out.println("count= "+	 count);
		et.commit();
	}
	
	public static void deleteCustomer(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Customer cs = em.find(Customer.class, id);
		em.remove(cs);
		et.commit();
	}
}
