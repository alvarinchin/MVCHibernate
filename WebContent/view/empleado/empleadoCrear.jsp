
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<div class="form-group">
		<form method="post" action="${baseURL}empleado/crear">
			<div class="form-group">
	
			<label for="nomb">Nombre</label>
				<input id="nomb" type="text" class="form-control" name="nombre">
			</div>
			<div class="form-group">
				<select class="form-control" name="ciudad">
					<c:forEach var="ciudad" items="${ciudades}">
						<option value="${ciudad.id}">${ciudad.nombre}</option>

					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<c:forEach var="lenguaje" items="${lenguajes}">
					<div class="checkbox-inline">
						<input name="lenguajes[]" type="checkbox" value="${lenguaje.id}">${lenguaje.nombre}
				</c:forEach>
			</div>
		
			<div class="form-group">
				<button class="btn btn-primary" type="submit">Enviar</button>
		</form>
	</div>
</div>