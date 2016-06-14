package it.uniroma3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Utente utente;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(length = 2000)
	private String specializzazione;

	@OneToMany
	private List<Esame> esamiEffettuati;



	protected Medico() {
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getDescrizione() {
		return specializzazione;
	}



	public void setDescrizione(String descrizione) {
		this.specializzazione = descrizione;
	}



	public Medico(String nome, String cognome, String descrizione, Utente utente) {
		this.utente=utente;
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = descrizione;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Utente getUtente() {
		return utente;
	}



	public void setUtente(Utente utente) {
		this.utente = utente;
	}



	public String getSpecializzazione() {
		return specializzazione;
	}



	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((specializzazione == null) ? 0 : specializzazione.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (specializzazione == null) {
			if (other.specializzazione != null)
				return false;
		} else if (!specializzazione.equals(other.specializzazione))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Medico [nome=" + nome + ", cognome=" + cognome + ", descrizione=" + specializzazione + "]";
	}
}
