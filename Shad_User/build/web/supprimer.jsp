<%-- 
    Document   : supprimer
    Created on : 25 oct. 2024, 22:48:10
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supprimer</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
         <header class="menu">
             <h1><a href="index.jsp"> AUTO</a></h1>
            <h2><a href="save.jsp">Enregistrer</a></h2>
           <h3><a href="VehiculeController">Afficher les voitures</a></h3>
            <h4><a href="modifier.jsp">Modifier</a></h4>
            <h5><a href="supprimer.jsp">supprimer</a></h5>
        </header>
        <h2>Supprimer une voiture</h2>

    <!-- Formulaire pour entrer l'ID de la voiture à supprimer -->
    <form id="delete-form" action="VehiculeController" method="post">
        <input type="hidden" name="action" value="delete"> 

        <label for="id">ID de la voiture à supprimer:</label>
        <input type="text" id="id" name="id" required><br>

       <input type="submit" value="Supprimer" class="supprimer">
    </form>

    <!-- Section pour afficher un message si la suppression a réussi ou échoué -->
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p style="color: green;"><%= message %></p>
    <%
        } else {
            String error = (String) request.getAttribute("error");
            if (error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <%
            }
        }
    %>
    </body>
</html>
