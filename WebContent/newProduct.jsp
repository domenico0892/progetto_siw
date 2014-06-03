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
	<div align="center"><h3>${productController.prodottoPresnte}</h3><br></div>
    <div align="center">Name: <h:inputText value="#{productController.name}" 
                     required="true"
                     requiredMessage="Name is mandatory"
                     id="name"/> <h:message for="name" />
	</div>
    <div align="center">Code: <h:inputText value="#{productController.code}" 
                     required="true"
                     requiredMessage="Code is mandatory"
                     id="code"/> <h:message for="code" />
	</div>
    <div align="center">Price: <h:inputText value="#{productController.price}" 
                     required="true"
                     requiredMessage="Price is mandatory"
                     converterMessage="Price must be a number"
                     id="price"/> <h:message for="price" />
	</div>
    <div align="center">Quantita': <h:inputText value="#{productController.quantity}" 
                     required="true"
                     requiredMessage="Quantity is mandatory"
                     converterMessage="Quantity must be a number"
                     id="quantity"/> <h:message for="quantity" />
	</div>
    <div align="center">Description: <h:inputTextarea value="#{productController.description}" 
    				required="false" 
    				cols="20" 
    				rows="5" />                     
	</div>
	<div align="center">
		<h:commandButton value="Aggiungi"  action="#{productController.createProduct}"/>
	</div>
</h:form>
</f:view>
</body>
</html>