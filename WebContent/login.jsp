<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login</title>
</head>
<body>
<f:view>
<%@ include file="header.html" %>
<div align="center"><h1>Login</h1></div>
<h:form>
<div align="center">
<table>
    <tr><td>Username</td><td><h:inputText value="#{customerController.username}" styleClass="form-control" 
                     required="true"
                     requiredMessage="Username obbligatorio!"
                     id="username"/></td></tr><br>
    <tr><td>Password</td><td><h:inputSecret value="#{customerController.password}"  styleClass="form-control" 
    	               required="true"
                     requiredMessage="Password obbligatoria!"
                     id="password"/></td></tr></table><br>
     <h:commandButton styleClass="btn btn-warning" value="Login!"  action="#{customerController.login}"/>
    <h:message for="username"/>
    <h:message for="password"/>
    <p align="center"><b>${customerController.message}</b></p><br>
    <div align="center">
    <h3>Non sei ancora registrato? <h:outputLink style="color: Orange" value="faces/newCustomerRegistration.jsp">Clicca qui!</h:outputLink></h3>
    </div>
    
    </div>
</h:form>
</f:view>
</body>
</html>