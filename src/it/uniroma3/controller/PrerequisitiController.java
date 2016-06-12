package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.facade.PrerequisitiFacade;
import it.uniroma3.model.Prerequisiti;

@ManagedBean
public class PrerequisitiController {

	@EJB
	private PrerequisitiFacade prerequisitiFacade;

	@ManagedProperty(value="#{param.id}")

	private String prerequisiti;
	private String descrizionePrerequisiti;
	private String tipologia;
	private Prerequisiti p;
	private List<Prerequisiti> list;

	private final static String LIST = "dettagliTipologia.xhtml";

	public String create() {
		this.p = this.prerequisitiFacade.createPrerequisiti(tipologia,prerequisiti,descrizionePrerequisiti);
		return "NuovaTipologia.xhtml";
	}
	public String listPrerequisiti() {
		this.list = prerequisitiFacade.findAll();
		return LIST;
	}

	public String getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(String prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public String getDescrizionePrerequisiti() {
		return descrizionePrerequisiti;
	}

	public void setDescrizionePrerequisiti(String descrizionePrerequisiti) {
		this.descrizionePrerequisiti = descrizionePrerequisiti;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Prerequisiti getP() {
		return p;
	}

	public void setP(Prerequisiti p) {
		this.p = p;
	}

	public List<Prerequisiti> getList() {
		return list;
	}

	public void setList(List<Prerequisiti> list) {
		this.list = list;
	}

}
