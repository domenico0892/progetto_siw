<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Dettagli prodotto</title>
</head>
<body>
	<f:view>
		<%@ include file="header.txt"%>
		<div align="center">
			<h1>Prodotto selezionato: ${productController.product.name}</h1>
		</div>
		<table class="table">
			<tr>
				<td>Codice</td>
				<td>${productController.product.code}</td>
			</tr>
			<tr>
				<td>Prezzo</td>
				<td>${productController.product.price} euro</td>
			</tr>
			<tr>
				<td>Descrizione</td>
				<td>${productController.product.description}</td>
			</tr>
			<tr>
				<td>Quantita</td>
				<td>${productController.product.quantity} pezzi</td>
			</tr>
		</table>
		<h:form>
			<div>
		 	Modifica quantita' 
		 	<h:inputText value="#{productController.quantity}" required="true"
						requiredMessage="Quantity is mandatory"
						converterMessage="Quantity must be a number" id="quantity" />
					<h:message for="quantity" />
					<h:commandButton value="Conferma"
						action="#{productController.updateQuantity}">
						<f:param name="id" value="#{productController.product.id}" />
					</h:commandButton>
			</div>
			<div>
			<h:commandLink action="#{productController.providerEditor}" value="Mostra e modifica i fornitori" />
			</div>
		</h:form>
	</f:view>
</body>
</html>
