<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Customer Profile</title>
</head>
<body>
<h1>Profilo di ${customerController.username}</h1>
Nome: ${customerController.customer.firstName}
Cognome: ${customerController.customer.lastName}
</body>
</html>