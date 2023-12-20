<%@ page import="java.util.List"%>
<%@ page import="com.restaurant.modelo.Plato"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mi perfil</title>
</head>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<!-- FontAwesome -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous" defer></script>

<!-- Css -->
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/form_user.css">

<body>

	<div id="contenedor">
		<header id="inicio">
			<!-- Navegacion -->
			<nav class="navbar navbar-expand-lg">
				<div class="container-fluid">
					<div class="col-md-4 logo_container">
						<a class="navbar-brand" href="/final"> <img loading="lazy"
							src="images/logos/logo-sin-fondo.png" alt="Bootstrap">
						</a>
					</div>
					<button class="navbar-toggler border-0" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse flex-grow-0" id="navbarNav">
						<ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="/final">Inicio</a>
                            </li>
							<li class="nav-item"><a class="nav-link" href="#menu">Menu</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#nosotros">Sobre
									nosotros</a></li>
							<li class="nav-item"><a class="nav-link" href="#reserva">Reservá</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="/final"
								id="login">Cerrar sesión</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- FIN Navegacion -->
		</header>
	</div>

	<main>
		<div>
			<h2 class="p-2">Bienvenido Administrador</h2>
		</div>

		<section class="my-3">
			<h3 class="p-2 text-decoration-underline">Menú del día</h3>
			<div class="w-75 mx-auto">
				<div class="text-end"><a href="/final/plato/agregar"><button type="button" class="btn btn-primary">Crear plato</button></a></div>
				<table class="table my-3">
					<thead>
						<tr>
							<th scope="col">Plato</th>
							<th scope="col">Descripción</th>
							<th scope="col">Precio</th>
							<th scope="col">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="plato" items="${menu}">
							<tr>
								<td>${plato.nombre}</td>
								<td>${plato.descripcion}</td>
								<td>${plato.precio}</td>
								<td class="d-flex">
									<a href="/final/plato/editar?id=${plato.id}"><button type="button" class="btn btn-success">Editar</button></a>
									<form class="ms-1" method="POST" action="/final/plato/eliminar/${plato.id}?_method=DELETE"><button type="submit" class="btn btn-danger">Eliminar</button></form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</main>


	<footer>
		<div class="footer_container">
			<article class="footer_logo">
				<div>
					<h2>La luna y la miel</h2>
				</div>
				<div>
					<p>Inigualable experiencia de sabor y placer acompaÃ±an tu
						velada. ¡Te esperamos!</p>
				</div>
			</article>
			<div class="footer_contains">
				<article>
					<div class="footer_subtitle_container">
						<h4>Acceso rapido</h4>
					</div>
					<ul>
						<li><a class="links" href="#inicio">Inicio</a></li>
						<li><a class="links" href="#nosotros">Sobre nosotros</a></li>
						<li><a class="links" href="#menu">Menú</a></li>
						<li><a class="links" href="#reserva">Reservá</a></li>
					</ul>
				</article>
				<article>
					<div class="footer_subtitle_container">
						<h4>Ayuda</h4>
					</div>
					<ul>
						<li><a class="links" href="#visitanos">Visitanos</a></li>
						<li><a class="links" href="#">Medios de pago</a></li>
						<li><a class="links" href="#">Delivery</a></li>
					</ul>
				</article>
				<article>
					<div class="footer_subtitle_container">
						<h4>Redes</h4>
					</div>
					<ul id="footer_social">
						<li><a href="http://www.facebook.com" target="_blank"
							rel="noopener noreferrer"><i class="fa-brands fa-facebook"></i></a></li>
						<li><a href="http://www.instagram.com" target="_blank"
							rel="noopener noreferrer"><i class="fa-brands fa-instagram"></i></a></li>
						<li><a href="http://www.twitter.com" target="_blank"
							rel="noopener noreferrer"><i class="fa-brands fa-x-twitter"></i></a></li>
						<li><a href="https://github.com/BrianFloresOk"
							target="_blank" rel="noopener noreferrer"><i
								class="fa-brands fa-github"></i></a></li>
					</ul>
				</article>
			</div>
		</div>
		<div id="copy">
			<p>&COPY; Copyright 2023 - La luna y la miel</p>
		</div>
	</footer>
</body>

</html>