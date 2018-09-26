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

<!-- Bootrap -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<h1>Bienvenido a la Pagina Principal</h1>
<%--
	<h1>Lista de Peliculas</h1>
	<ol>
		<c:forEach items="${peliculas}" var="pelicula">
			<li>${pelicula.titulo}</li>		
		</c:forEach>		
	</ol>
	--%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Lista de Peliculas</div>


			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Titulo</th>
							<th>Duracion</th>
							<th>Clasificacion</th>
							<th>Genero</th>
							<th>Imagen</th>
							<th>Fecha Estreno</th>
							<th>Estatus</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${peliculas}" var="pelicula">
							<tr>
								<td>${pelicula.id}</td>
								<td>${pelicula.titulo}</td>
								<td>${pelicula.duracion}</td>
								<td>${pelicula.clasificacion}</td>
								<td>${pelicula.genero}</td>
								<td>${pelicula.imagen}</td>
								<td>${pelicula.fechaEstreno}</td>
								<td>${pelicula.estatus}</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>

</body>
</html>