	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	
	<c:forEach var="ciudad" items="${ciudades}">
		<form action="${baseURL}ciudad/borrar">
		<tr>
		<td>${ciudad.nombre}</td><td><input type="hidden" name="id" value="${ciudad.id}"><button class="btn btn-danger" type="button" onclick="borrar(${ciudad.id})"><span class="glyphicon glyphicon-remove"></span></button></td>
		</tr>
		</form>
		</c:forEach>