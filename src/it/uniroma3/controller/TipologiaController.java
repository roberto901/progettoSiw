package it.uniroma3.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.PrerequisitiFacade;
import it.uniroma3.facade.TipologiaFacade;
import it.uniroma3.model.Prerequisiti;
import it.uniroma3.model.TipologiaDiEsame;

@ManagedBean
public class TipologiaController  {


	@EJB
	private TipologiaFacade tipologiaDAO;
	@EJB
	private PrerequisitiFacade prerequisitiFacade;

	private final static String EDIT_TIPOLOGIA = "NuovaTipologia.xhtml";
	private final static String LIST_TIPOLOGIE = "home.xhtml";
	private final static String PREREQUISITI = "dettagliTipologia.xhtml";

	@ManagedProperty(value="#{param.codice}")
	private Long codice;
	private String descrizionePrerequisiti;
	private String prerequisito;
	private String nome;
	private String descrizione;
	private Double prezzo;
	private TipologiaDiEsame tipologia;
	private List<TipologiaDiEsame> tipologie;
	private List<Prerequisiti> prerequisiti;
	private Prerequisiti p;


	public String createP() {
		this.p = this.prerequisitiFacade.createPrerequisiti(prerequisito,descrizionePrerequisiti,tipologia);
		return "NuovoPrerequisito.xhtml";
	}
	public String createPR() {
		this.p = this.prerequisitiFacade.createPrerequisiti(prerequisito,descrizionePrerequisiti,tipologia);
		return "risorsaProtettaA.xhtml";
	}
	public String listPrerequisiti() {
		this.prerequisiti = prerequisitiFacade.findPT(tipologia.getCodice());
		return "dettagliTipologia.xhtml";
	}


	public String create() {
		this.tipologia = this.tipologiaDAO.createTipologia(nome, prezzo, descrizione, codice);
		return "NuovoPrerequisito.xhtml";
	}

	public String edit() {
		this.tipologiaDAO.updateTipologia(this.tipologia);
		return EDIT_TIPOLOGIA;
	}

	public String listTipologie() {
		this.tipologie = tipologiaDAO.findAll();
		return LIST_TIPOLOGIE;
	}


	//	public String save() {
	//		tipologiaDAO.createTipologia(nome, prezzo, descrizione)(tipologia);
	//		return LIST_TIPOLOGIE;
	//	}

	public String delete() {
		tipologiaDAO.deleteProduct(getCodice());
		return LIST_TIPOLOGIE;
	}
	public String visualizza(TipologiaDiEsame tipologia) {
		this.setTipologia(tipologia);

		return "dettagliTipologia.xhtml";

	}
	public Long getCodice() {
		return codice;
	}

	public void setCodice(Long codice) {
		this.codice = codice;
	}

	public TipologiaDiEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaDiEsame tipologia) {
		this.tipologia = tipologia;
	}

	public List<TipologiaDiEsame> getTipologie() {
		return tipologie;
	}

	public void setTipologie(List<TipologiaDiEsame> tipologie) {
		this.tipologie = tipologie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public List<Prerequisiti> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisiti> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public String getPrerequisito() {
		return prerequisito;
	}

	public void setPrerequisito(String prerequisito) {
		this.prerequisito = prerequisito;
	}

	public String getDescrizionePrerequisiti() {
		return descrizionePrerequisiti;
	}

	public void setDescrizionePrerequisiti(String descrizionePrerequisiti) {
		this.descrizionePrerequisiti = descrizionePrerequisiti;
	}

	public Prerequisiti getP() {
		return p;
	}

	public void setP(Prerequisiti p) {
		this.p = p;
	}
}
