<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Product</title>
</head>
<body>
<f:view>
<h:form>
	<c:if test="${sessionScope.administratorController.administrator==null}">
	<%@include file="header.html" %>
	</c:if>
	<p align="center"><b>${productController.message}</b></p>
    <table class="table" border="1">
    <tr><td>Name: <h:inputText value="#{productController.name}" 
                     required="true"
                     requiredMessage="Questo campo è obbligatorio"
                     id="name"/> <h:message for="name" /></td></tr>
	<tr><td>Code: <h:inputText value="#{productController.code}" 
                     required="true"
                     requiredMessage="Questo campo è obbligatorio"
                     id="code"/> <h:message for="code" /></td></tr>
	<tr><td>Price: <h:inputText value="#{productController.price}" 
                     required="true"
                     requiredMessage="Price is mandatory"
                     converterMessage="Questo campo è obbligatorio"
                     id="price"/> <h:message for="price" /></td></tr>
	<tr><td>Quantita': <h:inputText value="#{productController.quantity}" 
                     required="true"
                     requiredMessage="Quantity is mandatory"
                     converterMessage="Questo campo è obbligatorio"
                     id="quantity"/> <h:message for="quantity" /></td></tr>
    <tr><td>Description: <h:inputTextarea value="#{productController.description}" 
    				required="false" 
    				cols="20" 
    				rows="5" /></td></tr>
    <tr><td>Vetrina?: <h:selectBooleanCheckbox value="#{productController.vetrina}"/>          
	</table>
	<div>
		<h:commandButton value="Aggiungi"  action="#{productController.createProduct}"/>
	</div>
</h:form>
</f:view>
</body>
</html>