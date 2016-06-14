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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Tipologia == null) ? 0 : Tipologia.hashCode());
	result = prime * result + ((descrizionePrerequisiti == null) ? 0 : descrizionePrerequisiti.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((prerequisiti == null) ? 0 : prerequisiti.hashCode());
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
	Prerequisiti other = (Prerequisiti) obj;
	if (Tipologia == null) {
		if (other.Tipologia != null)
			return false;
	} else if (!Tipologia.equals(other.Tipologia))
		return false;
	if (descrizionePrerequisiti == null) {
		if (other.descrizionePrerequisiti != null)
			return false;
	} else if (!descrizionePrerequisiti.equals(other.descrizionePrerequisiti))
		return false;
	if (id != other.id)
		return false;
	if (prerequisiti == null) {
		if (other.prerequisiti != null)
			return false;
	} else if (!prerequisiti.equals(other.prerequisiti))
		return false;
	return true;
}

@Override
public String toString() {
	return "Prerequisiti [id=" + id + ", Tipologia=" + Tipologia + ", prerequisiti=" + prerequisiti
			+ ", descrizionePrerequisiti=" + descrizionePrerequisiti + "]";
}

}
