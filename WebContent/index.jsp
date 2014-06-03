<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<title>Homepage</title>
</head>
<body>
<f:view>
<%@include file="header.txt"%>
<div align="center"><h1>Progetto Siw Home</h1></div>
<div>

</div>
<div>Ordine Corrente: ${sessionScope.currentOrder.id}</div>

<!-- Link per login admin -->
<div>
 <c:if test="${administratorController.administrator==null && customerController.customer==null}"> 
	<h:outputLink value="faces/loginDashboard.jsp">Dashboard Amministrazione</h:outputLink> 
 </c:if>
 </div>
<!-------------------------->

</f:view>
</body>
</html>