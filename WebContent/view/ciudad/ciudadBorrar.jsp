<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>


<script>
window.onload=function(){
	listar();
}
function borrar(id){

	var ajax= new XMLHttpRequest();
	ajax.open("POST", "${baseURL}ciudad/borrar", true);
	ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4 && ajax.status==200){
			listar();
		}

	}
	ajax.send("id="+id);

}
function listar(){

	var ajax= new XMLHttpRequest();
	ajax.open("GET", "${baseURL}ciudad/listarAjax", true);
	ajax.onreadystatechange=function(){
		if(ajax.readyState==4 && ajax.status==200){
			
			document.getElementById("listado").innerHTML=ajax.responseText;
		}

	}
	ajax.send(null);

}
</script>
<div class="container">

	<table class="table table-striped">
	<thead>
	<tr>
	<th>Nombre</th>
	
	
	</tr>
	</thead>
	<tbody id="listado">
	</tbody>
		
	
	</table>
</div>