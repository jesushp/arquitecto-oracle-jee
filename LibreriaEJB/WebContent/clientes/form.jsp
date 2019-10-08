<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	</head>
<body>

<jsp:include page="../includes/nav.jsp"></jsp:include>

<div class="container">
	<form action="clientes?action=save" method="post">
		<input type="hidden" name="idCliente" id="input" class="form-control" value="${cliente.idCliente}">
		
		<div class="form-group">
			<label class="control-label">usuario:</label>
			<input type="text" name="usuario" required class="form-control" style="width:30%"  value="${cliente.usuario}" autocomplete="name"/>
		</div>
		<div class="form-group">
		    <label class="control-label" for="precio">email:</label>
		    <input type="text" required class="form-control" id="email" name="email"  style="width:30%" value="${cliente.email}">
		</div>
		<div class="form-group">
		    <label class="control-label" for="telefono">telefono:</label>
		    <input type="text" required class="form-control" id="telefono" name="telefono" style="width:30%" value="${cliente.telefono}">
		</div>
		<div class="form-group">
		    <label class="control-label" for="precio">dni:</label>
		    <input type="text" required class="form-control" id="email" name="email"  style="width:30%" value="${cliente.dni}">
		</div>
		<button type="submit" class="btn btn-default">Guardar</button>
		<a type="button" href='clientes' class="btn btn-default">Volver</a>
		
	</form>
</div>
</body>
</html>

