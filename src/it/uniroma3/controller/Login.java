package it.uniroma3.controller;



import javax.faces.bean.ManagedBean;


import it.uniroma3.facade.UtenteFacade;

@ManagedBean(name= "log")
public class Login  {

	private String username;
	private String password;
	private String dbPassword;
	private String dbUsername;
	private int ruolo;
	
	public Login(){}
	
	public int getRuolo() {
		return ruolo;
	}
	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
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
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	
	public String add(){
		new UtenteFacade().inserisciUtente(username, password, ruolo);
		return "ok";
	}
	
	public void dbData(String uName) {
		this.dbUsername = new UtenteFacade().getUtente(uName).getUsername();
		this.dbPassword = new UtenteFacade().getUtente(uName).getPassword();
	}
	public String login() {
        dbData(username);
        if (this.username.equals(dbUsername) && this.password.equals(dbPassword)) {
            return "output";
        } else
            return "fallimento";
    }

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", dbPassword=" + dbPassword + ", dbUsername="
				+ dbUsername + ", ruolo=" + ruolo + "]";
	}
	}


