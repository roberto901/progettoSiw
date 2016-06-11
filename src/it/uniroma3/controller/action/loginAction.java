package it.uniroma3.controller.action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.facade.facadeAutenticazione;
import it.uniroma3.facade.facadeAutenticazioneImpl;
import it.uniroma3.model.Utente;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class loginAction extends HttpServlet implements Action {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName="utenteFacade")
	private UtenteFacade utente;

	public loginAction(){}



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String prossimaPagina = "/fallimento.jsp";
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String prossimaPagina = "/fallimento.jsp";
		loginAction login = new loginAction();
		String esito = login.esegui(request);
		if (esito.equals("OK"))
			prossimaPagina = "/risorsaProtetta.jsp";
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}

	public String esegui(HttpServletRequest request) throws ServletException  {
		facadeAutenticazione authService = new facadeAutenticazioneImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = authService.login(username, password);
		if (utente!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("utente",utente);
			return "OK";
		} else
			return "KO";
	}
}