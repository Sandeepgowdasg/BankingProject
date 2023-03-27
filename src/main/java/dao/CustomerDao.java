package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class CustomerDao {
	
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	
	
	public List<Customer> check(String email){
		return entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
		
	}
	public List<Customer> check(long mobile){
		return entityManager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mobile).getResultList();
		
	}
	
	
	
	public void insert(Customer customer){
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}
	public Customer login( int custid)
	{
		return entityManager.find(Customer.class, custid);
	}
	public void  update(Customer customer)
	{
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
	}
		
	

}
