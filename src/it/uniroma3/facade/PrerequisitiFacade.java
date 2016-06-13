package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Prerequisiti;
import it.uniroma3.model.TipologiaDiEsame;

@Stateless
public class PrerequisitiFacade {

	@PersistenceContext(unitName="controller-unit")
	private EntityManager em;

	public Prerequisiti createPrerequisiti(String prerequisiti,String descrizione ,TipologiaDiEsame tipologia) {
		Prerequisiti p = new Prerequisiti(prerequisiti,descrizione,tipologia);
		em.persist(p);
		return p;
	}
	public List<Prerequisiti> findAll() {
		CriteriaQuery<Prerequisiti> cq = em.getCriteriaBuilder().createQuery(Prerequisiti.class);
		cq.select(cq.from(Prerequisiti.class));
		List<Prerequisiti> prerequisiti = em.createQuery(cq).getResultList();
		return prerequisiti;
	}
	public List<Prerequisiti> findPT(Long codice) {
		Query q = em.createQuery("select t from Prerequisiti t where tipologia_codice = ? ");
		q.setParameter(1, codice);
		return q.getResultList();
	}
	public Prerequisiti getPrerequisiti(Long id) {
		return em.find(Prerequisiti.class, id);
	}
}
