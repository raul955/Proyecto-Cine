<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Informacion</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

</head>
<body>

	<div align="center">
		<c:forEach items="${listaPel}" var="info">
		<div align="center">
			<img src="${info.imagen}" width="600px" height="500px">
		</div>
		</br>
		<spawn><b>Titulo: </b>${info.nombre}</spawn></br></br>
		<spawn><b>Fecha: </b>${info.fecha}</spawn></br></br>
		<spawn><b>Director: </b>${info.director}</spawn></br></br>
		<spawn><b>Descripcion: </b>${info.descripcion}</spawn></br></br>
		<spawn><b>Calificacion: </b>${info.calificacion}</spawn></br></br>
		
	
	</div>

</br></br>

		<div align="center">
			<form method="POST" action="addCal">
				<input type="text" name="calificacion" required/>
				<input type="hidden" name="id" value="${info.id}"/>
				<input type="submit" value="Calificar" class="btn btn-outline-info" name="descrip"/>
			</form>
		</div>				
</c:forEach>
<div align="center">
<a href="/views/cardPeliculas">
<input align="center" type="submit" value="Volver" class="btn btn-outline-dark" style="height: 45px; width: 500px;"></br></br>
</a>
</div>
	
	</br>
	</br>
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