package br.com.fiap.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.User;
import br.com.fiap.ultils.EntityManagerFacade;

public class UserDAO {
	
	public void save(User user) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		manager.close();
		
	}


	public List<User> getAll() {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		return query.getResultList();
	}


	public User findById(Long id) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		return manager.find(User.class, id);
	}


	public void update(User user) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(user);
		manager.flush();
		manager.getTransaction().commit();
		
		manager.close();
		
	}


	public boolean exist(User user) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		TypedQuery<User> query = manager.createQuery("Select u From User u WHERE "
				+ "u.email = :email AND "
				+ "u.password = :password",User.class);
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		
		System.out.println("--->>>> User:"+user.getEmail()+"\n senha:"+ user.getPassword());
		
		try {
			query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
		
		
	}


}
