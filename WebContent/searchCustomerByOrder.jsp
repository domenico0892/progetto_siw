<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search customer by order</title>
</head>
<body>
 <f:view>
  <h:form>
   <div align="center">
    ID Ordine <h:inputText value="#{orderController.id}"
    					   required="true"
    					   requiredMessage="Non è stato inserito nessun codice"
    					   id="orderId"/> <h:message for="orderId"/>
   </div>
   <div align="center">
    <h:commandButton value="Mostra cliente" action="#{orderController.getCustomer}"/>
   </div>
  </h:form>
 </f:view>
</body>
</html>