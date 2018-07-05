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

<title>Authentification Chat</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap data Table -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myStyle.css" rel="stylesheet">

</head>

<body ng-app="myChatApp" ng-controller="myChatController">
	<div class="wrapper spacer40">
		        
		<!-- Page Content -->
		<div class="content">
			<div class="container">
				<%--This will be displayed if the credentials are wrong --%>
				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="alert alert-danger fontSize">
								${message}
							</div>
							
						</div>
					</div>
				</c:if>
				
				<%--This will be displayed when user has logged out --%>
				<c:if test="${not empty logout}">
					<div class="row">
						<div class="col-md-6 col-md-offset-3">
							<div class="alert alert-success fontSize">
								${logout}
							</div>
							
						</div>
					</div>
				</c:if>
			
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4>Connexion</h4>
							</div>
							
							<div class="panel-body">
								<form id="loginForm" action="/chat/login" method="POST"								
								class="form-horizontal fontSize">
								
								<div class="form-group">
									<label for="username" class="col-md-4 control-label">Login: </label>
									<div class="col-md-8">
										<input type="text" id="username" name="username" class="form-control"/>
										
									</div>									
								</div>
								
								<div class="form-group">
									<label for="password" class="col-md-4 control-label">Mot de passe: </label>
									<div class="col-md-8">
										<input type="password" id="password" name="password" class="form-control"/>
									</div>									
								</div>
								
								<div class="form-group">									
									<div class="col-md-8 col-md-offset-4">
										<input type="submit" value="Connexion" class="btn btn-primary"/>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									</div>									
								</div>
								
								</form>
							
							</div>
							
							<div class="panel-footer">
								<div class="text-right fontSize">
									Nouveau Utilisateur - <a href="${contextRoot}/register">Inscrivez vous</a>
								</div>								
							</div>
						</div>
					</div>				
				</div>				
			</div>			
		</div>
		
		
		<script type="text/javascript" src="${angular}/angular.min.js"></script>
		<script type="text/javascript" src="${js}/myapp.js"></script>
	</div>
</body>

</html>
