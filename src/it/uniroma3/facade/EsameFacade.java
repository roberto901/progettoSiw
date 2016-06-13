package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaDiEsame;

@Stateless
public class EsameFacade {
	
	@PersistenceContext(unitName="controller-unit" )
	private EntityManager em;
	
	public List<Esame>  findAll(){
		CriteriaQuery<Esame> cq = em.getCriteriaBuilder().createQuery(Esame.class);
		cq.select(cq.from(Esame.class));
		List<Esame> esami = em.createQuery(cq).getResultList();
		return esami;
	}
	
	
	public Esame createEsame(TipologiaDiEsame tipologia,Date dataPrenotazione, Date dataEsame, Paziente paziente,Medico medico){
		Esame esame = new Esame(tipologia,dataPrenotazione,dataEsame,paziente,medico);
		em.persist(tipologia);
		return esame;
	}
	public Esame getTipologia(Long codice){
		return em.find(Esame.class, codice);
	}

	public void updateEsame(Esame esame){
		em.merge(esame);
	}


	private void deleteEsame(Esame esame) {
		em.remove(esame);
	}

	public void deleteEsame(Long codice) {
		Esame tipologia = em.find(Esame.class, codice);
		deleteEsame(tipologia);
	}
}

