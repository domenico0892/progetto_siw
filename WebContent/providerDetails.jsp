<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Dettagli provider</title>
</head>
<body>
	<f:view>
		<%@ include file="header.html"%>
		<div align="center">
			<h1>Provider selezionato: ${providerController.provider.name}</h1>
		</div>
		<table class="table">
			<tr>
				<td>Codice</td>
				<td>${providerController.provider.id}</td>
			</tr>
			<tr>
				<td>Nome</td>
				<td>${providerController.provider.name}</td>
			</tr>
			<tr>
				<td>Descrizione</td>
				<td>${providerController.provider.phoneNumber}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${providerController.provider.email}</td>
			</tr>
			<tr>
				<td>Partita IVA</td>
				<td>${providerController.provider.vatin}</td>
			</tr>
			<tr>
				<td>Indirizzo</td>
				<td>${providerController.provider.address.street}</td>
			</tr>
			<tr>
				<td>Citta'</td>
				<td>${providerController.provider.address.city}</td>
			</tr>
			<tr>
				<td>Provincia</td>
				<td>${providerController.provider.address.state}</td>
			</tr>
			<tr>
				<td>CAP</td>
				<td>${providerController.provider.address.zipcode}</td>
			</tr>
			<tr>
				<td>Stato</td>
				<td>${providerController.provider.address.country}</td>
			</tr>
		</table>
	</f:view>
</body>
</html>