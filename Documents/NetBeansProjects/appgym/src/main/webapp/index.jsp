<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cliente</title>
    </head>
    <body>
        <h1>ingreso de clientes</h1>
        <form action="controlador" method="POST">
            Identificacion:<input type="text" name="identificacion" value="" />
            <br>
            Nombres:<input type="text" name="nombres" value="" />
            Apellido 1:<input type="text" name="apellido1" value="" />
            Apellido 2:<input type="text" name="apellido2" value="" />
            <br>
            <input type="submit" value="Grabar" />
        </form>
    </body>
</html>
