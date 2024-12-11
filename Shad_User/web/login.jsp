<%-- 
    Document   : login
    Created on : 26 oct. 2024, 00:38:36
    Author     : owner
--%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <!-- Message d'erreur ou de succès -->
    <% 
        String message = (String) request.getAttribute("message");
        String error = (String) request.getAttribute("error");
    %>
    <div class="message">
        <% if (message != null) { %>
            <p style="color: green;"><%= message %></p>
        <% } else if (error != null) { %>
            <p style="color: red;"><%= error %></p>
        <% } %>
    </div>

    <h1>Connexion</h1>
    <form id="car-form" action="VehiculeController" method="post">
        <input type="hidden" name="action" value="login">
        
        <label for="nom_d_utilisateur">Nom d'utilisateur :</label>
        <input type="text" id="username" name="nom_d_utilisateur" required><br>

        <label for="Mot_de_passe">Mot de passe :</label>
        <input type="password" id="Mot_de_passe" name="Mot_de_passe" required><br>
        
        <input type="submit" value="Se connecter">
    </form>
</body>
</html>
