<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Inicio sesión</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    	<link rel="stylesheet" href="css/login-bootstrap.css">
	</head>
	<body>
		<%
			//Se pone a null todos los datos de las sesión
			if(session != null){
				session = request.getSession();
				session.invalidate();
			}
		%>
		
		<div id="main-wrapper" class="container">
			<div class="row justify-content-center">
				<div class="col-xl-10">
					<div class="card border-0">
						<div class="card-body p-0">
							<div class="row no-gutters">
								<div class="col-lg-6">
									<div class="p-5">
										<div class="mb-5">
											<h3 class="h4 font-weight-bold text-theme">Inicio sesión</h3>
										</div>
										<h6 class="h5 mb-0">¡Bienvenido de nuevo!</h6>
										<p class="text-muted mt-2 mb-5">Mete el email y la contraseña para acceder al panel de administrador</p>
										<form method="post" action="Login">
											<div class="form-group">
												<label for="exampleInputEmail1">Email</label>
												<input type="email" class="form-control" name="user" id="exampleInputEmail1">
											</div>
											<div class="form-group mb-5">
												<label for="exampleInputPassword1">Contraseña</label>
												<input type="password" class="form-control" name="password" id="exampleInputPassword1">
											</div>
											<button type="submit" class="btn btn-theme">Iniciar sesión</button>
											<a href="#l" class="forgot-link float-right text-primary">He olvidado mi contraseña</a>
										</form>
									</div>
								</div>
								<div class="col-lg-6 d-none d-lg-inline-block">
									<div class="account-block rounded-right">
										<div class="overlay rounded-right"></div>
										<div class="account-testimonial">
											<h4 class="text-white mb-4">La tienda primerito día</h4>
											<p class="lead text-white">"Una web increible"</p>
											<p>- Luis Mangas</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- end card-body -->
					</div>
					<!-- end card -->
		
					<p class="text-muted text-center mt-3 mb-0">¿No tienes cuenta? <a href="register.html" class="text-primary ml-1">registrar</a></p>
		
					<!-- end row -->
		
				</div>
				<!-- end col -->
			</div>
			<!-- Row -->
		</div>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>