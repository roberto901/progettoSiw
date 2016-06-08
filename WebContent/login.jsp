<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"></link>
<body>
<h1>Login</h1>
		<div>
			Username:
			<h:inputText value="#{controller.username}" required="true"
				requiredMessage="username"
				id="username" >
				<f:validateLength minimum="1" maximum="10"/>
				</h:inputText>
		</div>
		<div>
			Password:
			<h:inputText value="#{controller.password}" />
		</div>
		<div>
		<h:form>
			<h:commandButton value="Login" action="#{loginAction.doPost}"  />
		</h:form>
		</div>
</body>
</html>
</f:view>
