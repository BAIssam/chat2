<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="angular" value="/resources/angular"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Chat</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<!-- Bootstrap data Table -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myStyle.css" rel="stylesheet">

</head>
<body ng-app="myChatApp" ng-controller="myChatController" ng-init="chargerUtilisateurs()">
<div class="wrapper spacer40">
  <div class="content">
	<div class="container">
	 <div class="row">
	   <div class="col-md-3">
		   <div class="panel panel-primary">
			<div class="panel-heading">Utilisateurs</div>
			<div class="panel-body">
			  <table class="table table-striped">
				<tr>
					<th>Id</th><th>Pseudo</th>
				</tr>							
		        <tr ng-repeat="user in pageUsers">
			        <td><a ng-click="chargerMessages()">{{user.idUser}}</a></td>		        
			        <td>{{user.pseudo}}</td>
		        </tr>						    
			  </table>	
					
					
			</div>
		   </div>
		 </div>
		 
		 <div class="col-md-9">
		   <div class="panel panel-primary">
			<div class="panel-heading">Chat</div>
			<div class="panel-body">
			  <div class="row">
			  	<div class="col-md-12">
			  		<ul>
				  		<li ng-repeat="msg in pageMessages">
				  			{{msg.message}}
				  		</li>
				  		
				    </ul>
			  	</div>
			  	
			  	<div class="col-md-12">
			  		<input id="message_input_value" ng-model="message" placeholder="Ecrivez votre message ici..." />
			    	<button ng-click="envoyer()" class="btn btn-primary">Envoyer</button>
			  	</div>			  
			  </div>			  			  
			  <a class="btn btn-primary" href="/chat/login?logout">Déconnection</a>						  	
			</div>
		   </div>
		 </div>
	 </div>
	 
	  
	</div>
  </div>
</div>

<script type="text/javascript" src="${angular}/angular.min.js"></script>
<script type="text/javascript" src="${js}/myapp.js"></script>
</body>
</html>