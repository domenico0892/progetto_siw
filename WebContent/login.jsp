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
<%@ include file="header.txt" %>
<div align="center"><h1>Login</h1></div>
<h:form>
<div align="center">
    Username: <h:inputText value="#{customerController.username}" 
                     required="true"
                     requiredMessage="Username obbligatorio!"
                     id="username"/>
    Password: <h:inputSecret value="#{customerController.password}" 
    	               required="true"
                     requiredMessage="Password obbligatoria!"
                     id="password"/>
    <div><h:commandButton styleClass="btn btn-warning" value="Login!"  action="#{customerController.login}"/></div>
    <div><h:message for="username"/></div>
    <div><h:message for="password"/></div>
    </div>
</h:form>
</f:view>
</body>
</html>