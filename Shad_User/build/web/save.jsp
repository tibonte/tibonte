<%-- 
    Document   : save
    Created on : 25 oct. 2024, 22:47:51
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save</title>
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

    <!-- Section pour afficher un message de succès s'il existe -->
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p style="color: green;"><%= message %></p>
    <%
        }
    %>
   
    <h2>Ajouter une voiture</h2>
    
    <form id="car" action="VehiculeController" method="post">
        <input type="hidden" name="action" value="add"> <!-- Champ caché -->

        <label for="marque">Marque:</label>
        <input type="text" id="marque" name="marque" required><br>

        <label for="modele">Modèle:</label>
        <input type="text" id="modele" name="modele" required><br>

        <label for="prix">Prix:</label>
        <input type="number" id="prix" name="prix" required><br>
        
         <label for="annee">Année :</label>
        <input type="number" id="annee_sortie" name="annee_sortie" required><br>

        <label for="couleur">Couleur:</label>
        <input type="text" id="couleur" name="couleur" required><br>

       
        <input type="submit" value="Enregistrer">
    </form>

    </body>
</html>
