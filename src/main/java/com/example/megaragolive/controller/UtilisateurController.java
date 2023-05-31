package com.example.megaragolive.controller;

import com.example.megaragolive.entity.Utilisateur;
import com.example.megaragolive.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurService us;

    @GetMapping("/all")
    public ArrayList<Utilisateur> getAllUtilisateur(){
        return us.getAllUtilisateur();
    }
    @PostMapping("/add")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return us.ajouterUtilisateur(utilisateur);
    }
    @PostMapping("/email")
    public ResponseEntity<Utilisateur> getUtilisateur(@RequestParam("email")String email){
        Utilisateur u=us.getUtilisateur(email);

        return ResponseEntity.ok().body(u);
    }
}
