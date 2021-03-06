<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuario</title>
    <link rel="stylesheet" href="CSS/menu.css">
    <link rel="stylesheet" type="text/css" href="CSS/stylevistas.css">
</head>
<body class="bodyUsu">
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
        <a class="active" href="Usuario.jsp">Usuarios</a>
        <a href="Cliente.jsp">Clientes</a>
        <a href="provedores.html">Proveedores</a>
        <a href="productos.html">Productos</a>
        <a href="#">Ventas</a>
        <a href="reportes.html">Reportes</a>
      </div>
    </div>
    <!--boton para abrir menu-->
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menú</span>

<%
//Conexion con=new Conexion();
//con.conexiondb();
String d="",e="",n="",c="",u="";
if(request.getParameter("c")!= null){
	d=request.getParameter("c");
	e=request.getParameter("cor");
	n=request.getParameter("no");
	c=request.getParameter("co");
	u=request.getParameter("us");
}
%>

    <main>
        <fieldset> <!-- Formulario --> 
            <form  action="Menus" method="post">
                <div class="columns">
                    <div class="item">
                        <label for="cc">Cédula<span>*</span></label>
                        <input type="number" id="cc" name="cc" value="<%=d%>"><br><br>
                    </div>
                    <div class="item">
                        <label for="usu">Usuario<span>*</span></label>
                        <input type="text" id="usu" name="usu" value="<%=u%>"><br><br>
                    </div>
                     <div class="item">
                        <label for="nom">Nombre Completo<span>*</span></label>
                        <input type="text" id="nom" name="nom" value="<%=n%>"><br><br>
                    </div>
                    <div class="item">
                        <label for="con">Contraseña<span>*</span></label>
                    <input type="password" id="con" name="con" value="<%=c%>"><br><br>
                    </div>
                    <div class="item">
                        <label for="corr">Correo Electrónico<span>*</span></label>
                        <input type="email" id="corr" name="corr" value="<%=e%>"><br>
                    </div>
                </div>
                <div class="btn-block"></div>    
                    <button id="consultar" name="btncon">Consultar</button>
				    <button id="crear" name="btncre">Crear</button>
                    <button id="actualizar" name="btnact">Actualizar</button>
                    <button id="borrar" name="btnbor">Borrar</button>
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
