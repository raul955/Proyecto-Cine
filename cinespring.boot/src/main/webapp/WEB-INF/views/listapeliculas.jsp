<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Peliculas del Director</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
</head>
<body>
<div align="center">
	<h2>Peliculas del Director:</h2>
	<table id="tabla" border="1px">
		<tr>
			<td style="height: 28px; width: 150px;">Nombre</td>
			<td style="height: 28px; width: 150px;">Director</td>
			<td style="height: 28px; width: 150px;">Fecha</td>
			<td style="height: 28px; width: 150px;">ID</td>
		<tr>
			<c:forEach items="${listaPel}" var="info">
				<tr>
					<td>${info.nombre }</td>
					<td>${info.director }</td>
					<td>${info.fecha }</td>
					<td>${info.id }</td>
				</tr>
			</c:forEach>
	</table>

	<a href="/views/consultaDir"><input type="submit" value="Volver" class="btn btn-outline-danger"/></a>

	<form method="POST" action="finalizar">
		<input type="submit" value="Finalizar" class="btn btn-outline-success"/></br>
		</br> <input name="action" value="finalizar"
			style="visibility: hidden; display: none;">
	</form>
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