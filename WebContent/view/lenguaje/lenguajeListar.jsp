<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th>
	
	
	</tr>
	</thead>
		<c:forEach var="lenguaje" items="${lenguajes}">
		<tr>
		<td>${lenguaje.nombre}</td>
		</tr>
		</c:forEach>
	
	</table>
</div>