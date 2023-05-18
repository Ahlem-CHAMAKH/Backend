package com.example.megaragolive.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.File;
import java.util.zip.ZipFile;
@Table(name="ScriptTransformationHistory")
@Entity
public class ScriptTransformationHistory {


    @Id
    @GeneratedValue
    private long id;



    enum Status{
        ACCEPTED, REJECTED
    }
    private String dbName;
    private String dataSourceUSER;

    private String historyUSER;
    private File sourceScript;
    private File transformedScripts;

    public String getDbName() {
        return dbName;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDataSourceUSER() {
        return dataSourceUSER;
    }

    public void setDataSourceUSER(String dataSourceUSER) {
        this.dataSourceUSER = dataSourceUSER;
    }

    public String getHistoryUSER() {
        return historyUSER;
    }

    public void setHistoryUSER(String historyUSER) {
        this.historyUSER = historyUSER;
    }

    public File getSourceScript() {
        return sourceScript;
    }

    public void setSourceScript(File sourceScript) {
        this.sourceScript = sourceScript;
    }

    public File getTransformedScripts() {
        return transformedScripts;
    }

    public void setTransformedScripts(File transformedScripts) {
        this.transformedScripts = transformedScripts;
    }
}
