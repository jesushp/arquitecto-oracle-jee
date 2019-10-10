<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Usuario"%>
    
<% Usuario persona=(Usuario)session.getAttribute("persona"); %>    

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">

    <title>Admin usuarios</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	
	<jsp:include page="includes/nav.jspf"></jsp:include>
	  
	  <div class="container">

      <div class="starter-template">
        <h1>Admin Ususarios</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
      </div>
		
		<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
			<ul class="list-group">
			<li class="list-group-item">Usuario:<%=persona.getNombre() %></li>
			<li class="list-group-item">Email:<%=persona.getEmail() %></li>
			<li class="list-group-item">Edad:<%=persona.getEdad() %></li>
		</ul>
		</div>
		<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
		<form action="carrito" method="POST" role="form">
			<legend>Admin usuarrios</legend>

				<div class="form-group">
					<label for="producto">Nombre</label>
					<input type="text" class="form-control" id="producto" name="nombre" placeholder="Input field">
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<input type="password" class="form-control" id="password" name="password" placeholder="Input field">
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<input type="text" class="form-control" id="email" name="email" placeholder="Input field">
				</div>
				<div class="form-group">
					<label for="edad">Edad</label>
					<input type="number" class="form-control" id="edad" name="edad" placeholder="Input field">
				</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		</div>
		
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
