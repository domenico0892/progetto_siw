<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Catalogo</title>
</head>
<body>
<f:view>
<%@include file="header.txt"%>
 <div align="center"><h1>Catalogo prodotti</h1></div>
 <div align="center"><h3>Clicca sul nome del prodotto per visualizzarne le informazioni</h3></div>
  <h:form>
  <br><div id="box" align="center"></div><br>
  <div align="center">
   <table class="table">
	<tr>
		<th>Nome</th><th>Prezzo</th><th>Quantita'</th><th>Codice prodotto</th>
	</tr>
	<c:forEach var="product" items="#{productController.products}">
		<tr>
		 <td>
		  <h:commandLink action="#{productController.getProductById}" value="#{product.name}">
			<f:param name="id" value="#{product.id}" />
			<f:param name="admin" value="#{sessionScope.administratorController.administrator}"/>
		  </h:commandLink>
		 </td>
		 <td>${product.price}</td>
		  <td>${product.quantity}</td>
		  <td>${product.code}</td>
	</c:forEach>
   </table>
  </div>
 </h:form>
</f:view>
</body>
</html>