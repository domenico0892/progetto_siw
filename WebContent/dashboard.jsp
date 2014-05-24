<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> <title>Dashboard amministratore</title> </head>
 <!-- "administrator" è l'amministratore corrente (autenticato) -->
 <body>
  <div align="center">
 	<h2>Pannello amministrazione ${administratorController.administrator.firstName} ${administratorController.administrator.lastName}</h2>
  <a href="#" onclick="inserisciProdotto();">Inserisci prodotto</a> 
  <a href="#" onclick="cercaClientePerOrdine();">Ricerca cliente</a> 
  <a href="#" onclick="evadiOrdine();">Visualizza ordini</a> 
  <a href="#" onclick="visualizzaTuttiProdotti();">Visualizza prodotti</a>  
  </div>
   	 <!-- Utilizzo AJAX Asynchronous JavaScript and XML -->
   	 <script>
   	 function inserisciProdotto() { //No compatibile con Internet Explorer
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
   	 
   	 function evadiOrdine() {
 		var xhr = new XMLHttpRequest();; 
    		xhr.open("POST", "allOrder.jsp", true);
    		xhr.send(null); 
    		xhr.onreadystatechange = function() {
       	if(xhr.readyState == 4 && xhr.status == 200) {
          	var data = xhr.responseText;
          	document.getElementById("box").innerHTML=data;
      	 	}
   		}
	 }
   	 
   	 function visualizzaTuttiProdotti() {
  		var xhr = new XMLHttpRequest();; 
     		xhr.open("POST", "allProducts.jsp", true);
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