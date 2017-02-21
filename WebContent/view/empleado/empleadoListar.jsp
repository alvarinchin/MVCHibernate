<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th><th>Ciudad</th><th>Nombre Usuario</th><th>Lenguajes</th>
	</tr>
	
	</thead>
		<c:forEach var="empleado" items="${empleados}">
		<tr>
		<td>${empleado.nombre}</td><td>${empleado.ciudad.nombre}</td><td>${empleado.username}</td>
		<td>
		<c:forEach var="lenguaje" items="${empleado.lenguajes}">${lenguaje.nombre} </c:forEach>
		</td>
		
		</tr>
		</c:forEach>
	
	</table>
</div>