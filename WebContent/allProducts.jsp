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
 <div align="center"><h1>Catalogo prodotti</h1></div>
   <div align="center">
   <c:if test="${administratorController.administrator!=null}">
     <h:outputLink value="dashboard.jsp">Dashboard</h:outputLink>
   </c:if>
   <c:if test="${administratorController.administrator==null}">
     <h:outputLink value="home.jsp">Home</h:outputLink>
   </c:if>
  </div>
  <h:form>
   <table>
	<tr>
		<th>Nome</th><th>Prezzo</th><th>Azioni</th>
	</tr>
	<c:forEach var="product" items="#{productController.products}">
		<tr><td>
		<h:commandLink action="#{productController.getProductById}" value="#{product.name}">
			<f:param name="id" value="#{product.id}" />
		</h:commandLink>
		</td><td>${product.price}</td>
		<td><h:commandButton action="#{orderController.addOrderLine}">
			<f:param name="productId" value="#{product.id}"/>
			</h:commandButton>
		</td>
	</c:forEach>
   </table>
 </h:form>
</f:view>
</body>
</html>