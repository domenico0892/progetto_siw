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
   <h:form>
    <div align="center"><h1>Cliente selezionato: ${orderController.customer.firstName} ${orderController.customer.lastName}</h1></div>
    <div align="center"><h:outputLink value="dashboard.jsp"> Dashboard </h:outputLink></div>
    <div align="center"><br>
    	Id ordine selezionato: <b>${orderController.order.id}</b> <br>
    	Id cliente: <b>${orderController.customer.id}</b> <br>
    	Username: <b>${orderController.customer.username}</b> <br>
    	Indirizzo: <b>${orderController.customer.address}</b> <br>
    	Data di nascita: <b>${orderController.customer.dateOfBirth}</b> <br>
    	Data di registrazione: <b>${orderController.customer.registrationDate}</b> <br>
    	eMail: <b>${orderController.customer.email}</b> <br>
    	Numero di telefono: <b>${orderController.customer.phoneNumber}</b> <br>
    </div>
   </h:form>
  </f:view>
 </body>
</html>