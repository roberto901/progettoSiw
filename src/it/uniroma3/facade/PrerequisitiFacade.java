package it.uniroma3.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Prerequisiti;

@Stateless
public class PrerequisitiFacade {

	@PersistenceContext(unitName="controller-unit")
	private EntityManager em;

	public Prerequisiti createPrerequisiti(String tipologia, String prerequisiti,String descrizione) {
		Prerequisiti p = new Prerequisiti(tipologia,prerequisiti,descrizione);
		em.persist(p);
		return p;
	}
	public List<Prerequisiti> findAll() {
		CriteriaQuery<Prerequisiti> cq = em.getCriteriaBuilder().createQuery(Prerequisiti.class);
		cq.select(cq.from(Prerequisiti.class));
		List<Prerequisiti> prerequisiti = em.createQuery(cq).getResultList();
		return prerequisiti;

	}
}
