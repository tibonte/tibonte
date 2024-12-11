package controller;

import model.ConnectionDB;
import model.Vehicule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import model.Login;
//import model.Login;

public class VehiculeController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Code pour ajouter une voiture
            String marque = request.getParameter("marque");
            String modele = request.getParameter("modele");
            int prix = Integer.parseInt(request.getParameter("prix"));
            String couleur = request.getParameter("couleur");
            int annee = Integer.parseInt(request.getParameter("annee_sortie"));

            Vehicule vehicule = new Vehicule(marque, modele, prix, annee, couleur);
            ConnectionDB.saveVoiture(vehicule);

            String message = "La voiture a été enregistrée avec succès !";
            request.setAttribute("message", message);
            request.getRequestDispatcher("save.jsp").forward(request, response);
        } 
        else if ("modify".equals(action)) {
            // Code pour modifier une voiture
            String idStr = request.getParameter("id");
            if (idStr != null) {
                try {
                    int id = Integer.parseInt(idStr);
                    String marque = request.getParameter("marque");
                    String modele = request.getParameter("modele");
                    int prix = Integer.parseInt(request.getParameter("prix"));
                    int annee = Integer.parseInt(request.getParameter("annee"));
                    String couleur = request.getParameter("couleur");
                    

                    Vehicule vehicule = new Vehicule(marque, modele, prix,annee, couleur );
                    vehicule.setId(id);
                    ConnectionDB.updateVoiture(vehicule);

                    String message = "La voiture a été modifiée avec succès !";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("modifier.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Erreur de format.");
                    request.getRequestDispatcher("modifier.jsp").forward(request, response);
                }
            }
        } 
        else if ("delete".equals(action)) {
            // Code pour supprimer une voiture
            String idStr = request.getParameter("id");
            if (idStr != null) {
                try {
                    int id = Integer.parseInt(idStr);
                    ConnectionDB.deleteVoiture(id); // Assurez-vous que la méthode deleteVoiture(id) existe dans DBConnection
                    String message = "La voiture a été supprimée avec succès !";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("supprimer.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "ID invalide.");
                    
                }
            }
            request.getRequestDispatcher("supprimer.jsp").forward(request, response);
            
        }
        else  if("inscription".equals(action)){
        String nom_d_utilisateur=request.getParameter("nom_d_utilisateur");
       
        String Mot_de_passe=request.getParameter("Mot_de_passe");
        
        Login login=new Login(nom_d_utilisateur,Mot_de_passe);
        ConnectionDB.inscrption(login);
         request.setAttribute("message", "Connexion réussie, bienvenue " + nom_d_utilisateur);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    } else if ("login".equals(action)) {
    String nom_d_utilisateur = request.getParameter("nom_d_utilisateur");
    String Mot_de_passe = request.getParameter("Mot_de_passe");

    boolean isValidUser = ConnectionDB.validateLogin(nom_d_utilisateur, Mot_de_passe); // Méthode à ajouter dans DBConnection

    if (isValidUser) {
        request.setAttribute("message", "Connexion réussie, bienvenue " + nom_d_utilisateur);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        request.setAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

    
     }
    

    // Méthode pour afficher la liste des voitures ou effectuer une recherche
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marque = request.getParameter("marque");
        String idStr = request.getParameter("id"); // Récupérer l'ID de la voiture à modifier ou supprimer

        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Vehicule vehicule = ConnectionDB.getCarById(id); // Méthode à ajouter dans DBConnection
                request.setAttribute("vehicule", vehicule);
                request.getRequestDispatcher("modifier.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "ID invalide.");
                request.getRequestDispatcher("modifier.jsp").forward(request, response);
            }
        }  else {
            List<Vehicule> voitures = ConnectionDB.getAllCars();
            request.setAttribute("List", voitures);
            RequestDispatcher dispatcher = request.getRequestDispatcher("afficher.jsp");
            dispatcher.forward(request, response);
        }
    }
}
