package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("PARTITA_CALCIO")
public class PartitaDiCalcio extends Evento {
	@Column(name = "squadra_casa")
	private String squadraCasa;

	@Column(name = "squadra_ospite")
	private String squadraOspite;

	@Column(name = "squadra_vincente")
	private String squadraVincente;

	@Column(name = "numero_gol_casa")
	private int numeroGolCasa;

	@Column(name = "numero_gol_ospite")
	private int numeroGolOspite;

	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, String squadraCasa, String squadraOspite,
			String squadraVincente, int numeroGolCasa, int numeroGolOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.numeroGolCasa = numeroGolCasa;
		this.numeroGolOspite = numeroGolOspite;
	}

	@Override
	public String toString() {
		return super.toString() + "[squadraCasa=" + squadraCasa + ", squadraOspite=" + squadraOspite
				+ ", squadraVincente=" + squadraVincente + ", numeroGolCasa=" + numeroGolCasa + ", numeroGolOspite="
				+ numeroGolOspite + "]";
	}
}
