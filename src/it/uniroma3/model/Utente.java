package it.uniroma3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente")
public class Utente implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
private String username;
@Column(nullable=false)
private String password;
@Column(nullable=false)
private int ruolo;

public Utente() {}

public Utente(String username, String password, int ruolo) {
	this.username = username;
	this.password = password;
	this.ruolo = ruolo;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ruolo;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	Utente other = (Utente) obj;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (ruolo != other.ruolo)
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getRuolo() {
	return ruolo;
}

public void setRuolo(int ruolo) {
	this.ruolo = ruolo;
}
}
