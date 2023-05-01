package com.example.megaragolive.repository;

import com.example.megaragolive.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurJPA extends JpaRepository<Utilisateur,String> {
}
