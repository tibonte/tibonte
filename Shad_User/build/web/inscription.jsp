<%-- 
    Document   : inscription
    Created on : 26 oct. 2024, 00:17:47
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inscription</title>
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
    
    <h1>Inscription</h1>
    <form id="car-form" action="VehiculeController" method="post">
        <input type="hidden" name="action" value="inscription">
        <label for="nom_d_utilisateur">Nom d'utilisateur</label>
        <input type="text" id="nom_d_utilisateur" name="nom_d_utilisateur" required><br>

        <label for="Mot_de_passe">Mot de passe</label>
        <input type="password" id="Mot_de_passe" name="Mot_de_passe" required><br>
        
        <input type="submit" value="Inscription">
    </form>
</body>
</html>

