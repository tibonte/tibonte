<%-- 
    Document   : modifier
    Created on : 25 oct. 2024, 22:47:59
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier</title>
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
    
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p style="color: green;"><%= message %></p>
    <%
        }
    %>
    <h2>Modifier une Voiture</h2>
    <form id="car-form" action="VehiculeController" method="get">
        <label for="id">ID de la Voiture :</label>
        <input type="text" name="id" required>
        <input type="submit" value="Modifier">
    </form>

    <c:if test="${not empty requestScope.vehicule}">
        <h3>Détails de la Voiture :</h3>
        <form id="car-from" action="VehiculeController" method="post">
            <input type="hidden" name="action" value="modify">

            <input type="hidden" name="id" value="${requestScope.vehicule.id}">
            <label for="marque">Marque :</label>
            <input type="text" name="marque" value="${requestScope.vehicule.marque}" required><br>
            
            <label for="modele">Modèle :</label>
            <input type="text" name="modele" value="${requestScope.vehicule.modele}" required><br>
            
            <label for="prix">Prix :</label>
            <input type="number" name="prix" value="${requestScope.vehicule.prix}" required><br>
            
             <label for="annee">Année de Sortie :</label>
            <input type="number" name="annee" value="${requestScope.vehicule.annee}" required><br>
            
            <label for="couleur">Couleur :</label>
            <input type="text" name="couleur" value="${requestScope.vehicule.couleur}" required><br>
            
           
            <input type="submit" value="Modifier" class="modifier">

        </form>
    </c:if>
    </body>
</html>
