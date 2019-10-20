<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Peliculas</title>
    
    <!-- Ruta relativa nuestros recursos -->
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/peliculas/create" var="urlForm" />
	<spring:url value="/peliculas/edit" var="urlEdit" />
	<spring:url value="/peliculas/delete" var="urlDelete" /> 
	<spring:url value="/peliculas" var="urlPeliculas" />
	
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>
    
	<div class="container theme-showcase" role="main">
      <h3>Listado de Peliculas</h3>
      
      <c:if test="${mensaje!=null }">
    	<div class='alert alert-success' role="alert">${mensaje}</div>
      </c:if>
      
      <a href="${urlForm}" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
	       <thead>     
	            <tr>
	                <th>Titulo</th>
	                <th>Genero</th>
	                <th>Clasificacion</th>
	                <th>Duracion</th>
	                <th>Fecha Estreno</th>
	                <th>Estatus</th>
	                <th>Opciones</th>
	            </tr>
	        </thead>
		    <tbody>  
<%-- 		    	<c:forEach items="${peliculas}" var="pelicula"> sin paginado--%>
	            <c:forEach items="${peliculas.content}" var="pelicula">
					<tr>						
						<td>${pelicula.titulo}</td>
						<td>${pelicula.genero}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.duracion}</td>
						<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy" /></td>
						<!-- Incluir un condicional -->
						<!-- Formato fecha jstl -->
						<td><c:choose>
								<c:when test="${pelicula.estatus == 'Activa'}">
									<span class="label label-success">ACTIVA</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">INACTIVA</span>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
		                    <a href="${urlEdit}/${pelicula.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
		                    <a href="${urlDelete}/${pelicula.id}" onclick='return confirm("¿Estas Seguro de Eliminar?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
		                    <!--alter: <a href="${ urlDel }/${ p.id }/${ p.detalle.id }" -->
		                </td>											
					</tr>
				</c:forEach>
	       </tbody>     
        </table>
        
     	<nav aria-label="">
			<ul class="pager">
				<li><a href="${urlPeliculas}/indexPaginate?page=${peliculas.number - 1}">Anterior</a></li>
				<li><a href="${urlPeliculas}/indexPaginate?page=${peliculas.number + 1}">Siguiente</a></li>
			</ul>
		</nav>
						        
        
      </div>
          
      <hr class="featurette-divider">

     <!-- FOOTER -->
     <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
