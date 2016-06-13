package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class TipologiaDiEsame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7580905596032624487L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codice;
	
	@Column
	private Long cod;

	@Column(nullable = false)
	private String nome;

	private Double prezzo;

	@Column(nullable = false)
	private String descrizione;

//	@OneToMany
//	private List<Prerequisiti> prerequisiti;


	public TipologiaDiEsame(){

	}


	public TipologiaDiEsame(Long codice, String nome, Double price, String description) {
		this.cod = codice;
		this.nome = nome;
		this.prezzo = price;
		this.descrizione = description;
//		this.prerequisiti = new ArrayList<Prerequisiti>();
	}

	public Long getCod() {
		return cod;
	}


	public void setCod(Long cod) {
		this.cod = cod;
	}


	public Long getCodice() {
		return codice;
	}

	public void setCodice(Long codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}




	public Double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



//	public List<Prerequisiti> getPrerequisiti() {
//		if (prerequisiti==null)
//			prerequisiti = new ArrayList<Prerequisiti>();
//		return prerequisiti;
//	}
//
//
//	public void setPrerequisiti(List<Prerequisiti> prerequisiti) {
//		this.prerequisiti = prerequisiti;
//	}


	@Override
	public String toString() {
		return "TipologiaDiEsame [codice=" + codice + ", nome=" + nome + ", price=" + prezzo + ", description="
				+ descrizione + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prezzo == null) ? 0 : prezzo.hashCode());
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
		TipologiaDiEsame other = (TipologiaDiEsame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prezzo == null) {
			if (other.prezzo != null)
				return false;
		} else if (!prezzo.equals(other.prezzo))
			return false;
		return true;
	}





}
