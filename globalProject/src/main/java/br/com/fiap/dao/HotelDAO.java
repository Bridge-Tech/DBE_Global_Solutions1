package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Hotel;
import br.com.fiap.ultils.EntityManagerFacade;

public class HotelDAO {
	public void save(Hotel hotel) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(hotel);
		manager.getTransaction().commit();
		
		manager.close();
		
	}


	public List<Hotel> getAll() {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		String jpql = "SELECT h FROM Hotel h";
		TypedQuery<Hotel> query = manager.createQuery(jpql, Hotel.class);
		return query.getResultList();
	}


	public Hotel findById(Long id) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		return manager.find(Hotel.class, id);
	}


	public void update(Hotel hotel) {
		EntityManager manager = EntityManagerFacade.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(hotel);
		manager.flush();
		manager.getTransaction().commit();
		
		manager.close();
		
	}
}
