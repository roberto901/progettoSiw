package it.uniroma3.controller;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Utente;



@ManagedBean
public class LoginController  {
	
	@EJB
	private UtenteFacade utenteFacade;
	
	@ManagedProperty(value="#{param.username}")
	
	private String username;	 
	private String password;
	private int ruolo;
	
	
	
	
	private final static String successo = "risorsaProtetta.xhtml";
	private final static String fallimento = "fallimento.xhtml";
	
	public int getRuolo() {
		return ruolo;
	}
	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
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
	
	

	
	public String login(){
		Utente utente = utenteFacade.getUtente(username);
		if(utente!=null && utente.getPassword().equals(password))
			return successo;
		else
			return fallimento;

	
	}
}


