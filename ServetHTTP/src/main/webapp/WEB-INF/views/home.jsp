<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Autentica</title>
	
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
	<meta name="description" content="Formulario de autenticacion">
    <meta name="author" content="Andres, Luis">
    
    <!-- Compatibilidad con Internet Explores  -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

	<!-- Hoja de estilo externa enlazada al documento HTML  -->
	<link rel="stylesheet" type="text/css" href="resources/estilos.css"/>
		
	<!--Bootstrap, JQuery -->
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript" src="http://getbootstrap.com/dist/js/bootstrap.js"></script>
	<link type="text/css" rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.css">
	
	
	<!-- Escala en los móviles -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	

</head>
	<body>
		<!-- Menu responsive -->
		<div class="container">
		    <nav role="navigation" class="navbar navbar-inverse">
		        <div class="navbar-header">
		            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
		                <span class="sr-only">Toggle navigation</span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		            </button>
		            <a href="#" class="navbar-brand">Practica 03</a>
		        </div>
		
		        <div id="navbarCollapse" class="collapse navbar-collapse">
		            <form role="search" class="navbar-form navbar-right" method="post" action="http://localhost:8080/gr01/autentica">
						<div class="form-group">
							<label for="usr">Name:</label>
								<input type="text" placeholder="Nombre" class="form-control" name="usuario" value="prueba" required id="usr">
							</div>

							<div class="form-group">
								<label for="pwd">Password:</label>
							 	<input type="password"  placeholder="Password"  class="form-control"name="clave" value="prueba" required>
							</div>
								
							<button type="submit" class="btn btn-info btn-lg btn-sm">loggin</button>
		           </form>
		        </div>
		    </nav>
		</div>

	    <div class="container">
	
	      <!-- Cabecerea-->
	      <div class="jumbotron">
	      	<P> 
	      		Bienvenido, esta apliación permite la utenticación mediante el nombre y el DNI.
	      	 	<br>
	      	 	<small>
	      	 		Conexion: ${serverTime}.
	      	 	</small> 
	      	 </P>
	      </div>
	
	    </div>
		
	</body>
</html>
