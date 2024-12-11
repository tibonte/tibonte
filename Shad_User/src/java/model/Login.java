/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author owner
 */
public class Login {
    private String nom_d_utilisateur;
   
    private String mot_de_passe;

    
    //constructeur

    public Login(String nom_d_utilisateur, String mot_de_passe) {
        this.nom_d_utilisateur = nom_d_utilisateur;
        this.mot_de_passe = mot_de_passe;
    }
    

    public String getNom_d_utilisateur() {
        return nom_d_utilisateur;
    }

    public void setNom_d_utilisateur(String nom_d_utilisateur) {
        this.nom_d_utilisateur = nom_d_utilisateur;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
    
    
    
    
}