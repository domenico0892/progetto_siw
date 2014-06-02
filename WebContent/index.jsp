<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>progetto_siw</title>
</head>
<body>
<div><h1>Progetto Siw Home</h1></div>
<f:view>
<div>
<h:form>
<c:if test="${customerController.customer==null}">
<h:outputLink value="login.jsp">Accedi</h:outputLink>
</c:if>
<c:if test="${customerController.customer!=null}">
Benvenuto <b>${customerController.customer.username}</b>
<h:commandLink action="#{customerController.logout}"> Logout</h:commandLink>
</c:if>
<h:commandLink action="#{productController.listProducts}"> Tutti i prodotti </h:commandLink>
<h:commandLink action="#{orderController.listOrders}"> I miei ordini </h:commandLink>
<h:commandLink action="#{customerController.customerProfile}"> Il mio profilo </h:commandLink>
</h:form>
</div>
<div>Ordine Corrente: ${sessionScope.currentOrder.id}</div>

<!-- Link per login admin -->
<div>
 <c:if test="${administratorController.administrator==null && customerController.customer==null}"> 
	<h:outputLink value="loginDashboard.jsp">Dashboard Amministrazione</h:outputLink> 
 </c:if>
 </div>
<!-------------------------->

</f:view>
</body>
</html>