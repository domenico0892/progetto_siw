<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Siw Home</title>
</head>
<body>
<div><h1>Progetto Siw Home</h1></div>
<f:view>
<c:if test="${customerController.customer==null}">
<h:outputLink value="login.jsp">Effettua il login!</h:outputLink>
</c:if>
<c:if test="${customerController.customer!=null}">
Benvenuto ${customerController.customer.username}
</c:if>
</f:view>
</body>
</html>