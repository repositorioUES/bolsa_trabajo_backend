package com.bad115.SistemaBolsa.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    //Auxiliar para preparar too lo necesario
    void init() throws IOException;

    // Para almacenar el archivo
    String store(MultipartFile file);

    // Para Cargar el Archivo
    Resource loadAsResource(String fileName);
}
