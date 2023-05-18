package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import entities.Concerto;
import util.JpaUtil;

public class GestioneEventi {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		EventoDAO eventoDAO = new EventoDAO(em);
//		PersonaDAO personaDAO = new PersonaDAO(em);
//		LocationDAO locationDAO = new LocationDAO(em);
//		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
//
//		Persona persona1 = new Persona("John", "Doe", "john.doe@example.com", LocalDate.of(1990, 5, 10), Sesso.MASCHIO);
//		Persona persona2 = new Persona("Alice", "Smith", "alice.smith@example.com", LocalDate.of(1992, 8, 20),
//				Sesso.FEMMINA);
//		Persona persona3 = new Persona("Robert", "Johnson", "robert.johnson@example.com", LocalDate.of(1985, 3, 15),
//				Sesso.MASCHIO);
//		Persona persona4 = new Persona("Emily", "Brown", "emily.brown@example.com", LocalDate.of(1998, 11, 28),
//				Sesso.FEMMINA);
//		Persona persona5 = new Persona("Michael", "Davis", "michael.davis@example.com", LocalDate.of(1994, 9, 7),
//				Sesso.MASCHIO);
//
//		personaDAO.save(persona1);
//		personaDAO.save(persona2);
//		personaDAO.save(persona3);
//		personaDAO.save(persona4);
//		personaDAO.save(persona5);
//
//		Location location1 = new Location("Grand Ballroom", "New York City");
//		Location location2 = new Location("Harbor View Convention Center", "San Francisco");
//		Location location3 = new Location("Garden Pavilion", "London");
//
//		locationDAO.save(location1);
//		locationDAO.save(location2);
//		locationDAO.save(location3);
//
//		Set<Persona> atleti = new HashSet<>();
//		atleti.add(persona1);
//		atleti.add(persona2);
//		atleti.add(persona3);
//
//		GaraDiAtletica garaDiAtletica = new GaraDiAtletica("Marathon Race", LocalDate.of(2024, 9, 20),
//				"Annual marathon race", TipoEvento.PUBBLICO, 100, location1, atleti, persona1);
//		eventoDAO.save(garaDiAtletica);
//
//		PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio("Football Match", LocalDate.of(2024, 8, 10),
//				"A thrilling football match", TipoEvento.PUBBLICO, 200, location2, "Italia", "Marocco", "Marocco W", 3,
//				2);
//		eventoDAO.save(partitaDiCalcio);
//
//		Concerto concerto = new Concerto("Live Concert", LocalDate.of(2023, 9, 5), "Amazing live performance",
//				TipoEvento.PUBBLICO, 500, location3, Concerto.Genere.ROCK, true);
//		eventoDAO.save(concerto);
//
//		Partecipazione partecipazione1Gara = new Partecipazione(persona1, garaDiAtletica,
//				Partecipazione.StatoPartecipazione.CONFERMATA);
//		partecipazioneDAO.save(partecipazione1Gara);
//
//		Partecipazione partecipazione2Gara = new Partecipazione(persona2, garaDiAtletica,
//				Partecipazione.StatoPartecipazione.CONFERMATA);
//		partecipazioneDAO.save(partecipazione2Gara);
//
//		Partecipazione partecipazione3Gara = new Partecipazione(persona3, garaDiAtletica,
//				Partecipazione.StatoPartecipazione.CONFERMATA);
//		partecipazioneDAO.save(partecipazione3Gara);
//
//		Partecipazione partecipazioneCalcio = new Partecipazione(persona4, partitaDiCalcio,
//				Partecipazione.StatoPartecipazione.DA_CONFERMARE);
//		partecipazioneDAO.save(partecipazioneCalcio);
//
//		Partecipazione partecipazioneConcerto = new Partecipazione(persona1, concerto,
//				Partecipazione.StatoPartecipazione.CONFERMATA);
//		partecipazioneDAO.save(partecipazioneConcerto);

		System.out.println(eventoDAO.getConcertiInStreaming(false));
		System.out.println(eventoDAO.getConcertiPerGenere(Concerto.Genere.ROCK));

		em.close();
		emf.close();

	}

}
