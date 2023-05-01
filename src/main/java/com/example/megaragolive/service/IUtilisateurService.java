package com.example.megaragolive.service;

import com.example.megaragolive.entity.Utilisateur;

import java.util.ArrayList;

public interface IUtilisateurService {
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);

    public Utilisateur modifier(Utilisateur utilisateur);

    public Boolean supprimerUtilisateur(Utilisateur utilisateur);

    public Utilisateur getUtilisateur(String cin);
    public ArrayList<Utilisateur> getAllUtilisateur();
}
