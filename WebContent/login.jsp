<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
</head>
<body>
<form action="<c:url value="/controller/user.login"/>" method="get">
username:<input type="text" name="username">
password:<input type="password" name="password">
<input type="submit" name="submit" value="login">
</form>
</body>
</html>