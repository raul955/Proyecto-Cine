<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Nueva Pelicula</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

</head>
<body>

<div align="center">
	<h2>Nueva Película</h2>

	<form method="POST" action="nuevaPeliculaa">

		Director: <input type="text" name="director" required/></br>
		</br> Titulo: <input type="text" name="titulo" required/></br>
		</br> Fecha: <input type="text" name="fecha" required/> </br><p>Formato DAY-MONTH-YEAR</p></br>
		</br> ID: <input type="text" name="id" required/></br>
		</br> <input type="submit" value="Crear" class="btn btn-outline-success"/></br>
		</br> <input name="action" value="crearPelicula"
			style="visibility: hidden; display: none;">

	</form>
	<p>${men }</p>


	<a href="/views/mantenimiento"><input type="submit" value="Volver" class="btn btn-outline-danger"/></a>
	</br>
	</br>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>