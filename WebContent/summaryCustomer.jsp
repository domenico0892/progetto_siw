<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente inserito</title>
</head>
<f:view>
<body>
<%@ include file="header.html" %>
<h:form>
	<div align="center" style="color:green"><h4>Cliente inserito correttamente</h4></div><br>
	 <table class="table">
       	<tr><td>Id</td><td>${customerController.customer.id}</td>
    	<tr><td>Username</td><td>${customerController.customer.username}</td></tr> 
    	<tr><td>Data di nascita</td><td>${customerController.customer.dateOfBirth}</td> </tr>
    	<tr><td>Data di registrazione</td><td>${customerController.customer.registrationDate}</td></tr> 
    	<tr><td>eMail</td><td>${customerController.customer.email}</td></tr> 
    	<tr><td>Numero di telefono</td><td>${customerController.customer.phoneNumber}</td> </tr>
    	<tr><td>Indirizzo</td><td>${customerController.customer.address.street}</td> </tr>
    	<tr><td>Città</td><td>${customerController.customer.address.city}</td> </tr>
    	<tr><td>Provincia</td><td>${customerController.customer.address.state}</td> </tr>
    	<tr><td>CAP</td><td>${customerController.customer.address.zipcode}</td> </tr>
    	<tr><td>Stato</td><td>${customerController.customer.address.country}</td> </tr>
    </table>
</h:form>
</f:view>
</body>
</html>