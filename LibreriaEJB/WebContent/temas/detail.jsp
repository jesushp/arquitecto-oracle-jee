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
	
	
	<div class="form-group">
		<label class="control-label">ID:</label>
		<input type="text" name="seccion" disabled class="form-control" style="width:30%"  value="${tema.idTema}" autocomplete="name"/>
	</div>
	<div class="form-group">
		<label class="control-label">TEMA:</label>
		<input type="text" name="responsable" disabled class="form-control" style="width:30%"  value="${tema.tema}" autocomplete="name"/>
	</div>
	<div class="form-group">
	<label class="control-label">Libros de temática ${tema.tema}</label>
	<table class="table table-striped">
	    <thead>
	      <tr>
	        <th>isbn</th>
	        <th>titulo</th>
	        <th>autor</th>
	        <th>precio</th>
	        <th>paginas</th>
	      </tr>
	    </thead>
	    <tbody>
		<c:forEach var="libro" items="${tema.libros}" >
	    	<tr>
	        <td>${libro.isbn}</td>
	        <td>${libro.titulo}</td>
	        <td>${libro.autor}</td>
	        <td>${libro.precio}</td>
	        <td>${libro.paginas}</td>
	        <td><a href="libros?action=delete&id=${libro.isbn}">Eliminar</a> | 
	        	<a href="libros?action=edit&id=${libro.isbn}">Editar</a>
	        </td>
	      </tr>
	    </c:forEach>
	    </tbody>
    </table>
	</div>
	
	<a type="button" href="temas" class="btn btn-default">Volver</a>
		
	
</div>
</body>
</html>

