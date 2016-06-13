package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.uniroma3.facade.EsameFacade;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.TipologiaDiEsame;

@ManagedBean
public class EsameController {
@EJB
private EsameFacade esameFacade;


private TipologiaDiEsame tipologia;
private Medico medico;
private Date dataPrenotazione;
private Date dataEsameEffettuato;
private Paziente paziente;
private Esame esame;
private List<Esame> esami;

public TipologiaDiEsame getTipologia() {
	return tipologia;
}
public void setTipologia(TipologiaDiEsame tipologia) {
	this.tipologia = tipologia;
}
public Medico getMedico() {
	return medico;
}
public void setMedico(Medico medico) {
	this.medico = medico;
}
public Date getDataPrenotazione() {
	return dataPrenotazione;
}
public void setDataPrenotazione(Date dataPrenotazione) {
	this.dataPrenotazione = dataPrenotazione;
}
public Date getDataEsameEffettuato() {
	return dataEsameEffettuato;
}
public void setDataEsameEffettuato(Date dataEsameEffettuato) {
	this.dataEsameEffettuato = dataEsameEffettuato;
}
public Paziente getPaziente() {
	return paziente;
}
public void setPaziente(Paziente paziente) {
	this.paziente = paziente;
}
public String dettagli() {
	this.esami = this.esameFacade.findPerPaziente(paziente);
	return "dettagliEsame.xhtml";
}
}
