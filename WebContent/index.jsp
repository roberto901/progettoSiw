<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
<head>
<title>Benvenuto</title>
<body bgcolor="white">
<h1>CLINICA PROGETTO</h1>
<div class="btn-group btn-group-justified" role="group" aria-label="...">
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-default">HOME</button>
  </div>
  <div class="btn-group" role="group">
  <form action="faces/login.jsp">
    <button type="submit" class="btn btb-default">LOGIN</button>
    </form>
  </div>
  <div class="btn-group" role="group">
    <button type="button" class="btn btn-default">CONTATTI</button>
  </div>
</div>
<img src="http://www.strettoweb.com/wp-content/uploads/2014/09/cartella-clinica.jpg">
</body>
</html>

    