<%-- 
    Document   : home
    Created on : 01-may-2017, 20:45:03
    Author     : Ismael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ejemplo de vista Spring</title>
    </head>
    <body>
        <h1>Datos del usuario</h1>
        <ul>
            <li>ID = ${id}</li>
            <li>Nombre = ${nombre}</li>
            <li>Apellido = ${apellido}</li>
        </ul>
    </body>
</html>
