<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">

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
</div>