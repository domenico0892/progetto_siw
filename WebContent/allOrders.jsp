<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Ordini chiusi</title>
</head>
<body>
 <f:view>
 <%@ include file="header.html" %>
  <h:form>
   <div align="center"><h1>Ordini chiusi</h1>
    <table class="table">
     <tr> <th>Id Ordine</th> <th>Data chiusura</th> <th>Id Cliente</th><th>Azione</th></tr>
     <c:forEach var="order" items="#{orderController.orders}">
    	<tr>
    		<td><b>${order.id}</b></td>
    		<td>${order.closeDate}</td>
    		<td>${order.customer.id}</td>
    		    <td><h:commandButton styleClass="btn btn-warning" action="#{orderController.evadeOrder}" value="Evadi">
    				<f:param name="id" value="#{order.id}" />
    			</h:commandButton></td>
    	</tr>
     </c:forEach>
    </table>
   </div>
  </h:form>
 </f:view>
</body>
</html>