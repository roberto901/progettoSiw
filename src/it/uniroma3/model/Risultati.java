package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Risultati {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column 
	private String nome;
	
	@Column 
	private String valore;
	
	@ManyToOne
	private Esame esame;
	
	public Risultati() {}
	public Risultati(String nome,String valore,Esame esame) {
		this.nome=nome;
		this.valore=valore;
		this.esame=esame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}
}
