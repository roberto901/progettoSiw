package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Risultati;
import it.uniroma3.model.TipologiaDiEsame;
import it.uniroma3.model.Utente;

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
	public List<Esame> findPerPaziente(Paziente paziente) {
		Query q = em.createQuery("select t from Esame t where t.paziente = ?1 ");
		q.setParameter(1, paziente);
		return q.getResultList();
	}
	public Esame createEsame(TipologiaDiEsame tipologia,Date dataPrenotazione, Date dataEsame, Paziente paziente,Medico medico){
		Esame esame = new Esame(tipologia,dataPrenotazione,dataEsame,paziente,medico);
		em.persist(tipologia);
		return esame;
	}
	public Esame getEsame(Long codice){
		Query q = em.createQuery("select e from Esame e where e.id = ?1");
		q.setParameter(1, codice);
		return (Esame)q.getResultList().get(0);
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
	public List<Risultati> findRisultati(Esame esame) {
		Query q = em.createQuery("select t from Risultati t where t.esame = ?1 ");
		q.setParameter(1, esame);
		return (List<Risultati>)q.getResultList();
	}
	public Esame findEsame(Esame esame) {
		Query q = em.createQuery("select e from Esame e where e.id = ?1 ");
		q.setParameter(1,esame.getId());
		List<Esame> esami = q.getResultList();
		return esami.get(0);
	}

}

