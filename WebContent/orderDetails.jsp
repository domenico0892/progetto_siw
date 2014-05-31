<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Dettagli Ordine</title>
</head>
<body>
<div><h1>Dettagli ordine ${sessionScope.currentOrder.id}</h1></div>
<div>
<f:view>
<h:form>
<table>
<tr>
<th>Nome Prodotto</th><th>Prezzo</th><th>Quantità</th>
</tr>
<c:forEach var="orderLine" items="${sessionScope.currentOrder.orderLines}">
<tr><td>${orderLine.item}</td><td>${orderLine.price}</td><td>${orderLine.quantity}</td></tr>
</c:forEach>
</table>
<h:commandLink action="#{productController.listProducts}">Torna al catalogo</h:commandLink>
</h:form>
</f:view>
</div>
</body>
</html>