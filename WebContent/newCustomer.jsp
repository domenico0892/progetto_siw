<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo cliente</title>
</head>
<body>
	<f:view>
		<h:form>
			<!-- Dati utente -->
			<p align="center"><b>${customerController.message}</b></p>
			<table align="center" class="table">
				<tr>
					<td><h3>Dati del nuovo cliente</h3></td>
				</tr>
				<tr>
					<td>Username: <h:inputText
							value="#{customerController.username}" required="true"
							requiredMessage="Username is mandatory" id="username" /> <h:message
							for="username" /></td>
				</tr>
				<tr>
					<td>Password: <h:inputText
							value="#{customerController.password}" required="true"
							requiredMessage="Password is mandatory" id="password" /> <h:message
							for="password" /></td>
				</tr>
				<tr>
					<td>Nome: <h:inputText value="#{customerController.firstName}"
							required="true" requiredMessage="First Name is mandatory"
							id="firstName" /> <h:message for="firstName" /></td>
				</tr>
				<tr>
					<td>Cognome: <h:inputText
							value="#{customerController.lastName}" required="true"
							requiredMessage="Last Name is mandatory" id="lastName" /> <h:message
							for="lastName" /></td>
				</tr>
				<tr>
					<td>eMail: <h:inputText value="#{customerController.email}"
							required="true" requiredMessage="eMail Name is mandatory"
							id="email" /> <h:message for="email" /></td>
				</tr>
				<tr>
					<td>Telefono: <h:inputText
							value="#{customerController.phoneNumber}" />
					</td>
				</tr>
				<tr>
					<td>Data di nascita: <h:inputText
							value="#{customerController.dateOfBirth}">
							<f:convertDateTime pattern="yyyy-MM-dd" />
						</h:inputText></td>
				</tr>
			</table>
			<br>
			<!-- Indirizzo -->
			<table align="center" border="1">
				<tr>
					<td><h3>Indirizzo del nuovo cliente</h3></td>
				</tr>
				<tr>
					<td>Citta': <h:inputText value="#{customerController.city}"
							required="true" requiredMessage="City is mandatory" id="city" />
						<h:message for="city" /></td>
				</tr>
				<tr>
					<td>Paese: <h:inputText value="#{customerController.country}"
							required="true" requiredMessage="Country is mandatory"
							id="country" /> <h:message for="country" />
					</td>
				</tr>
				<tr>
					<td>Stato: <h:inputText value="#{customerController.state}"
							required="true" requiredMessage="State is mandatory" id="state" />
						<h:message for="state" />
					</td>
				</tr>
				<tr>
					<td>Via: <h:inputText value="#{customerController.street}"
							required="true" requiredMessage="Street is mandatory" id="street" />
						<h:message for="street" />
					</td>
				</tr>
				<tr>
					<td>Codice postale: <h:inputText
							value="#{customerController.zipcode}" required="true"
							requiredMessage="Zipcode is mandatory" id="zipcode" /> <h:message
							for="zipcode" />
					</td>
				</tr>
			</table><br>
			<div align="center">
				<h:commandButton value="Aggiungi"
					action="#{customerController.createCustomer}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>