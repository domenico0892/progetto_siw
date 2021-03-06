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
<%@include file="header.html"%>
<div align="center"><h1>BuyEverything</h1></div>
<div align="center">
<h3>Benvenuto su BuyEverything. Consulta il nostro catalogo o guarda qui sotto i nostri prodotti in vetrina</h3>
</div>
<div>
<h:form>
<table class="table">
	<tr>
		<th>Nome</th><th>Prezzo</th><th>Codice prodotto</th>
	</tr>
	<c:forEach var="product" items="#{homeController.products}">
	<c:if test="${product.vetrina==true}">
		<tr>
		 <td>
		  <h:commandLink action="#{productController.getProductById}" value="#{product.name}" style="color: Orange">
			<f:param name="id" value="#{product.id}" />
		  </h:commandLink>
		 </td>
		 <td>${product.price}</td>
		  <td>${product.code}</td>
		  </c:if>
	</c:forEach>
   </table>
</h:form>
</div>


<!-- Link per login admin -->
<div align="center">
 <c:if test="${administratorController.administrator==null && customerController.customer==null}"> 
	<h:outputLink style="color: Orange" value="faces/loginDashboard.jsp">Amministrazione</h:outputLink> 
 </c:if>
 </div>
<!-------------------------->

</f:view>
</body>
</html>