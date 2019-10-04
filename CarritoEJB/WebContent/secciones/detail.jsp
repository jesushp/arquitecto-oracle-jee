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
		<label class="control-label">seccion:</label>
		<input type="text" name="seccion" disabled class="form-control" style="width:30%"  value="${seccion.seccion}" autocomplete="name"/>
	</div>
	<div class="form-group">
		<label class="control-label">responsable:</label>
		<input type="text" name="responsable" disabled class="form-control" style="width:30%"  value="${seccion.responsable}" autocomplete="name"/>
	</div>
	
	<a type="button" href='secciones' class="btn btn-default">Volver</a>
		
	
</div>
</body>
</html>

