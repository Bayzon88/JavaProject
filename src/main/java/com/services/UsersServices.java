package com.services;

import java.util.List;

import com.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsersServices {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("retail");
	EntityManager em = emf.createEntityManager();

	public Users getUserFromDatabase(String user_id, String user_password) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("retail");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		String sqlStatement = "SELECT user_id FROM users WHERE user_id = " + user_id + " AND user_password = "
				+ user_password;
		List newList = em.createQuery(sqlStatement).getResultList();
		System.out.println("this is the information");
		System.out.println(newList.get(0).toString());
		// Persist data in table

		em.getTransaction().commit();

		Users user = new Users();
		return user;

	}

	public int getUserIdRetrieved(String user_name) {

		// Get user id from the user name
		List<Object[]> users = em.createNativeQuery("SELECT * FROM users WHERE user_name = '" + user_name + "'")
				.getResultList();
		int user_id_retrieved = 0;
		for (Object[] user : users) {
			user_id_retrieved = Integer.valueOf(user[0].toString());
		}

		// Close Managers
		emf.close();
		em.close();
		return user_id_retrieved;

	}

}
