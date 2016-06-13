package it.uniroma3.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Prerequisiti implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

@ManyToOne
private TipologiaDiEsame Tipologia;

@Column (nullable = false)
private String prerequisiti;

@Column(nullable=false)
private String descrizionePrerequisiti;

public Prerequisiti() {}

public Prerequisiti(String prerequisiti,String descrizionePrerequisiti, TipologiaDiEsame tipologia) {
	this.prerequisiti = prerequisiti;
	this.descrizionePrerequisiti = descrizionePrerequisiti;
	this.Tipologia = tipologia;
	}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
public TipologiaDiEsame getTipologia() {
	return Tipologia;
}
public void setTipologia(TipologiaDiEsame tipologia) {
	Tipologia = tipologia;
}
public String getPrerequisiti() {
	return prerequisiti;
}

public void setPrerequisiti(String prerequisiti) {
	this.prerequisiti = prerequisiti;
}

public String getDescrizionePrerequisiti() {
	return descrizionePrerequisiti;
}

public void setDescrizionePrerequisiti(String descrizionePrerequisiti) {
	this.descrizionePrerequisiti = descrizionePrerequisiti;
}

}
