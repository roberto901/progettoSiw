package it.uniroma3.filtri;

import java.io.IOException;
import javax.persistence.Entity;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.openejb.server.httpd.HttpSession;

@Entity
public class LoginFilter implements Filter {
	private ServletContext application;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
									throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		javax.servlet.http.HttpSession session = req.getSession();
		if (session.getAttribute("utente")==null) { // questa condizione può essere definita meglio
			RequestDispatcher rd  = this.application.getRequestDispatcher("/admin/login.do");
			rd.forward(request, response);	
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {		
		this.application = fConfig.getServletContext();	
	}

	public void destroy() {		
	}
}
