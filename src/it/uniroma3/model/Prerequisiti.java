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

@Column(nullable = false)
private String Tipologia;

@Column (nullable = false)
private String prerequisiti;

@Column(nullable=false)
private String descrizionePrerequisiti;

public Prerequisiti() {}
public Prerequisiti(String tipologia,String prerequisiti,String descrizionePrerequisiti) {
	this.prerequisiti = prerequisiti;
	this.Tipologia = tipologia;
	this.descrizionePrerequisiti = descrizionePrerequisiti;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getTipologia() {
	return Tipologia;
}

public void setTipologia(String tipologia) {
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
