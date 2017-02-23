
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<div class="form-group">
		<form method="post" action="${baseURL}empleado/crear">
			<div class="form-group">
	
			<label for="nomb">Nombre</label>
				<input id="nomb" type="text" class="form-control" name="nombre">
			</div>
			<div class="form-group">
	
			<label for="nick">Nombre de usuario</label>
				<input id="nick" type="text" class="form-control" name="userName">
			</div>
			<div class="form-group">
	
			<label for="pass">Contraseña</label>
				<input id="pass" type="password" class="form-control" name="password">
			</div>
			
			<div class="form-group">
			<label for="pass">Ciudad</label>
				<select class="form-control" name="ciudad">
					<c:forEach var="ciudad" items="${ciudades}">
						<option value="${ciudad.id}">${ciudad.nombre}</option>

					</c:forEach>
				</select>
			</div>
			<div class="form-group">
			<label>Lenguajes de programación</label>
				<c:forEach var="lenguaje" items="${lenguajes}">
					<div class="checkbox-inline">
						<input name="lenguajes[]" type="checkbox" value="${lenguaje.id}">${lenguaje.nombre}
				</div>
				</c:forEach>
			</div>
		
			<div class="form-group">
				<button class="btn btn-primary" type="submit">Enviar</button>
				</div>
		</form>
	</div>
</div>