<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th><th>Ciudad</th><th>Nombre Usuario</th><th>Lenguajes</th>
	</tr>
	
	</thead>
		<c:forEach var="empleado" items="${empleados}">
		<form action="${baseURL}empleado/modificar">
		<tr>
		<td>${empleado.nombre}</td><td>${empleado.ciudad.nombre}</td><td>${empleado.username}</td>
		<td>
		<c:forEach var="lenguaje" items="${empleado.lenguajes}">${lenguaje.nombre} </c:forEach>
		</td>
		<td><input type="hidden" name="id" value="${empleado.id}"><button class="btn btn-primary" type="submit">Modificar</button></td>
		
		
		</tr>
		</form>
		</c:forEach>
	
	</table>
</div>