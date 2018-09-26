<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a Cineapp</title>
</head>
<body>
<h1>Bienvenido a la Pagina Principal</h1>

	<h1>Lista de Peliculas</h1>
	<ol>
		<c:forEach items="${peliculas}" var="pelicula">
			<li>${pelicula}</li>		
		</c:forEach>		
	</ol>

</body>
</html>