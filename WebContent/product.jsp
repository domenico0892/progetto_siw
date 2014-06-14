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
				<td>${productController.product.price} euro</td>
			</tr>
			<tr>
				<td>Descrizione</td>
				<td>${productController.product.description}</td>
			</tr>
		</table>
		<h:form>
			<div align="center"> Aggiungi questo prodotto all'ordine, inserendo la quantità! <br>
				<c:if test="${sessionScope.currentOrder!=null}">
					<h:inputText value="#{orderController.orderedQuantity}" />
					<h:commandButton action="#{orderController.addOrderLine}">
						<f:param name="productid" value="#{productController.product.id}" />
					</h:commandButton>
				</c:if>
			</div>
		</h:form>
	</f:view>
</body>
</html>