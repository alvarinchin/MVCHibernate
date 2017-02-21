<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">

	<form method="post" action="${baseURL}lenguaje/modificar">

		<div class="form-group">
			<label>Modifica el lenguaje</label> <input name="nombre" type="text"
				class="form-control" value="${lenguaje.nombre}">
		</div>
		<input name="id" type="hidden" value="${lenguaje.id}">
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Enviar</button>
		</div>
	</form>

</div>