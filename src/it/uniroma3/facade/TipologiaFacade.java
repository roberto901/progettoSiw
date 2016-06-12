package it.uniroma3.facade;

import it.uniroma3.model.Prerequisiti;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import it.uniroma3.model.TipologiaDiEsame;

@Stateless
public class TipologiaFacade    {



	@PersistenceContext(unitName="controller-unit" )
	private EntityManager em;

	public List<TipologiaDiEsame>  findAll(){
		CriteriaQuery<TipologiaDiEsame> cq = em.getCriteriaBuilder().createQuery(TipologiaDiEsame.class);
		cq.select(cq.from(TipologiaDiEsame.class));
		List<TipologiaDiEsame> tipologie = em.createQuery(cq).getResultList();
		return tipologie;
	}

	public TipologiaDiEsame createTipologia(String nome,Double prezzo,String descrizione){
		TipologiaDiEsame tipologia = new TipologiaDiEsame(nome, prezzo, descrizione);
		em.persist(tipologia);
		return tipologia;
	}

	public TipologiaDiEsame getTipologia(Long codice){
		Query query = em.createNamedQuery("SELECT * from tipologiadiesame where codice = ?");
		query.setParameter(1, codice);
		return (TipologiaDiEsame) query.getSingleResult();
	}

	public void updateTipologia(TipologiaDiEsame tipologia){
		em.merge(tipologia);
	}


	private void deleteTipologia(TipologiaDiEsame tipologia) {
		em.remove(tipologia);
	}

	public void deleteProduct(Long codice) {
		TipologiaDiEsame tipologia = em.find(TipologiaDiEsame.class, codice);
		deleteTipologia(tipologia);
	}

}
