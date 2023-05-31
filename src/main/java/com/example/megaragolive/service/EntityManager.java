package com.example.megaragolive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@Service
public class EntityManager {

    @Autowired
    Environment env;


    public String getExtractionPath(){
        return env.getProperty("extractPath") ;
    }
}