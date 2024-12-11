/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class ConnectionDB{

    // Méthode pour sauvegarder une voiture
    public static void saveVoiture(Vehicule vehicule) {
        String sql = "INSERT INTO voitures (marque, modele, prix, annee, couleur) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicule.getMarque());
            pstmt.setString(2, vehicule.getModele());
            pstmt.setInt(3, vehicule.getPrix());
            pstmt.setInt(4, vehicule.getAnnee());
            pstmt.setString(5, vehicule.getCouleur());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer toutes les voitures enregistrées
    public static List<Vehicule> getAllCars() {
        List<Vehicule> voitures = new ArrayList<>();
        String sql = "SELECT * FROM voitures";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Vehicule vehicule = new Vehicule(
                    rs.getString("marque"),
                    rs.getString("modele"),
                    rs.getInt("prix"),
                    rs.getInt("annee"),
                    rs.getString("couleur")
                );
                vehicule.setId(rs.getInt("id"));
                voitures.add(vehicule);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voitures;
    }

    // Méthode pour rechercher des voitures par marque ou modèle
   
    // Méthode pour récupérer une voiture par son ID
    public static Vehicule getCarById(int id) {
        Vehicule vehicule = null;
        String sql = "SELECT * FROM voitures WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                   vehicule = new Vehicule(
                        rs.getString("marque"),
                        rs.getString("modele"),
                        rs.getInt("prix"),
                        rs.getInt("annee"),
                        rs.getString("couleur")
                    );
                    vehicule.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicule;
    }

    // Méthode pour mettre à jour une voiture
    public static void updateVoiture(Vehicule vehicule ) {
        String sql = "UPDATE voitures SET marque = ?, modele = ?, prix = ?, annee = ?, couleur = ? WHERE id = ?";

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicule.getMarque());
            pstmt.setString(2, vehicule.getModele());
            pstmt.setInt(3, vehicule.getPrix());
            pstmt.setInt(4, vehicule.getAnnee());
            pstmt.setString(5, vehicule.getCouleur());
            pstmt.setInt(6, vehicule.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une voiture par son ID
    public static void deleteVoiture(int id) {
        String sql = "DELETE FROM voitures WHERE id = ?";
        
        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // pour la la connexion et l'inscription
    public static void inscrption(Login login){
        String sql=" INSERT INTO Login (Nom_d_utilisateur,Mot_de_passe) VALUES (?,?) ";
        
        try(Connection conn=getConnection();
                PreparedStatement pstmt =conn.prepareStatement(sql)) {
          pstmt.setString(1, login.getNom_d_utilisateur());
          pstmt.setString(2,login.getMot_de_passe());
          pstmt.executeUpdate();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    //connexion
    public static boolean validateLogin(String Nom_d_utilisateur, String Mot_de_passe) {
    String sql = "SELECT * FROM Login WHERE Nom_d_utilisateur = ? AND Mot_de_passe = ?"; // Utilisez des mots de passe hachés pour plus de sécurité
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
         
        pstmt.setString(1, Nom_d_utilisateur);
        pstmt.setString(2, Mot_de_passe); // Ajouter une gestion de hachage des mots de passe ici
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return true; // Connexion réussie
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Connexion échouée
}

  

    // Méthode de connexion à la base de données
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/shad", "root", "tibonte");
    }
}
