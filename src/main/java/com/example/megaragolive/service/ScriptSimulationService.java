package com.example.megaragolive.service;

import com.example.megaragolive.entity.ParametreSimulation;
import com.example.megaragolive.entity.ResultatSimulation;
import com.nimbusds.jwt.util.DateUtils;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Date;

@Service
public class ScriptSimulationService {
    public  ResultatSimulation simulate(ResultatSimulation rs) {
      ParametreSimulation ps= rs.getPs();
      File file=rs.getScript();
        try {
            if(ps.getJdbcName().toString().equals("MySQL")) {
                //Registering the Driver
               Class.forName( "com.mysql.jdbc.Driver");
            }
            else   if(ps.getJdbcName().toString().equals("Oracle")) {
                //Registering the Driver
                Class.forName( "oracle.jdbc.OracleDriver");
            }
            //Getting the connection
            Connection con = DriverManager.getConnection(ps.getUrl(), ps.getUser(), ps.getPwd());
            System.out.println("Connection established......");
            //Initialize the script runner
            ScriptRunner sr = new ScriptRunner(con);
            //Creating a reader object
            sr.setStopOnError(true);
         //   sr.setErrorLogWriter(new PrintWrit);
            Reader reader = new BufferedReader(new FileReader(file));
            //Running the script
            sr.runScript(reader);
            rs.setRapport(new String("SQL SCRIPT EXECUTED SUCCESSFULLY!"));
        }
        catch (RuntimeException e){
            rs.setRapport(e.getMessage());
            rs.setWithError(Boolean.TRUE);

        }
        catch (Exception e){
            rs.setRapport(e.getMessage());
            rs.setWithError(Boolean.TRUE);

        }
        rs.setDateDeSimulation(new Date());
        return rs;
    }
}
