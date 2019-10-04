<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de pedidos</title>
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
	<h1>Formulario de productos</h1>
	<form action="productos?action=save" method="post">
		<input type="hidden" name="idPedido" id="input" class="form-control" value="${producto.idProducto}">
	
		<div class="form-group">
			<label class="control-label">nombre:</label>
			<input type="text" name="nombre" required class="form-control" style="width:30%" placeholder="nombre" autocomplete="name" value="${producto.nombre}"  />
		</div>
		<div class="form-group">
			<label class="control-label">descripcion:</label>
			<input type="text" name="descripcion" required class="form-control" style="width:30%" placeholder="descripcion" autocomplete="name" value="${producto.descripcion}" />
		</div>
		<div class="form-group">
			<label class="control-label">Seccion:</label>
			<select name="idSeccion" id="idSeccion" class="form-control" style="width:30%" required="required" value="${producto.seccion.idSeccion}" >
				<c:forEach items="${secciones}" var="seccion" >
					<c:set var="selected" value="${seccion.idSeccion == producto.seccion.idSeccion ? 'selected' : ''}" />
					<option value="${seccion.idSeccion}" ${selected}> ${seccion.seccion}</option>
				</c:forEach>
			</select>
			
		</div>
		<div class="form-group">
		    <label class="control-label" for="precio">precio:</label>
		    <input type="number" class="form-control" id="precio" name="precio" style="width:30%" required value="${producto.precio}" >
		</div>
		
		<button type="submit" class="btn btn-default">Guardar</button>
		<a type="button" href="productos" class="btn btn-default">Volver</a>
		
	</form>
</div>
</body>
</html>

