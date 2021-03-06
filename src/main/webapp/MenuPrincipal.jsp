<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Naturali</title>
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
</head>
<body>
    <aside class="cont">
        <header class="cont_header" >
          <a href="menu.html">
            <div class="logo"></div>
          </a>
            <p>Todo lo que puedas comprar</p>
        </header>
      </aside>
    
    <!--menu-->
    <div id="nav" class="overlay">
      <!--Boton para cerrar-->
      <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
      <div class="content_overlay"> <!-- contenido del menu -->
        <a href="Usuario.jsp">Usuarios</a>
        <a href="Cliente.jsp">Clientes</a>
        <a href="provedores.html">Proveedores</a>
        <a href="productos.html">Productos</a>
        <a href="#">Ventas</a>
        <a href="reportes.html">Reportes</a>
      </div>
    </div>
    <!--boton para abrir menu-->
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menú</span>

    <main>
        <h1 class="bienvenida">BIENVENIDO A SU TIENDA DE CONFIANZA</h1>
        <h3 class="texto">Le invitamos a revisar nuestro Menú</h3>
    </main>

  <script>
      function openNav() {
        document.getElementById("nav").style.width = "31%";
      }
      
      function closeNav() {
        document.getElementById("nav").style.width = "0%";
      }
  </script>

    <footer><a target="blank">Copyright @Equipo5G10_MinTic</a></footer>
</body>
</html>