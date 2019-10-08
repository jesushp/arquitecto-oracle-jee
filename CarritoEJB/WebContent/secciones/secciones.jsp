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
        <th>seccion</th>
        <th>precio</th>
        <th>categoria</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
   
    <c:forEach var="pedido" items="${pedidos}" >
    	<tr>
        <td>${seccion.idSeccion}</td>
        <td>${seccion.seccion}</td>
        <td>${seccion.responsable}</td>
        <td><a href="pedidos?action=edit&id=${seccion.idSeccion}">Detalle</a>
        </td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
    
</div>

</body>
</html>