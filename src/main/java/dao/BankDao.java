package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.BankAccount;

public class BankDao {
	
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	public void insert(BankAccount account){
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
	}

	public  List< BankAccount> fetchAll() {
		
		return entityManager.createQuery("select x from BankAccount x").getResultList();
	}
	public  BankAccount find(long acno)
	{
		return entityManager.find(BankAccount.class, acno);
		
	}
	public void update(BankAccount account)
	{

		
		entityTransaction.begin();
		entityManager.merge(account);
		entityTransaction.commit();
	
	}
	}


