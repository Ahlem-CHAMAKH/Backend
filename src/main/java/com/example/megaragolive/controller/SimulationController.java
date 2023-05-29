package com.example.megaragolive.controller;

import com.example.megaragolive.entity.ParametreSimulation;
import com.example.megaragolive.entity.ResultatSimulation;
import com.example.megaragolive.repository.ParamSimulationRepo;
import com.example.megaragolive.repository.ResultatSimulationRepo;
import com.example.megaragolive.service.FileService;
import com.example.megaragolive.service.ScriptSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/all")
    public ArrayList<ResultatSimulation> getAll(){
        return (ArrayList<ResultatSimulation>) rr.findAll();
    }
    @PostMapping("/showFile")
    public ResponseEntity<InputStreamResource> findFileContent(@RequestParam("id") Long id) throws FileNotFoundException {
        Optional<ResultatSimulation> re = rr.findById(id);
        if (re.isPresent()) {
            ResultatSimulation result = re.get();
            File filei = result.getScript();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filei.getName());
            InputStreamResource resource = new InputStreamResource(new FileInputStream(filei));
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(filei.length())
                    .body(resource);
        }
        return null;
    }

    @PostMapping("/validate")
    public ResultatSimulation validate(@RequestParam("id")  Long id){
        Optional<ResultatSimulation> re=rr.findById(id);
        if(re.isPresent()){
            ResultatSimulation result= re.get();
            result.setStatus(ResultatSimulation.Status.Validé);
            rr.save(result);
        }
        return re.get();
    }
    @PostMapping("/reject")
    public ResultatSimulation reject(@RequestParam("id") Long id){
        Optional<ResultatSimulation> re=rr.findById(id);
        if(re.isPresent()){
            ResultatSimulation result= re.get();
            result.setStatus(ResultatSimulation.Status.Rejeté);
            rr.save(result);
        }
        return re.get();
    }
}
