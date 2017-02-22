
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<div class="form-group">
		<form method="post" action="${baseURL}empleado/crear">
			<div class="form-group">

				<label for="nomb">Nombre</label> <input id="nomb" type="text"
					class="form-control" name="nombre" value="${empleado.nombre}">
			</div>
			<div class="form-group">

				<label for="nick">Nombre de usuario</label> <input id="nick"
					type="text" class="form-control" name="userName"
					value="${empleado.username}">
			</div>
			<div class="form-group">

				<label for="pass">Contraseña</label> <input id="pass" type="text"
					class="form-control" name="password" value="${empleado.password}">
			</div>

			<div class="form-group">
				<label for="pass">Ciudad</label> <select class="form-control"
					name="ciudad">
					<c:forEach var="ciudad" items="${ciudades}">
						<c:choose>
							<c:when test="${ciudad == empleado.ciudad}">
								<option selected="selected" value="${ciudad.id}">${ciudad.nombre}</option>
							</c:when>
							<c:otherwise>
								<option value="${ciudad.id}">${ciudad.nombre}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Lenguajes de programación</label>
				<c:forEach var="lenguaje" items="${lenguajes}">
					<c:forEach var="lenguajeSelec" items="${empleado.lenguajes}">
						<c:choose>
							<c:when test="${lenguaje.nombre == lenguajeSelect.nombre}">
								<input name="lenguajes[]" type="checkbox" checked="checked"
									value="${lenguaje.id}">${lenguaje.nombre}>
							</c:when>
							<c:otherwise>
								<input name="lenguajes[]" type="checkbox" value="${lenguaje.id}">${lenguaje.nombre}
							</c:otherwise>
						</c:choose>
						<div class="checkbox-inline">
					</c:forEach>
				</c:forEach>
			</div>

			<div class="form-group">
				<button class="btn btn-primary" type="submit">Enviar</button>
		</form>
	</div>
</div>