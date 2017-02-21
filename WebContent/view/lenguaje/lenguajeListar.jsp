<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th>
	
	
	</tr>
	</thead>
		<c:forEach var="lenguaje" items="${lenguajes}">
			<form action="${baseURL}lenguaje/modificar">
		<tr>
		<td>${lenguaje.nombre}</td><td><input type="hidden" name="id" value="${lenguaje.id}"><button class="btn btn-primary" type="submit">Modificar</button></td>
		</tr>
		</form>
		</c:forEach>
	
	</table>
</div>