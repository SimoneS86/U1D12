package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Evento;
import entities.Evento.TipoEvento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import util.JpaUtil;

public class GestioneEventi {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		PersonaDAO personaDAO = new PersonaDAO(em);
		LocationDAO locationDAO = new LocationDAO(em);
		EventoDAO eventoDAO = new EventoDAO(em);
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

		Persona persona = new Persona("Ajeje", "Brazolf", "ajeje.brazolf@example.com", LocalDate.of(1990, 5, 10),
				Persona.Sesso.MASCHIO);
		personaDAO.save(persona);

		Location location = new Location("Il paradiso della brucola", "Milano");
		locationDAO.save(location);

		Evento evento = new Evento();
		evento.setTitolo("Tutto sulla ferramenta");
		evento.setDataEvento(LocalDate.of(2023, 7, 25));
		evento.setDescrizione("Una conferenza sulle brucole");
		evento.setTipoEvento(TipoEvento.PRIVATO);
		evento.setNumeroMassimoPartecipanti(50);
		evento.setLocation(location);
		eventoDAO.save(evento);

		Partecipazione partecipazione = new Partecipazione(persona, evento,
				Partecipazione.StatoPartecipazione.DA_CONFERMARE);
		partecipazioneDAO.save(partecipazione);

		em.close();
		emf.close();

	}

}
