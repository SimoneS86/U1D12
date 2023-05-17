package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Location;

public class LocationDAO {
	private static final Logger logger = LoggerFactory.getLogger(LocationDAO.class);
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location location) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(location);
			transaction.commit();
			logger.info("Location salvata correttamente: " + location);
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			logger.error("Errore durante il salvataggio della location.", e);
			throw e;
		}
	}

	public Location getById(Long id) {
		Location found = em.find(Location.class, id);
		return found;
	}

	public void delete(Location location) {
		if (location != null) {
			EntityTransaction transaction = em.getTransaction();
			try {
				transaction.begin();
				em.remove(location);
				transaction.commit();
				logger.info("Location eliminata correttamente: " + location);
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				logger.error("Errore durante l'eliminazione della location.", e);
				throw e;
			}
		}
	}

	public void refresh(Location location) {
		if (location != null) {
			logger.info("Location aggiornata:" + location);
			em.refresh(location);
			logger.info("Location recuperata correttamente:" + location);
		}
	}
}
