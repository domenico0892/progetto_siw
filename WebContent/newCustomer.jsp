<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo cliente</title>
</head>
 <body>
 <f:view>
  <h:form>   
   <div align="center">Username: <h:inputText value="#{customerController.username}"                     
   					   required="true"
                       requiredMessage="Username is mandatory"
                       id="username"/> <h:message for="username" /></div>
   <div align="center">Password: <h:inputText value="#{customerController.password}"                     
   					   required="true"
                       requiredMessage="Password is mandatory"
                       id="password"/> <h:message for="password" /></div>
   <div align="center">Nome: <h:inputText value="#{customerController.firstName}"                     
   					   required="true"
                       requiredMessage="First Name is mandatory"
                       id="firstName"/> <h:message for="firstName" /></div>
   <div align="center">Cognome: <h:inputText value="#{customerController.lastName}"                     
   					   required="true"
                       requiredMessage="Last Name is mandatory"
                       id="lastName"/> <h:message for="lastName" /></div>
   <!--<div align="center">eMail: <h:inputText value="#{customerController.email}"                     
   					   required="true"
                       requiredMessage="eMail Name is mandatory"
                       id="email"/> <h:message for="email" /></div>
    <div align="center">Telefono: <h:inputText value="#{customerController.phoneNumber}"/></div>
   <div align="center">Data di nascita: <h:inputText value="#{customerController.dateOfBirth}"/></div>
   --><div align="center">
		<h:commandButton value="Aggiungi"  action="#{customerController.createCustomer}"/>
	</div>
  </h:form>
 </f:view>
 </body>
</html>