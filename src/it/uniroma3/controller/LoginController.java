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




	private final static String successo_amministratore = "risorsaProtettaA.xhtml";
	private final static String fallimento = "fallimento.xhtml";
	private final static String successo_paziente = "risorsaProtettaP.xhtml";

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
		if(utente!=null){
			if(utente.getPassword().equals(password) && utente.getRuolo() == 1)
				return successo_amministratore;
			if (utente.getPassword().equals(password) && utente.getRuolo() == 2)
				return successo_paziente;
		}
		return fallimento;
	}
}


