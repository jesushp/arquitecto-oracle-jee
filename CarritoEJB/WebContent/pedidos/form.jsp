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
	<form action="pedidos?action=save" method="post">
		<input type="hidden" name="idPedido" id="input" class="form-control" value="${pedido.idPedido}">
		
		<div class="form-group">
			<label class="control-label">producto:</label>
			<input type="text" name="producto" required class="form-control" style="width:30%"  value="${pedido.producto}" autocomplete="name"/>
		</div>
		<div class="form-group">
			<label class="control-label">categoria:</label>
			<input type="text" name="categoria" required class="form-control" style="width:30%" value="${pedido.categoria}" autocomplete="name"/>
		</div>
		<div class="form-group">
		    <label class="control-label" for="precio">precio:</label>
		    <input type="text" required class="form-control" id="precio" name="precio" style="width:30%" value="${pedido.precio}">
		</div>
		
		<button type="submit" class="btn btn-default">Guardar</button>
		<a type="button" href='pedidos' class="btn btn-default">Volver</a>
		
	</form>
</div>
</body>
</html>

