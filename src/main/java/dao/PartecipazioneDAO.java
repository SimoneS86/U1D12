package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Partecipazione;

public class PartecipazioneDAO {
	private static final Logger logger = LoggerFactory.getLogger(PartecipazioneDAO.class);
	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione partecipazione) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(partecipazione);
			transaction.commit();
			logger.info("Partecipazione salvata correttamente: " + partecipazione);
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			logger.error("Errore durante il salvataggio della partecipazione.", e);
			throw e;
		}
	}

	public Partecipazione getById(Long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}

	public void delete(Partecipazione partecipazione) {
		if (partecipazione != null) {
			EntityTransaction transaction = em.getTransaction();
			try {
				transaction.begin();
				em.remove(partecipazione);
				transaction.commit();
				logger.info("Partecipazione eliminata correttamente: " + partecipazione);
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				logger.error("Errore durante l'eliminazione della partecipazione.", e);
				throw e;
			}
		}
	}

	public void refresh(Partecipazione partecipazione) {
		if (partecipazione != null) {
			logger.info("Partecipazione aggiornata:" + partecipazione);
			em.refresh(partecipazione);
			logger.info("Partecipazione recuperata correttamente:" + partecipazione);
		}
	}
}
