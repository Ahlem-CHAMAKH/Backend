package com.example.megaragolive.controller;

import com.example.megaragolive.entity.Folder;
import com.example.megaragolive.entity.ScriptTransformationHistory;
import com.example.megaragolive.entity.TransformationParameters;
import com.example.megaragolive.service.FileService;
import com.example.megaragolive.service.FileComparator;
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
import java.util.zip.ZipFile;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/ScriptTransformer")
public class ScriptTransformerController {
    @Autowired
    FileComparator ecs;
    @Autowired
    FileService es;

    @PostMapping(name = "/result",produces = { "application/octet-stream" })
    public ResponseEntity<ZipFile> getResult(@RequestParam("file") MultipartFile file1, @RequestParam("TransformationParameters") TransformationParameters tp) throws IOException {
        ScriptTransformationHistory transformationHistory=new ScriptTransformationHistory();
        transformationHistory.setHistoryUSER(tp.getHistoryUSER());
        transformationHistory.setDataSourceUSER(tp.getDataSourceUSER());
        transformationHistory.setDbName(tp.getDbName());
        transformationHistory.setSourceScript(es.convert(file1,es.getUnzipScript(transformationHistory.getId())));

        return new ResponseEntity<ScriptTransformationHistory>(folder, headers, HttpStatus.OK);
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
