<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
<<<<<<< HEAD
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
=======

	<form method="post" action="${baseURL}ciudad/modificar">
	<div class="form-control">
	<label>Modifica la ciudad</label>
		<input name="nombre" type="text" class="form-control" value="${ciudad.nombre}">
		<input name="id" type="hidden" value="${ciudad.id}">
	</div>
	<div class="form-control">
		<button type="submit" class="btn btn-primary">Enviar</button>
	</div>
	</form>
>>>>>>> 8734205f96be45273ad9c0b7d3ddb4a7256f1155
</div>