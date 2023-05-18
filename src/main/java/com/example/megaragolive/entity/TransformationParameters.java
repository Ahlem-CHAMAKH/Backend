package com.example.megaragolive.entity;

public class TransformationParameters {
    private String dbName;
    private String dataSourceUSER;

    private String historyUSER;

    public TransformationParameters(String dbName, String dataSourceUSER, String historyUSER) {
        this.dbName = dbName;
        this.dataSourceUSER = dataSourceUSER;
        this.historyUSER = historyUSER;
    }

    public String getDbName() {
        return dbName;
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
}
