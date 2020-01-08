<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><p>Películas</p></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h2 align="center">Listado de películas</h2>
	
	<form method="POST" action="filtrado">
	<input class="form-control" type="text" aria-label="Search" placeholder="Buscar..." name="nombre"/>
	<input type="submit" value="Buscar" class="btn btn-outline-success">
	</form>


	<div class="row justify-content-md-center">
		
			<c:forEach items="${listaPel}" var="info">
				<div class="card" style="width: 18rem; margin-right: 6px; margin-top: 6px;" class="col-6 col-md-4 col-lg-3">
				<img class="card-img-top" src="${info.imagen}" alt="Card image cap" width="120px" height="180px">
					<ul class="list-group list-group-flush">
					<div class="card-header"><b>Director:</b> ${info.director}</div>
						<li class="list-group-item"><b>Titulo:</b> ${info.nombre}</li>
						<li class="list-group-item"><b>Fecha:</b> ${info.fecha}</li>
					</ul>				
				</div>
				</br> </br>
			</c:forEach>
		
	</div>
	</br>



	<div align="center">
		<a href="/views/index"><input type="submit" value="Inicio"
			class="btn btn-outline-danger" /></a>
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