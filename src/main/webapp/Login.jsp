<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="CSS/styleLogin.css">
		<meta charset="ISO-8859-1">
	</head>
<body>
	<form action="Login" method="get">
		<br>
		<div class="login-box">
			<img src="Imagenes/logo.jpg" class="avatar" alt="Avatar Image">
      		<h1>MINTIC</h1>
			<br>
			<h2 style="text-align: center">TIENDA NATURAL</h2>
			<br>
			<br>
			<label class="info-label">Usuario:</label>
			<input type= "text"  name="us">
			<label class="info-label">Contraseña:</label>
			<input type= "password" name="pass">
			<input type= "submit" class="boton" name="btnlogin" value="Login">
		</div>
	</form>
</body>
</html>
