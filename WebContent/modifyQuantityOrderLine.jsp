<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Modifica Quantità</title>
</head>
<body>
<f:view>
<h:form>
<div align="center">
<h:inputText value="#{orderController.orderedQuantity}" /><br>
<h:commandButton value="#{orderController.modifyQuantityOrderLine}">
<f:param name="selectedorderline" value="#{orderLine.id}" />
<f:param name="selectedorder" value="#{orderController.order.id}" />
</h:commandButton>
</div> 
</h:form>
</f:view>