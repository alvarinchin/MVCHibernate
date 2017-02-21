<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${baseURL}">WebSiteName</a>
		</div>

		<ul class="nav navbar-nav">
			<!-- lista de elementos del menu -->
			<!-- Elemento1: ciudades -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Ciudades <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<!-- Paginas dentro del menú -->
					<li><a href="${baseURL}ciudad/listar">Listar</a></li>
					<li><a href="${baseURL}ciudad/crear">Crear</a></li>
					<li><a href="${baseURL}ciudad/modificar">Modificar</a></li>
					<li><a href="${baseURL}ciudad/borrar">Borrar</a></li>
				</ul> </li>
				<!-- Elemento1: ciudades -->
				<!-- Elemento1: Lenguajes programacion -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Lenguajes de Programación <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<!-- Paginas dentro del menú -->
					<li><a href="${baseURL}lenguaje/listar">Listar</a></li>
					<li><a href="${baseURL}lenguaje/crear">Crear</a></li>
					<li><a href="${baseURL}lenguaje/modificar">Modificar</a></li>
					<li><a href="${baseURL}lenguaje/borrar">Borrar</a></li>
				</ul> </li>
				<!-- Elemento1: lenguajes programación -->
				<!-- Elemento1: Empleados -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Empleados <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<!-- Paginas dentro del menú -->
					<li><a href="${baseURL}empleado/listar">Listar</a></li>
					<li><a href="${baseURL}empleado/crear">Crear</a></li>
					<li><a href="${baseURL}empleado/modificar">Modificar</a></li>
					<li><a href="${baseURL}empleado/listar">Borrar</a></li>
				</ul> </li>
				<!-- Elemento1: Empleados -->
	
		</ul>

	</div>
</nav>
</head>
