<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Customer Profile</title>
</head>
<body>
 <div align="center">
 <h1>Profilo di ${customerController.username}</h1><br>
     <c:if test="${administratorController.administrator!=null}">
     	<h:outputLink value="dashboard.jsp">Dashboard</h:outputLink><br>
     </c:if>
	 Nome: ${customerController.customer.firstName}<br>
	 Cognome: ${customerController.customer.lastName}<br> 
 </div>
</body>
</html>