<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show contacts here</title>
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
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Seccion</th>
        <th>precio</th>
        <th>descripcion</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="producto" items="${productos}" >
    	<tr>
        <td>${producto.idProducto}</td>
        <td><a href="secciones?id=${producto.seccion.idSeccion}">${producto.seccion.seccion}</a></td>
        <td>${producto.precio}</td>
        <td>${producto.descripcion}</td>
        <td><a href="productos?action=delete&id=${producto.idProducto}">Eliminar</a> | 
        	<a href="productos?action=edit&id=${producto.idProducto}">Editar</a>
        </td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
	
    <div class="col-sm-10">
		<a href="productos?action=edit" class="btn btn-info">Alta</a>
		<!-- 
		<a type="button" href='Controller?op=toEntrada' class="btn btn-default">Volver</a> -->
	</div>
</div>

</body>
</html>