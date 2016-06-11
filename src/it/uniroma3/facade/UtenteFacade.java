package it.uniroma3.facade;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;



import it.uniroma3.model.Utente;

@Stateless
public class UtenteFacade {

	
    @PersistenceContext(unitName="controller-unit")
    private EntityManager em;
    
	public Utente inserisciUtente(String username, String password, int ruolo) {
		Utente utente = new Utente(username,password,ruolo);
		em.persist(utente);
		return utente;
		}

	public Utente getUtente(String username) {
		Utente utente = new Utente();
		utente = em.find(Utente.class, username);
		return utente;

	}
}
