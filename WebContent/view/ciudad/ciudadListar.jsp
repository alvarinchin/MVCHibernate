<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<table class="table-striped">
	<tr>
	<td>Nombre</td>
	
	
	</tr>
	
		<c:forEach var="ciudad" items="${ciudades}">
		<tr>
		<td>${ciudad.nombre}</td>
		</tr>
		</c:forEach>
	
	</table>
</div>