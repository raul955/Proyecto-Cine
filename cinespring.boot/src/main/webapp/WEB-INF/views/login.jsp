<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
</head>
<body>
	<h2 align="center">Login</h2>
	<form method="POST" action="login">
		</br> </br>
		<div align="center">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Usuario: <input type="text"
				name="usuario" /></br> </br> Contraseņa: <input type="text" name="password" /></br>
			</br> <input type="submit" value="Iniciar" class="btn btn-outline-success" /></br>
			<input name="action" value="loginValidate"
				style="visibility: hidden; display: none;">
	</form>
	</div>

	<table id="tablaLogin" align="center">

		<c:forEach items="${listaUsr}" var="info">
			<tr>
				<td>${info.usuario }</td>
			</tr>
		</c:forEach>
	</table>

	<div align="center">
		<a href="/views/index"><input type="button"
			class="btn btn-outline-danger" value="Inicio" /></a>
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