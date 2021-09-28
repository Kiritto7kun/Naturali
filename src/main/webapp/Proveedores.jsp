<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bodyProve">
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
        <a href="usuarios.html">Usuarios</a>
        <a href="clientes.html">Clientes</a>
        <a class="active" href="provedores.html"></i>Proveedores</a>
        <a href="productos.html"></i>Productos</a>
        <a href="#"></i>Ventas</a>
        <a href="reportes.html"></i>Reportes</a>
      </div>
    </div>
    <!--boton para abrir menu-->
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menú</span>

    <main>
        <fieldset> <!-- Formulario --> 
            <legend>Gestor de Proveedores</legend>
            <form  action="" method="">
                <div class="columns">
                    <div class="item">
                        <label for="nit">NIT<span>*</span></label>
                        <input type="number" id="nit" name="nit"><br><br>
                    </div>
                    <div class="item">
                        <label for="tel">Teléfono<span>*</span></label>
                        <input type="text" id="tel" name="tel"><br><br>
                    </div>
                     <div class="item">
                        <label for="nom">Nombre Proveedor<span>*</span</label>
                        <input type="text" id="nom" name="nom"><br><br>
                    </div>
                    <div class="item">
                        <label for="ciu">Ciudad<span>*</span></label>
                        <input type="text" id="ciu" name="ciu"><br>
                    </div>
                    <div class="item">
                        <label for="dir">Dirección<span>*</span></label>
                        <input type="text" id="dir" name="dir"><br>
                    </div>
                </div>
                <div class="btn-block"></div>    
                    <button id="consultar">Consultar</button>
				    <button id="crear">Crear</button>
                    <button id="actualizar">Actualizar</button>
                    <button id="borrar">Borrar</button>
                </div>
            </form> 
        </fieldset>
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
