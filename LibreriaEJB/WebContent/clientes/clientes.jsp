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
        <th>ID</th>
        <th>email</th>
        <th>telefono</th>
        <th>dni</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="cliente" items="${clientes}" >
    	<tr>
        <td>${cliente.idCliente}</td>
        <td>${cliente.email}</td>
        <td>${cliente.telefono}</td>
        <td>${cliente.dni}</td>
        <td>
        	<a href="cuentas?action=list&dni=${cliente.dni}">Cuentas</a> | 
        	<a href="ventas?action=list&id=${cliente.idCliente}">Ventas</a> | 
        	<a href="clientes?action=delete&id=${cliente.idCliente}">Eliminar</a> | 
        	<a href="clientes?action=edit&id=${cliente.idCliente}">Editar</a>
        </td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
	
    <div class="col-sm-10">
		<a href="clientes?action=edit" class="btn btn-info">Alta</a>
		<!-- 
		<a type="button" href='Controller?op=toEntrada' class="btn btn-default">Volver</a> -->
	</div>
</div>

</body>
</html>