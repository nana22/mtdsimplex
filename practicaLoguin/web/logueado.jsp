<%-- 
    Document   : logueado
    Created on : 10/01/2010, 02:56:38 PM
    Author     : medina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logueado</title>
    </head>
    <body>
        <p>hola usuario:
<%
      request.getAttribute("usuario");
      request.getAttribute("pass");

      out.write(request.getAttribute("usuario").toString());
                
%>
        </p>
    </body>
</html>