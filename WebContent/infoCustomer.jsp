<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente selezionato</title>
</head>
 <body>
  <f:view>
  <%@ include file="header.html" %>
   <h:form>
   <div align="center" style="color:green"><h4>Ordine presente</h4></div>
    <div align="center">
    <h4>Ordine associato a ${orderController.customer.firstName} ${orderController.customer.lastName}</h4>
	<table class="table">
    	<tr><td>Id ordine</td><td>${orderController.order.id}</td></tr>
    	<tr><td>Id cliente</td><td>${orderController.customer.id}</td>
    	<tr><td>Username</td><td>${orderController.customer.username}</td></tr>
    	<tr><td>Data di nascita</td><td>${orderController.customer.dateOfBirth}</td> </tr>
    	<tr><td>Data di registrazione</td><td>${orderController.customer.registrationDate}</td></tr> 
    	<tr><td>eMail</td><td>${orderController.customer.email}</td></tr> 
    	<tr><td>Numero di telefono</td><td>${orderController.customer.phoneNumber}</td> </tr>
    	<tr><td>Indirizzo</td><td>${orderController.customer.address.street}</td> </tr>
    	<tr><td>Città</td><td>${orderController.customer.address.city}</td> </tr>
    	<tr><td>Provincia</td><td>${orderController.customer.address.state}</td> </tr>
    	<tr><td>CAP</td><td>${orderController.customer.address.zipcode}</td> </tr>
    	<tr><td>Stato</td><td>${orderController.customer.address.country}</td> </tr>
    	</table>
    </div>
   </h:form>
  </f:view>
 </body>
</html>