package it.uniroma3.facade;

import it.uniroma3.model.Utente;

public class facadeAutenticazioneImpl implements facadeAutenticazione {

	
	public Utente login(String username, String password) {
		UtenteFacade utente = new UtenteFacade();
		return utente.getUtente(username);
	}
}
