<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>I miei ordini</title>
</head>
<body>
	<f:view>
		<%@ include file="header.html"%>
		<div align="center">
			<h1>I miei ordini</h1>
		</div>
		<h:form>
			<div>
				<h:commandButton action="#{orderController.newOrder}"
					value="Nuovo ordine" />
			</div>
			<div>
				<div align="center">
					<h3>Ordini aperti</h3>
				</div>
				<table class="table">
					<tr>
						<th>Codice</th>
						<th>Data Apertura</th>
						<th>Azioni</th>
					</tr>
					<c:forEach var="order" items="#{orderController.orders}">
						<c:if test="${order.status=='aperto'}">
							<tr>
								<td><h:commandLink
										action="#{orderController.getOrderDetails}"
										value="#{order.id}">
										<f:param name="selectedorder" value="#{order.id}" />
									</h:commandLink></td>
								<td>${order.creationDate}</td>
								<td><h:commandButton
										action="#{orderController.selectOrder}" value="Aggiungi prodotti">
										<f:param name="selectedorder" value="#{order.id}" />
									</h:commandButton> <h:commandButton action="#{orderController.closeOrder}"
										value="Chiudi">
										<f:param name="selectedorder" value="#{order.id}" />
									</h:commandButton></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<div align="center">
					<h3>Ordini chiusi</h3>
				</div>
				<table class="table">
					<tr>
						<th>Codice</th>
						<th>Data apertura</th>
						<th>Data Chiusura</th>
					</tr>
					<c:forEach var="order" items="#{orderController.orders}">
						<c:if test="${order.status=='chiuso'}">
							<tr>
								<td><h:commandLink
										action="#{orderController.getOrderDetails}"
										value="#{order.id}">
										<f:param name="selectedorder" value="#{order.id}" />
									</h:commandLink></td>
								<td>${order.creationDate}</td>
								<td>${order.closeDate}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<div align="center">
					<h3>Ordini evasi</h3>
				</div>
				<table class="table">
					<tr>
						<th>Codice</th>
						<th>Data apertura</th>
						<th>Data chiusura</th>
						<th>Data evasione</th>
					</tr>
					<c:forEach var="order" items="#{orderController.orders}">
						<c:if test="${order.status=='evaso'}">
							<tr>
								<td><h:commandLink
										action="#{orderController.getOrderDetails}"
										value="#{order.id}">
										<f:param name="selectedorder" value="#{order.id}" />
									</h:commandLink></td>
								<td>${order.creationDate}</td>
								<td>${order.closeDate}</td>
								<td>${order.evasionDate}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
		</h:form>
	</f:view>
</body>
</html>