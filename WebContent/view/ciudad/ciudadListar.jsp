<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">

	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th>
	
	
	</tr>
	</thead>
		<c:forEach var="ciudad" items="${ciudades}">
		<form action="${baseURL}ciudad/modificar">
		<tr>
		<td>${ciudad.nombre}</td><td><input type="hidden" name="id" value="${ciudad.id}"><button class="btn btn-primary" type="submit">Modificar</button></td>
		</tr>
		</form>
		</c:forEach>
	
	</table>
</div>