package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("GARA_ATLETICA")
@Getter
@Setter
@NoArgsConstructor
public class GaraDiAtletica extends Evento {
	@ManyToMany
	@JoinTable(name = "gara_atletica_atleti", joinColumns = @JoinColumn(name = "gara_atletica_id"), inverseJoinColumns = @JoinColumn(name = "atleta_id"))
	private Set<Persona> atleti = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "vincitore_id")
	private Persona vincitore;

	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.atleti = atleti;
		this.vincitore = vincitore;
	}

	public void addAtleta(Persona atleta) {
		atleti.add(atleta);
	}

	public void removeAtleta(Persona atleta) {
		atleti.remove(atleta);
	}

	@Override
	public String toString() {
		return super.toString() + " [atleti=" + atleti + ", vincitore=" + vincitore + "]";
	}
}
