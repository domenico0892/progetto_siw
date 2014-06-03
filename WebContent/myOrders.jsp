<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>I miei ordini</title>
</head>
<body>
<div><h1>I miei ordini</h1></div>
<f:view>
<h:form>
<div><h:commandButton action="#{orderController.newOrder}" value="Nuovo ordine"/></div>
<div>
<table>
<tr><th>Codice</th><th>Data Apertura</th><th>Stato</th><th>Azioni</th></tr>
<c:forEach var="order" items="#{orderController.orders}">
<tr><td><h:commandLink action="#{orderController.getOrderDetails}" value="#{order.id}">
			<f:param name="selectedorder" value="#{order.id}"/></h:commandLink></td>
<td>${order.creationDate}</td><td>${order.status}</td></tr>
</c:forEach>
</table>
</div>
</h:form>
</f:view>
</body>
</html>