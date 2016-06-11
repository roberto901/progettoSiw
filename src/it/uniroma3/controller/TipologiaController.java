package it.uniroma3.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.DAO.TipologiaDAO;
import it.uniroma3.model.TipologiaDiEsame;

@ManagedBean
public class TipologiaController  {


	@EJB
	private TipologiaDAO tipologiaDAO;

	private final static String EDIT_TIPOLOGIA = "creaTipologia.xhtml";
	private final static String LIST_TIPOLOGIE = "home.xhtml";
	
	@ManagedProperty(value="#{param.codice}")
	private Long codice;
	private String nome;
	private String descrizione;
	private Double prezzo;
	private TipologiaDiEsame tipologia;
	private List<TipologiaDiEsame> tipologie;

	

	public String create() {
		this.tipologia = this.tipologiaDAO.createTipologia(nome, prezzo, descrizione);
		return EDIT_TIPOLOGIA;
	}

	public String edit() {
		this.tipologiaDAO.updateTipologia(this.tipologia);
		return EDIT_TIPOLOGIA;
	}
	
	public String listTipologie() {
			this.tipologie = tipologiaDAO.findAll();
		return "home.xhtml";
	}


	//	public String save() {
	//		tipologiaDAO.createTipologia(nome, prezzo, descrizione)(tipologia);
	//		return LIST_TIPOLOGIE;
	//	}

	public String delete() {
		tipologiaDAO.deleteProduct(getCodice());
		return LIST_TIPOLOGIE;
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
	
	

}
