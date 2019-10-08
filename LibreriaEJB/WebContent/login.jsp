<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<h1>Formulario de autenticación</h1>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">
			<strong>Error en el login:</strong>${error}
		</div>
	
	</c:if>
	<form action="login" method="post">
		<div class="form-group">
			<label>Usuario:</label><input type="text" name="email" class="form-control" style="width:30%" placeholder="Email" autocomplete="name"/>
		</div>
		<div class="form-group">
			<label>Password:</label><input type="password" name="password" class="form-control" style="width:30%" placeholder="Contraseña"/>
		</div>
		
		<button type="submit" class="btn btn-default">Enviar</button>
		
	</form>
	

</div>
</body>
</html>