<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Progetto Sistemi informativi su web</title>
 </head>
 <body>
<div id="header" align="center">
 <h1>Progetto Sistemi informativi su web</h1><br>
 
<c:if test="${user.username==null}">
 <a href="<c:url value="/login.jsp"/>">Effettua il login</a>
</c:if>

<c:if test="${user.username!=null}"> Benvenuto <b>${user.username}</b><br>
 <a href="<c:url value="/controller/user.logout"/>">Logout</a>
</c:if>
</div>

<!-- Vetrina prodotti 
<c:forEach var="product" items="${products}">
	<li><b>Nome prodotto: </b>${product.name} <b>Prezzo: ${product.price}</b></li><br>
</c:forEach>
Vetrina prodotti -->

<div id="body">
 <h3>Comandi: </h3>
 <a href="<c:url value="/controller/user.getAll"/>">Visualizza tutti gli utenti</a><br>
 <a href="<c:url value="/controller/product.getAll"/>">Visualizza tutti i prodotti</a>
</div>

 </body>
</html>