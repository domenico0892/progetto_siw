<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> <title>Insert title here</title> </head>
 <!-- "administrator" è l'amministratore corrente (autenticato) -->
 <body><h2>Pannello amministrazione ${administratorController.administrator.firstName} ${administratorController.administrator.lastName}</h2>
  <f:view>
   <div>
  	 <h:outputLink value="">Inserisci prodotti</h:outputLink>
   </div>
   <div>
  	 <h:outputLink value="">Ricerca cliente per ordine</h:outputLink>
   </div>
   <div>	
  	 <h:outputLink value="">Evadi ordine</h:outputLink>
   </div>
  </f:view>  
 </body>
</html>