package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.EventoDAO;
import entities.Evento;
import util.JpaUtil;

public class GestioneEventi {
	private static Logger logger = LoggerFactory.getLogger(GestioneEventi.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);

		// ************************ SAVE *********************
		logger.info("ESERCIZIO 1: SAVE");
		Evento event6 = new Evento("event6", LocalDate.now(), "bruttissimo", Evento.TipoEvento.PUBBLICO, 325);
		ed.save(event6);

		// ************************ GET BY ID *********************
		logger.info("ESERCIZIO 2: GET BY ID");
		logger.info(ed.getById((long) 4).toString());

		// ************************ DELETE *********************
		logger.info("ESERCIZIO 3: DELETE");
		Evento event1 = ed.getById((long) 7);
		ed.delete(event1);

		// ************************ REFRESH ********************
		logger.info("ESERCIZIO 4: REFRESH");
		Evento event2 = ed.getById((long) 6);
		event2.setTitolo("superEvent");
		ed.refresh(event2);

		em.close();
		emf.close();

	}

}
