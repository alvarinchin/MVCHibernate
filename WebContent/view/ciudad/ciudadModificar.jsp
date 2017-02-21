<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th>
	
	
	</tr>
	</thead>
		<c:forEach var="ciudad" items="${ciudad}">
		<tr>
		<td>${ciudad.nombre}</td><td><button >Modificar</button></td>
		</tr>
		</c:forEach>
	
	</table>
</div>