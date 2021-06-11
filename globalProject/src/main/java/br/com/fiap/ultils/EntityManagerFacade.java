package br.com.fiap.ultils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFacade {
	private static final String GLOBALPROJECT_PERSISTENCE_UNIT = "globalProject-persistence-unit";

	public static EntityManager getEntityManager() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(GLOBALPROJECT_PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		
		return manager;
	}
}
