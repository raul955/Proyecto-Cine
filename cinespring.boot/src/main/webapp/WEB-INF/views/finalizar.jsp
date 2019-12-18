<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Directores Consultados</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

</head>
<body>
	<div align="center" class="row justify-content-center">
		<div class="col-auto">
			<h2>Directores Consultados</h2>

			<table id="tabla" class="mt-5 table table-striped table-inverse table-responsive table-center text-center">
				<tr>
					<td style="height: 28px; width: 150px;"><b>Directores
							consultados:</b></td>
				<tr>
					<c:forEach items="${men}" var="info">
						<tr>

							<td>${info}</td>

						</tr>
					</c:forEach>
			</table>

			</br> </br> <a href="consult"><input type="button" value="Otra consulta"
				class="btn btn-outline-primary" /></a> </br> </br>
			<!-- <a href="index.jsp"><input type="button" value="Inicio"/></a> -->
			<form method="POST" action="fin">
				<input type="submit" value="Inicio" class="btn btn-outline-danger" /></br>
				</br> <input name="action" value="inicio"
					style="visibility: hidden; display: none;">
			</form>
		</div>
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