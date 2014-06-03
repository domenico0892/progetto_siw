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
<div><h1>Dettagli ordine ${orderController.order.id}</h1></div>
<div>
<f:view>
<h:form>
<table>
<tr><th>Nome Prodotto</th><th>Prezzo</th><th>Quantit�</th><th>Azioni</th></tr>
<c:forEach var="orderLine" items="${orderController.order.orderLines}">
<tr><td>${orderLine.item}</td><td>${orderLine.price}</td><td>${orderLine.quantity}</td><td>
<h:commandButton action="#{orderController.deleteOrderLine}" value="Elimina">
<f:param name="selectedorderline" value="#{orderLine.id}"/>
<f:param name="selectedorder" value="#{orderController.order.id}" />
</h:commandButton>
</td></tr>
</c:forEach>
</table>
<h:commandLink action="#{orderController.listOrders}">Vai agli ordini</h:commandLink>
<h:commandLink action="#{productController.listProducts}">Vai al catalogo</h:commandLink>
</h:form>
</f:view>
</div>
</body>
</html>