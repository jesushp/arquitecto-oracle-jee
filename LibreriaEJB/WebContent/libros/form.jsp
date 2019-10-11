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
	<form action="libros?action=save" method="post">
		
		<div class="form-group">
			<label class="control-label">isbn:</label>
			<c:set var="enabled" value="${empty libro ? '' : 'disabled'}" />
			<input type="text" ${enabled} name="isbn" id="input" style="width:30%" class="form-control" value="${libro.isbn}" value="${libro.isbn}" >
		</div>
		
		
		<c:set var="disabled" value="${edit ? '' : 'disabled'}" />
		
		<div class="form-group">
			<label class="control-label">titulo:</label>
			<input type="text" name="titulo" ${disabled} required class="form-control" style="width:30%" placeholder="titulo" autocomplete="name" value="${libro.titulo}"  />
		</div>
		<div class="form-group">
			<label class="control-label">autor:</label>
			<input type="text" name="autor" ${disabled} required class="form-control" style="width:30%" placeholder="autor" autocomplete="name" value="${libro.autor}" />
		</div>
		<div class="form-group">
			<label class="control-label">Temas:</label>
			<select name="idTema" id="idTema" ${disabled} class="form-control" style="width:30%" required="required" >
				<c:forEach items="${temas}" var="tema" >
					<c:set var="selected" value="${tema.idTema == libro.tema.idTema ? 'selected' : ''}" />
					<option value="${tema.idTema}" ${selected}> ${tema.tema}</option>
				</c:forEach>
			</select>
			
		</div>
		<div class="form-group">
		    <label class="control-label" for="precio">precio:</label>
		    <input type="number" required ${disabled} class="form-control" id="precio" name="precio" min="0" max="100" step=".01" style="width:30%" value="${libro.precio}">
		</div>
		<div class="form-group">
		    <label class="control-label" for="paginas">paginas:</label>
		    <input type="number" required ${disabled} class="form-control" id="paginas" name="paginas" style="width:30%" value="${libro.paginas}">
		</div>
		
		<button type="submit" ${disabled} class="btn btn-default">Guardar</button>
		<a type="button" href="libros" class="btn btn-default">Volver</a>
		
	</form>
</div>
</body>
</html>

