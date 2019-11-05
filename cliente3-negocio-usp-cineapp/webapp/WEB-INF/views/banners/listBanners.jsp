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
    <title>Listado de imagenes del banner</title>
    
      <!-- Ruta relativa nuestros recursos -->
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/banners/create" var="urlForm" />
	<spring:url value="/banners/edit" var="urlEdit" />
	<spring:url value="/banners/delete" var="urlDelete" /> 
	<spring:url value="/banners" var="urlHorarios" />
	
	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de imagenes del Banner</h3>
      
      <c:if test="${msg!=null }">
    	<div class='alert alert-success' role="alert">${msg}</div>
      </c:if>
      
      <a href="${urlForm}" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
        	<thead>
	            <tr>
	                <th>Id</th>
	                <th>Titulo</th>                           
	                <th>Fecha Publicacion</th>              
	                <th>Nombre Archivo</th>
	                <th>Estatus</th>
	                <th>Opciones</th>              
	            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${banners}" var="banner">
					<tr>						
						<td>${banner.id}</td>
						<td>${banner.titulo}</td>
						<td><fmt:formatDate value="${banner.fecha}" pattern="dd-MM-yyyy" /></td>
						<td>${banner.archivo}</td>						
						<!-- Incluir un condicional -->
						<!-- Formato fecha jstl -->
						<td>
							<c:choose>
								<c:when test="${banner.estatus == 'Activo'}">
									<span class="label label-success">ACTIVA</span>
								</c:when>
								<c:otherwise>
									<span class="label label-danger">INACTIVA</span>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
		                    <a href="${urlEdit}/${banner.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
		                    <a href="${urlDelete}/${banner.id}" onclick='return confirm("�Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
		                </td>											
					</tr>
				</c:forEach>
            </tbody>
            
            
        </table>
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
