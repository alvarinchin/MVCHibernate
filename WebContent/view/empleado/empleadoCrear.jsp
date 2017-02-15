 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 <div class="container">
	<div class="form-group">
		<form method="post" action="${baseURL}empleado/crear">
			<input type="text" class="form-control" name="nombre">
			
			<select name="ciudad">
				<c:forEach var="ciudad" items="${ciudades}" >
				<option value="${ciudad.id}">${ciudad.name}</option>
				
				</c:forEach>
				
				
			</select>

			<button class="btn btn-primary" type="submit" >Enviar</button>

		</form>
	</div>
</div>