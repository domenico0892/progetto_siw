<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> <title>Dashboard amministratore</title> </head>
 <!-- "administrator" è l'amministratore corrente (autenticato) -->
 <body>
	<f:view>
		<%@include file="header.html"%>
		<!-- Single button -->
		<div align="center">
		<h:form>
			<h2>Pannello amministrazione
				${administratorController.administrator.firstName}
				${administratorController.administrator.lastName}</h2><br>
				<button type="button" class="btn btn-default btn-lg" onclick="inserisciCliente();">
  					<span class="glyphicon glyphicon-user"></span> Nuovo Cliente
				</button>
				<button type="button" class="btn btn-default btn-lg" onclick="inserisciProdotto();">
  					<span class="glyphicon glyphicon-barcode"></span> Nuovo Prodotto
				</button>
				<button type="button" class="btn btn-default btn-lg" onclick="cercaClientePerOrdine();">
  					<span class="glyphicon glyphicon-search"></span> Ricerca cliente
				</button><br>
				<h:commandLink action="#{orderController.listCloseOrders}">Visualizza ordini </h:commandLink>
				<h:commandLink action="#{productController.listProducts}">Visualizza prodotti </h:commandLink>
				<h:commandLink action="#{administratorController.logOut}">Log out </h:commandLink>
			</h:form>
		</div>
	</f:view>
	<!-- Utilizzo AJAX Asynchronous JavaScript and XML, API XMLHttp-->
   	<script>
   	 function inserisciProdotto() {
    		var xhr = new XMLHttpRequest();; 
       		xhr.open("POST", "newProduct.jsp", true);
       		xhr.send(null); //richiesta inviata, null perchè no dati al server
       		xhr.onreadystatechange = function() {
          	if(xhr.readyState == 4 && xhr.status == 200) {
             	var data = xhr.responseText;
             	document.getElementById("box").innerHTML=data;
         	 	}
      		}
	}
   	
   	 function cercaClientePerOrdine() {
    		var xhr = new XMLHttpRequest();; 
       		xhr.open("POST", "searchCustomerByOrder.jsp", true);
       		xhr.send(null); 
       		xhr.onreadystatechange = function() {
          	if(xhr.readyState == 4 && xhr.status == 200) {
             	var data = xhr.responseText;
             	document.getElementById("box").innerHTML=data;
         	 	}
      		}
 	 }
   	 
   	 function inserisciCliente() {
 		var xhr = new XMLHttpRequest();; 
    		xhr.open("POST", "newCustomer.jsp", true);
    		xhr.send(null); 
    		xhr.onreadystatechange = function() {
       	if(xhr.readyState == 4 && xhr.status == 200) {
          	var data = xhr.responseText;
          	document.getElementById("box").innerHTML=data;
      	 	}
   		}
	 }
	</script>
   	<br><br>
   <div id="box" align="center"></div>
 </body>
</html>