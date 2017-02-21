<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">

	<form method="post" action="${baseURL}ciudad/modificar">

		<div class="form-group">
			<label>Modifica la ciudad</label> <input name="nombre" type="text"
				class="form-control" value="${ciudad.nombre}">
		</div>
		<input name="id" type="hidden" value="${ciudad.id}">
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Enviar</button>
		</div>
	</form>

</div>