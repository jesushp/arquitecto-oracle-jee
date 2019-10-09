<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show contacts here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>

<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Edad</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="contacto" items="${contactos}" >
    	<tr>
        <td>${contacto.idContacto}</td>
        <td>${contacto.nombre}</td>
        <td>${contacto.email}</td>
        <td>${contacto.edad}</td>
        <td><a href="controller?action=eliminar&id=${contacto.idContacto}">Eliminar</a></td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
	
    <div class="col-sm-10">
		<a href="controller?action=datos" class="btn btn-info">Alta</a>
		<!-- 
		<a type="button" href='Controller?op=toEntrada' class="btn btn-default">Volver</a> -->
	</div>
</div>

</body>
</html>