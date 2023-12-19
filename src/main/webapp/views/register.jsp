<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registrate</title>
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
</head>

<body>
	<div id="contenedor">
		<header id="inicio">
			<!-- Navegacion -->
			<nav class="navbar navbar-expand-lg">
				<div class="container-fluid">
					<div class="col-md-4 logo_container">
						<a class="navbar-brand" href="#"> <img loading="lazy"
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
							<li class="nav-item"><a class="nav-link" aria-current="page"
								href="#inicio">Inicio</a></li>
							<li class="nav-item"><a class="nav-link" href="#menu">Menu</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="#nosotros">Sobre
									nosotros</a></li>
							<li class="nav-item"><a class="nav-link" href="#reserva">Reservá</a>
							</li>
							<li class="nav-item"><a class="nav-link" href="/final/login"
								id="login">Iniciar sesión</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- FIN Navegacion -->
		</header>
	</div>

	<main>
		<section id="seccion_user">
			<div class="contact_section" id="form_user">
				<div class="form_container">
					<div class="title_reserva">
						<h4>Registrate</h4>
					</div>
					<form method="post" action="/final/registro">
						<div>
							<div class="campo_container" style="display: block; width: 100%;">
								<label for="nombre">Nombre</label> <input class="campo"
									type="text" name="nombre" id="nombre"
									placeholder="Ingresá tu nombre">
							</div>
							<div class="campo_container" style="display: block; width: 100%;">
								<label for="email">Email</label> <input class="campo"
									type="text" name="email" id="email"
									placeholder="Ingresá tu email">
							</div>
							<div class="campo_container" style="display: block; width: 100%;">
								<label for="password">Contraseña</label> <input class="campo"
									type="password" name="password" id="password"
									placeholder="Ingresá tu contraseña">
							</div>
							<div class="campo_container" style="display: block; width: 100%;">
								<label for="password2">Repetí la contraseña</label> <input
									class="campo" type="password" name="password2" id="password2"
									placeholder="Repetí la contraseña">
							</div>
						</div>
						<div id="message_alert">
							<p class="alerta">¡Hay campos vacíos!</p>
						</div>
						<div class="button_container">
							<button type="submit">Ingresar</button>
						</div>
					</form>
					<div id="info_register">
						<p>
							¿Tenés usuario? Iniciá sesión <a href="/final/login">ACÁ</a>
						</p>
					</div>
				</div>
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
					<p>Inigualable experiencia de sabor y placer acompañan tu
						velada. ¡Te esperamos!</p>
				</div>
			</article>
			<div class="footer_contains">
				<article>
					<div class="footer_subtitle_container">
						<h4>Acceso rápido</h4>
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