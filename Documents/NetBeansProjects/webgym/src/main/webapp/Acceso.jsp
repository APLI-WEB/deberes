<%-- 
    Document   : Acceso
    Created on : 20 ene. 2023, 22:38:34
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html> 
<html> 
  <head> 
      <link rel="stylesheet" href="acceso.css">

    <meta charset="utf-8"> 
    <title>Login Form Design One | Fazt</title> 
    <link rel="stylesheet" href="/css/master.css"> 
  </head> 
  <body> 
 
    <div class="login-box"> 
      <img src="img/logo.png" class="avatar"> 
      <h1>Login Here</h1> 
      <form> 
        <!-- USERNAME INPUT --> 
        <label for="username">Username</label> 
        <input type="text" placeholder="Enter Username"> 
        <!-- PASSWORD INPUT --> 
        <label for="password">Password</label> 
        <input type="password" placeholder="Enter Password"> 
        
        
         <a href="enviar.form.jsp">Log In</a><br> 
         
        <a href="#">Lost your Password?</a><br> 
        <a href="#">Don't have An account?</a> 
      </form> 
    </div> 
  </body> 
</html>