package com.example.megaragolive.service;


import com.example.megaragolive.entity.Utilisateur;
import com.example.megaragolive.repository.UtilisateurJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UtilisateurService implements IUtilisateurService {
    @Autowired
    UtilisateurJPA j;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
       utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
       return j.save(utilisateur);
    }

    @Override
    public Utilisateur modifier(Utilisateur utilisateur) {
        Utilisateur u=j.getOne(utilisateur.getEmail());
        if(u!=null){
            u.setNom(utilisateur.getNom());
            u.setEmail(utilisateur.getEmail());
            u.setPrenom(utilisateur.getPrenom());
            u.setRole(utilisateur.getRole());
            u.setPassword(utilisateur.getPassword());
            j.save(u);
            return u;
        }
       return utilisateur;
    }

    @Override
    public Boolean supprimerUtilisateur(Utilisateur utilisateur) {
        j.delete(utilisateur);
        return true;
    }

    @Override
    public Utilisateur getUtilisateur(String email) {
        return j.getOne(email);
    }

    @Override
    public ArrayList<Utilisateur> getAllUtilisateur() {
        return (ArrayList<Utilisateur>) j.findAll();
    }
}
