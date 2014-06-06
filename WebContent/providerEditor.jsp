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
	<h:form>
		<%@ include file="header.txt"%>
		<table>
		<tr><th>Codice</th><th>Nome</th><th>Azioni</th></tr>
		<c:forEach var="provider" items="#{productController.providersByProducts}">
			<tr><td><h:commandLink action="#{providerController.getProviderDetails}" value="#{provider.id}">
			<f:param name="id" value="#{provider.id}" />
 			</h:commandLink></td>
 			<td>${provider.name}</td>
 			<td><h:commandButton action="#{productController.addProvider}" value="Aggiungi provider"/></td>
		</c:forEach>
		</table>
		</h:form>
	</f:view>
</body>
</html>
