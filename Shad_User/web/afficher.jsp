<%-- 
    Document   : afficher
    Created on : 25 oct. 2024, 22:47:43
    Author     : owner
--%>

<%@page import="java.util.List"%>
<%@page import="model.Vehicule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>afficher</title>
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
<h2>Liste des Voitures</h2>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Marque</th>
            <th>Modèle</th>
            <th>Prix</th>
            <th>Année </th>
            <th>Couleur</th>
            
        </tr>
    </thead>
    <tbody>
        <%
            List<Vehicule> List = (List<Vehicule>) request.getAttribute("List");
            for (Vehicule vehicule : List) {
        %>
        <tr>
            <td><%= vehicule.getId() %></td>
            <td><%= vehicule.getMarque() %></td>
            <td><%= vehicule.getModele() %></td>
            <td><%= vehicule.getPrix() %></td>
             <td><%= vehicule.getAnnee() %></td>
            <td><%= vehicule.getCouleur() %></td>
           
        </tr>
        <%
            }
        %>
    </tbody>
</table>
    </body>
</html>
