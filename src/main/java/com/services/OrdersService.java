package com.services;

import java.util.ArrayList;
import java.util.List;


import com.model.Orders;
import com.model.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrdersService  {

	
	public void addNewEntry(int order_id, String order_date, int product_id, int user_id, int order_quantity) { 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("retail");
		EntityManager em = emf.createEntityManager();
		System.out.println(order_id+"-"+order_date+"-"+product_id+"-"+user_id+"-"+order_quantity);
		em.getTransaction().begin();

		// Create a new Entry in Orders Table
		Products product = new Products();//TODO: SELECT PRODUCT FROM THE POOL OF PRODUCTS IN THE DATABASE
		Orders order = new Orders(order_id, order_date,product.getProduct_id(), user_id, order_quantity);
		
		//Persist data in table
		em.persist(order);
		em.getTransaction().commit();
		
		// Close Managers
      	emf.close();
      	em.close();
		
	}

}
