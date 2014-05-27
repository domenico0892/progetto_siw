<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 	<title>Login Amministratore</title>
 </head>
 <body>
 <div align="center"> <h1>Login Amministratore</h1> </div>
 <f:view>
  <h:form>
  <div align="center"> <h:outputLink value="home.jsp">Home</h:outputLink></div><br>
   <div align="center">
 	Username: <h:inputText value="#{administratorController.username}"
 							required="true"
 							requiredMessage="Questo campo è obbligatorio"
 							id="username" /> <h:message for="username"/> <br>
 
 	Password: <h:inputSecret value="#{administratorController.password}"
 							required="true"
 							requiredMessage="Questo campo è obbligatorio"
 							id="password" /> <h:message for="password"/> <br>
 							
  	<h:commandButton value="Log in" action="#{administratorController.loginAdmin}"/>
  	</div>
   </h:form>
  </f:view>
 </body>
</html>