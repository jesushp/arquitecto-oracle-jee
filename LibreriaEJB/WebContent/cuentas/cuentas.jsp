<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
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
        <th>numeroCuenta</th>
        <th>Saldo</th>
        <th>Tipo de cuenta</th>
        
      </tr>
    </thead>
    <tbody>
    <c:forEach var="cuenta" items="${cuentas}"  >
  
    	<tr>
	        <td>${cuenta.numeroCuenta}</td>
	        <td>${cuenta.saldo}</td>
	        <td>${cuenta.tipocuenta}</td>
      </tr>
  	</c:forEach>
    
    </tbody>
  </table>
	
    
</div>

</body>
</html>