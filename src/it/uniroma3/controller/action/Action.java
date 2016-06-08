package it.uniroma3.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action { public String esegui(HttpServletRequest request) throws ServletException; }
