<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Dettagli prodotto</title>
</head>
<body>
	<f:view>
		<div align="center"><h1>Prodotto selezionato: ${productController.product.name}</h1></div>
	     <div align="center">
           <c:if test="${administratorController.administrator!=null}">
     			<h:outputLink value="dashboard.jsp"> Dashboard </h:outputLink>
           </c:if>
   		   <c:if test="${administratorController.administrator==null}">
     			<h:outputLink value="home.jsp"> Home </h:outputLink>
   		   </c:if>
  		</div>
		<h2>Dettagli</h2>
		<div>Codice: ${productController.product.code}</div>
		<div>Prezzo: ${productController.product.price} euro</div>
		<div>Descrizione: ${productController.product.description}</div>
		<div>Quantita': ${productController.product.quantity} pezzi</div>
	</f:view>
</body>
</html>