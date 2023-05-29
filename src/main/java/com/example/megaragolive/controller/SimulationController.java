package com.example.megaragolive.controller;

import com.example.megaragolive.entity.ParametreSimulation;
import com.example.megaragolive.entity.ResultatSimulation;
import com.example.megaragolive.repository.ParamSimulationRepo;
import com.example.megaragolive.repository.ResultatSimulationRepo;
import com.example.megaragolive.service.FileService;
import com.example.megaragolive.service.ScriptSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/Simulation")
public class SimulationController {
    @Autowired
    ScriptSimulationService ss;
    @Autowired
    FileService fs;
    @Autowired
    ResultatSimulationRepo rr;
    @Autowired
    ParamSimulationRepo pas;
    @PostMapping("/simulate")
    public ResultatSimulation doSimulation(@RequestParam("file")MultipartFile file, @RequestParam("driver") String driver,
                                                           @RequestParam("url") String url,@RequestParam("user") String user,
                                                           @RequestParam("pwd") String pwd) throws IOException {

        ResultatSimulation rs=new ResultatSimulation();
        ParametreSimulation ps=new ParametreSimulation(url, "", driver, user,  pwd);
        rs.setPs(ps);
        rs.setScript(fs.convertMultipartFileToFile(file));
        rs=ss.simulate(rs);
        pas.save(ps);
        rr.save(rs);
        return rs;
    }
}
