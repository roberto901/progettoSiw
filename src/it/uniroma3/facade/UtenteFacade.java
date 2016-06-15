package it.uniroma3.facade;
import javax.persistence.EntityManager;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.model.Amministrazione;
import it.uniroma3.model.Paziente;
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
	public Paziente findPaziente(Utente utente) {
		Query q = em.createQuery("select p from Paziente p where p.utente = ?1");
		q.setParameter(1, utente);
		List<Paziente> paziente = q.getResultList();
		return paziente.get(0);

	}

	public Amministrazione findAmministrazione(Utente utente) {
		Query q = em.createQuery("select a from Amministrazione a where a.utente = ?1");
		q.setParameter(1, utente);
		List<Amministrazione> aa = q.getResultList();
		return aa.get(0);
	}
}
