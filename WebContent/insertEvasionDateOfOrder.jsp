<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisc data di evasione</title>
</head>
<body>
 <f:view>
  <h:form>
   <div align="center">Inserisci data di evasione
  					   <h:inputText value="#{}"
  								   required="true"
  								   requiredMessage="Date is mandatory"
  								   id="name"/><h:message for="name" /> (Es. 1900-01-30)</div>
   <h:commandButton value="Conferma" action="#{orderController.}"/>
  </h:form>
 </f:view>
</body>
</html>