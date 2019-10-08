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
  <table class="table table-striped">
    <thead>
      <tr>
        <th>isbn</th>
        <th>titulo</th>
        <th>autor</th>
        <th>precio</th>
        <th>paginas</th>
        <th>Tema</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="libro" items="${libros}" >
    	<tr>
        <td>${libro.isbn}</td>
        <td>${libro.titulo}</td>
        <td>${libro.autor}</td>
        <td>${libro.precio}</td>
        <td>${libro.paginas}</td>
        <td><a href="temas?id=${libro.tema.idTema}&action=detail">${libro.tema.tema}</a></td>
        <td><a href="libros?action=delete&id=${libro.isbn}">Eliminar</a> | 
        	<a href="libros?action=edit&id=${libro.isbn}">Editar</a>
        </td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
	
    <div class="col-sm-10">
		<a href="libros?action=edit" class="btn btn-info">Alta</a>
		<!-- 
		<a type="button" href='Controller?op=toEntrada' class="btn btn-default">Volver</a> -->
	</div>
</div>

</body>
</html>