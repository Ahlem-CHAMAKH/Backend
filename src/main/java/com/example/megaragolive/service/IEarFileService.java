package com.example.megaragolive.service;

import com.example.megaragolive.entity.FilesToken;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Set;
import java.util.zip.ZipInputStream;

public interface IEarFileService {
    String getZip1Path(Long sessionID);

    String getZip2Path(Long sessionID);

    String getUNZip1Path(Long sessionID);
    String getUNZip2Path(Long sessionID);
    String getResultPath(Long sessionID);

    File convert(MultipartFile multipartFile, String path) throws IOException;

    String getUnzipScript(Long sessionID);

    public void initWorkingFolders(String sessionID);
    public void clearWorkingFolder(String sessionID) throws IOException;

    void synchronizeFilesToken(FilesToken fIt);

    public File convertMultipartFileToFile(MultipartFile multipartFile);

    String getExtension(File file);

    FileOutputStream extractFile(ZipInputStream zipIn, String filePath) throws IOException;
   // public void extractEarFile(File earFile, String destination);
    //ZipInputStream unzipFile(MultipartFile file, String destDir) throws IOException;
    void extractEarFile(MultipartFile earFile, String destination) throws IOException;

    ZipInputStream unzipFile(InputStream is, String destDir) throws IOException;

    Set<String> getAllFileNamesFromJarsEars(File file);

    public void decompileOneJar(File jarFile, String targetFilePath , String parent) throws IOException;
    public Long uploadAndExtract2Files(MultipartFile file1,MultipartFile file2) throws IOException ;


    public void decompileManyJars(String sourceFolder, String targetFolder) throws IOException;
    public void decompileOneClass(File classFile,String targetFolder) throws IOException;
}
