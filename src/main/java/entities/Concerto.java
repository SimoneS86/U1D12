package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("CONCERTO")
@Getter
@Setter
@NoArgsConstructor
public class Concerto extends Evento {
	@Enumerated(EnumType.STRING)
	private Genere genere;

	@Column(name = "in_streaming")
	private boolean inStreaming;

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public enum Genere {
		CLASSICO, ROCK, POP
	}

	@Override
	public String toString() {
		return super.toString() + " [genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}
}
