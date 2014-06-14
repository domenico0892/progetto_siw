<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Provider Editor</title>
</head>
<body>
	<f:view>
		<%@ include file="header.html"%>
		<div align="center">
		<h1>Gestione provider per il prodotto
			${productController.product.name}</h1>
		<h:form>
			
				<h3>Provider disponibili</h3>
				<table class="table">
					<tr>
						<th>Codice</th>
						<th>Nome</th>
						<th>Azioni</th>
					</tr>
					<c:forEach var="provider" items="#{productController.providers}">
						<tr>
							<td><h:commandLink
									action="#{providerController.getProviderDetails}"
									value="#{provider.id}">
									<f:param name="id" value="#{provider.id}" />
								</h:commandLink></td>
							<td>${provider.name}</td>
							<td><h:commandButton
									action="#{productController.addProvider}"
									value="Aggiungi provider">
									<f:param name="providerid" value="#{provider.id}" />
									<f:param name="id" value="#{productController.product.id}" />
								</h:commandButton></td>
					</c:forEach>
				</table>
				<h3>Provider per questo prodotto</h3>
				<table class="table">
					<tr>
						<th>Codice</th>
						<th>Nome</th>
					</tr>
					<c:forEach var="provider"
						items="${productController.providersByProduct}">
						<tr>
							<td>${provider.id}</td>
							<td>${provider.name}</td>
						</tr>
					</c:forEach>
				</table>
		</h:form>
		</div>
	</f:view>
</body>
</html>
