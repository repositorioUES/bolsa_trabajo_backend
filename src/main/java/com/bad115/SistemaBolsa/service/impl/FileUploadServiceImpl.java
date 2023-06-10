package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.PostConstruct;
import org.springframework.core.io.Resource;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${media.location}")
    private String mediaLocation;

    private Path rootLocation;

    @Override
    @PostConstruct
    public void init() throws IOException {
        rootLocation = Paths.get(mediaLocation);
        Files.createDirectories(rootLocation);
    }

    @Override
    public String store(MultipartFile file) {
        try {
            if(file.isEmpty()){
                throw new RuntimeException("Error al guardar, Archivo vacio");
            }
            String fileName = file.getOriginalFilename();
            Path destination = rootLocation.resolve(Paths.get(fileName)).normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
            }
            return fileName;
        }catch (IOException e){
            throw new RuntimeException("Fallo al guardar Archivo",e);
        }
    }

    @Override //Recuperar un arch
    public Resource loadAsResource(String fileName) {
        try {
            Path file = rootLocation.resolve(fileName);
            Resource resource = new UrlResource((file.toUri()));

            if (resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("No se encuentra el archivo" + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("No se encuentra el archivo" + fileName);
        }
    }
}

