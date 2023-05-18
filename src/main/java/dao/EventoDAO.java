package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Concerto;
import entities.Concerto.Genere;
import entities.Evento;

public class EventoDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);
	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
		try {
			TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming",
					Concerto.class);
			query.setParameter("inStreaming", inStreaming);
			return query.getResultList();
		} catch (Exception e) {
			logger.error("Errore durante il recupero dei concerti in streaming.", e);
			throw e;
		}
	}

	public List<Concerto> getConcertiPerGenere(Genere generi) {
		try {
			TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere IN :generi",
					Concerto.class);
			query.setParameter("generi", generi);
			return query.getResultList();
		} catch (Exception e) {
			logger.error("Errore durante il recupero dei concerti per genere.", e);
			throw e;
		}
	}

	public void save(Evento event) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(event);
			transaction.commit();
			logger.info("Evento salvato correttamente: " + event);
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			logger.error("Errore durante il salvataggio dell'evento.", e);
			throw e;
		}
	}

	public Evento getById(Long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}

	public void delete(Evento event) {
		if (event != null) {
			EntityTransaction transaction = em.getTransaction();
			try {
				transaction.begin();
				em.remove(event);
				transaction.commit();
				logger.info("Evento eliminato correttamente: " + event);
			} catch (Exception e) {
				if (transaction.isActive()) {
					transaction.rollback();
				}
				logger.error("Errore durante l'eliminazione dell'evento.", e);
				throw e;
			}
		}
	}

	public void refresh(Evento event) {
		if (event != null) {
			logger.info("Evento aggiornato:" + event);
			em.refresh(event);
			logger.info("Evento recuperato correttamente:" + event);
		}
	}
}
