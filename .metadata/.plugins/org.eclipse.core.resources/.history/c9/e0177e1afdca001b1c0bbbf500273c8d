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


}
