package com.example.megaragolive.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {
    @Id
    private String email;

    private String nom;
    private String prenom;
    private String cin;
    private Role role;


 private String password;
    public Utilisateur() {

    }


    public Utilisateur(String cin, String nom, String prenom, String email, Role role) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
    }

    public Utilisateur(String username, String email, String encode) {
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String CIN) {
        this.cin = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Utilisateur(String cin, String nom, String prenom, String email, Role role, String password) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
