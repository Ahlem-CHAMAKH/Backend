package com.example.megaragolive.entity;

import jakarta.persistence.*;

import java.io.File;

@Table
@Entity
public class ResultatSimulation {

    @Id
    @GeneratedValue
    private Long id;
    private String rapport;
    private File script;
    @OneToOne
     private   ParametreSimulation ps;

    public ResultatSimulation(File script, ParametreSimulation ps) {
        this.script = script;
        this.ps = ps;
    }

    public ResultatSimulation() {

    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public File getScript() {
        return script;
    }

    public void setScript(File script) {
        this.script = script;
    }

    public ParametreSimulation getPs() {
        return ps;
    }

    public void setPs(ParametreSimulation ps) {
        this.ps = ps;
    }
}
