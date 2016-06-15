package it.uniroma3.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import it.uniroma3.facade.EsameFacade;
import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Esame;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Paziente;
import it.uniroma3.model.Risultati;
import it.uniroma3.model.TipologiaDiEsame;
import it.uniroma3.model.Utente;

@ManagedBean
public class EsameController {
@EJB
private EsameFacade esameFacade;
@EJB
private UtenteFacade utenteFacade;
@EJB
private Risultati risultato;
private List<Risultati> risultati;
private String nomeRes;
private String valoreRes;
private TipologiaDiEsame tipologia;
private Medico medico;
private Date dataPrenotazione;
private Date dataEsameEffettuato;
private Paziente paziente;
private Esame esame;
private List<Esame> esami;
private List<TipologiaDiEsame> tipologie;
private List<Paziente> pazienti;

public List<TipologiaDiEsame> getTipologie() {
	return tipologie;
}
public void setTipologie(List<TipologiaDiEsame> tipologie) {
	this.tipologie = tipologie;
}
public List<Paziente> getPazienti() {
	return pazienti;
}
public void setPazienti(List<Paziente> pazienti) {
	this.pazienti = pazienti;
}
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
public String getNomeRes() {
	return nomeRes;
}
public void setNomeRes(String nomeRes) {
	this.nomeRes = nomeRes;
}
public String getValoreRes() {
	return valoreRes;
}
public void setValoreRes(String valoreRes) {
	this.valoreRes = valoreRes;
}
public Esame getEsame() {
	return esame;
}
public void setEsame(Esame esame) {
	this.esame = esame;
}
public List<Esame> getEsami() {
	return esami;
}
public void setEsami(List<Esame> esami) {
	this.esami = esami;
}
public Risultati getRisultato() {
	return risultato;
}
public void setRisultato(Risultati risultato) {
	this.risultato = risultato;
}
public List<Risultati> getRisultati() {
	return risultati;
}
public void setRisultati(List<Risultati> risultati) {
	this.risultati = risultati;
}
public String visualizzaEsame() {
	String codiceEsame = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("esame");		
	this.esame = esameFacade.getEsame(Long.parseLong(codiceEsame));
	this.risultati = esameFacade.findRisultati(esame);
	return "dettagliEsame.xhtml";
}
public String visualizzaEsame(Esame esame) {
	this.esame = esame;
	this.risultati = esameFacade.findRisultati(esame);
	return "dettagliEsame.xhtml";
}
public String pazienteCorrente(Paziente p){
	this.paziente=p;
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("paziente",paziente);
	return "creaEsame";
}

public String tuttiPazienti(){
	this.pazienti=this.utenteFacade.findAllPazienti();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pazienti",pazienti);
	return "creaEsame.xhtml";
}

public String scegliPaziente(){
	this.pazienti=this.utenteFacade.findAllPazienti();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pazienti",pazienti);
	return "pazienti.xhtml";
}
public String tipologiaCorrente(TipologiaDiEsame t){
	this.tipologia=t;
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipologia",tipologia);
	System.out.println(tipologia);
	return "creaEsame";
}

public String scegliTipologia(){
	this.tipologie=this.esameFacade.findAllTipologie();
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tipologie",tipologie);
	return "tipologie.xhtml";
}
public String create(){
	this.tipologia=(TipologiaDiEsame)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tipologia");
	this.paziente=(Paziente)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("paziente");
	Calendar calendar = Calendar.getInstance();
	this.dataPrenotazione = new Date(calendar.getTime().getTime());
	this.esame= this.esameFacade.createEsame(tipologia,dataPrenotazione, 
												dataEsameEffettuato, paziente);
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("esame",esame);
	return "risorsaProtettaA.xhtml";
}
}
