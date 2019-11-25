<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Directores Consultados</title>
</head>
<body>
<h2>Directores Consultados</h2>

<table id="tabla">
		<tr>		
			<td style="height: 28px; width: 150px;">Director</td>
		<tr>	
		<c:forEach items="${men}" var="info">
			<tr>
				
				<td>${info.director }</td>
				
			</tr>
		</c:forEach>
	</table>
	
	</br></br>
	<a href="consultaDir.jsp"><input type="button" value="Otra consulta"/></a></br></br>
	<a href="index.jsp"><input type="button" value="Inicio"/></a>

</body>
</html>