<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>El usuario <%=request.getParameter("user")%> con contraseña
	<%=request.getParameter("pwd") %> no está registrado</h1>
	<br/>
	<a href="formulario.html">Volver</a>
</body>
</html>