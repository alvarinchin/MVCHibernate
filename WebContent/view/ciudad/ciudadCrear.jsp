 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 <div class="container">
	<div class="form-group">
		<form method="post" action="${baseURL}ciudad/crear">
			<input type="text" class="form-control" name="nombre">

			<button class="btn btn-primary" type="submit" >Enviar</button>

		</form>
	</div>
</div>