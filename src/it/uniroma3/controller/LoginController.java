package it.uniroma3.controller;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.EsameFacade;
import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Utente;



@ManagedBean
public class LoginController  {

	@EJB
	private UtenteFacade utenteFacade;
	@EJB
	private EsameFacade esameFacade;

	@ManagedProperty(value="#{param.username}")

	private String username;	 
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public List<Esame> getEsami() {
		return esami;
	}
	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	private String password;
	private int ruolo;
	private Paziente paziente;
	private Utente utente;
	private List<Esame> esami;
	private Esame esame;



	public Esame getEsame() {
		return esame;
	}
	public void setEsame(Esame esame) {
		this.esame = esame;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

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
			if (utente.getPassword().equals(password) && utente.getRuolo() == 2) {
				this.paziente = utenteFacade.findPaziente(utente);
				this.esami = this.esameFacade.findPerPaziente(this.paziente);
				return successo_paziente;
			}
		}
		return fallimento;
	}
}


