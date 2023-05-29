package com.example.megaragolive.repository;

import com.example.megaragolive.entity.ScriptTransformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptTransfRepository extends JpaRepository<ScriptTransformation,Long> {
}
