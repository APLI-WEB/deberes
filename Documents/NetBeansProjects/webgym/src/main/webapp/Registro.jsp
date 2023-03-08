<%-- 
    Document   : Registro
    Created on : 20 ene. 2023, 22:38:18
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="registro.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <br>
        <h1>REGISTRATE</h1>
        <br>
             <form method="post" action="registro">        
            <label for="Nombre"> nombres: </label>
             <input type="text" name="nombre">
             <br><br>
             <label for="Apellido" size="40"> apellidos: </label>
             <input type="text" name="apellido">
             <br><br>
             <label for="edad" min="1900">edad</label>
             <input type="text" name="edad">
             <br><br>
             <label for="Email">email</label>
             <input type="text" name="email" >
             <br><br>
             <label for="Nombre"> usuario: </label>
             <input type="text" name="usuario">
              <br><br>
             <label for="Contraseña">clave</label>
             <input type="clave" name="clave" minlength="6">
             <br><br>
         
     <nav class="navbar">
         
            <a href="index.html" >enviar</a>
        </nav>
             <img src="GYM4.jpg" alt=""/>
     </form>
    </body>
</html>
