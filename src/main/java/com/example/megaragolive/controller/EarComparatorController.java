package com.example.megaragolive.controller;

import com.example.megaragolive.entity.Folder;
import com.example.megaragolive.entity.STransformationParameters;
import com.example.megaragolive.entity.ScriptTransformation;
import com.example.megaragolive.service.FileService;
import com.example.megaragolive.service.FileComparator;
import com.example.megaragolive.service.ScriptTransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/Comparator")
public class EarComparatorController {
    @Autowired
    FileComparator ecs;
    @Autowired
    FileService es;
    @Autowired
    ScriptTransformationService st;
    @GetMapping(name="/j")
    public String get(){
        return "he";
    }

    @PostMapping("/result")
    public ResponseEntity<Folder> getComparisonRESULT(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2){
        Long token= null;
        try {
        token = es.uploadAndExtract2Files(file1,file2);
        Folder folder=ecs.compare(new File(es.getUNZip1Path(token)),new File(es.getUNZip2Path(token)));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<Folder>(folder, headers, HttpStatus.OK);
        } catch (IOException e) {
            return null;
        }
    }


    public ArrayList<Folder> getModifiedFiles(MultipartFile file1, MultipartFile file2) {
        return null;
    }

    
    public ArrayList<Folder> getRemovedAddedFiles(MultipartFile file1, MultipartFile file2) {
        return null;
    }

    
    public ArrayList<Folder> getSameFiles(MultipartFile file1, MultipartFile file2) {
        return null;
    }
}
