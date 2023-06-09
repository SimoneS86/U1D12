package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor

public class Location {
	@Id
	@GeneratedValue(generator = "location_seq")
	@SequenceGenerator(name = "location_seq", sequenceName = "location_seq", allocationSize = 1)
	private Long id;
	private String nome;
	private String citta;

	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private Set<Evento> eventi = new HashSet<>();

	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}
}
