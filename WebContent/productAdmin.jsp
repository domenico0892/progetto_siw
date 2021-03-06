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
		<%@ include file="header.html"%>
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
				<td>${productController.product.price}euro</td>
			</tr>
			<tr>
				<td>Descrizione</td>
				<td>${productController.product.description}</td>
			</tr>
			<tr>
				<td>Quantita</td>
				<td>${productController.product.quantity}pezzi</td>
			</tr>
		</table>
		<h:form>
			<table class="table" border="1">
				<tr>
					<td><h3>Modifica dettagli prodotto</h3></td>
				</tr>
				<tr>
					<td>Prezzo <h:inputText value="#{productController.price}"/></td>
				</tr>
				<tr>
					<td>Quantita' <h:inputText value="#{productController.quantity}"/></tr>
				<tr>
					<td>Descrizione <h:inputText value="#{productController.description}"/></td></tr>
				<tr>
					<td><h:commandButton value="Conferma" styleClass="btn btn-warning"
							action="#{productController.updateProduct}">
							<f:param name="id" value="#{productController.product.id}" />
						</h:commandButton></td>
				</tr>
			</table>
		</h:form>
		<div align="center">
			<h:form>
				<h:commandLink action="#{productController.providerEditor}" style="color: Orange"
					value="Mostra e modifica i fornitori">
					<f:param name="id" value="#{productController.id}" />
				</h:commandLink><br>
				<h:commandLink action="#{productController.deleteProduct}" value="Elimina prodotto" style="color: Orange">
				 <f:param name="id" value="#{productController.id}" />
				</h:commandLink>
			</h:form>
		</div>
	</f:view>
</body>
</html>
