package it.uniroma3.controller;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import javax.faces.bean.ManagedProperty;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;

import it.uniroma3.controller.action.Action;
import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Utente;
@SessionScoped
@Stateless(name="controller")
@ManagedBean
public class ControllerLogin extends HttpServlet {

	@EJB
	private String username;
	private String password;
	private int ruolo;
	private UtenteFacade utenteFacade;
	private Utente utente;
	
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String nextPage = null;
		String actionName = path2action(request);
		Action action;
		try {
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.esegui(request);
		} catch (Exception e) {
			nextPage = "/index.jsp";
		} 
		nextPage = response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	private String path2action(HttpServletRequest request) {

		String path = request.getPathInfo(); 

		String modelCommand = path.substring(1);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(modelCommand).useDelimiter("\\.");
		String model = scanner.next();
		model = model.substring(0,1).toUpperCase() + model.substring(1);

		String action = scanner.next();
		action = action.substring(0,1).toUpperCase() + action.substring(1);

		return "it.uniroma3.controller.action." + action + model;
	}
	public String createUtente() {
		this.utente = utenteFacade.inserisciUtente(username,password,ruolo);
		return("utente");
	}
	public String findUtente() {
		this.utente = utenteFacade.getUtente(username);
		return "utente";
	}
	public String findUtente(String username) {
		this.utente = utenteFacade.getUtente(username);
		return "utente";
	}
	
	public UtenteFacade getUtenteFacade() {
		return utenteFacade;
	}

	public void setUtenteFacade(UtenteFacade utenteFacade) {
		this.utenteFacade = utenteFacade;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRuolo() {
		return ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}
}