package com.services;

import java.util.ArrayList;
import java.util.List;

import com.model.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductsServices {

	private static ProductsServices productsServices = new ProductsServices();
	private ProductsServices() {}
	public static ProductsServices getInstance() {
		return productsServices;
	}
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("retail");
	EntityManager em = emf.createEntityManager();

	public ArrayList<Products> getProductList() {

		// Retrieve all products from products table
		List<Object[]> resultList = em.createNativeQuery("SELECT * FROM products").getResultList();
		ArrayList<Products> productList = new ArrayList<Products>();
		for (Object[] result : resultList) {
			Products product = new Products();
			product.setProduct_name(result[0].toString());
			product.setProduct_name(result[1].toString());
			product.setProduct_price(Double.parseDouble(result[2].toString()));
			productList.add(product);
		}

		return productList;
	}

	public void addNewProduct(Products product) {

		em.getTransaction().begin();
		em.persist(product);
		
		// Persist data in table
		em.getTransaction().commit();

		// Close Managers
		emf.close();
		em.close();

	}
}
