package com.example.megaragolive.repository;

import com.example.megaragolive.entity.ParametreSimulation;
import com.example.megaragolive.entity.ResultatSimulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParamSimulationRepo extends JpaRepository<ParametreSimulation,Long> {
}
