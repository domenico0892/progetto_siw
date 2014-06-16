<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Dettaglio ordine</title>
</head>
<body>
	<f:view>
		<%@ include file="header.html"%>
		<div align="center">
			<h1>Dettaglio ordine ${orderController.order.id}</h1>
		</div>
		<h:form>
				<table class="table">
					<tr>
						<th>Prodotto</th>
						<th>Prezzo</th>
						<th>Quantita'</th>
						<th>Azioni</th>
					</tr>
					<c:forEach var="orderline" items="#{orderController.order.orderLines}">
							<tr><td>${orderline.product.name}</td>
								<td>${orderline.price}</td>
								<td>${orderline.quantity}</td>
								<td><h:commandButton styleClass="btn btn-warning"  action="#{orderController.deleteOrderLine}"
										value="Elimina">
										<f:param name="selectedorder" value="#{orderController.order.id}" />
										<f:param name="orderline" value="#{orderline.id}" />
									</h:commandButton>
									<br>
									<h:inputText value="#{orderController.orderedQuantity}" />
									<h:commandButton styleClass="btn btn-warning"  action="#{orderController.modifyQuantityOrderLine}"
										value="Modifica quantita'">
										<f:param name="selectedorder" value="#{orderController.order.id}" />
										<f:param name="orderline" value="#{orderline.id}" />
									</h:commandButton></td>
									
							</tr>
					</c:forEach>
						</table>
		</h:form>
	</f:view>
</body>
</html>