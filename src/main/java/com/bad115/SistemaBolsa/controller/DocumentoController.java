package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Documento;
import com.bad115.SistemaBolsa.service.AspiranteService;
import com.bad115.SistemaBolsa.service.DocumentoService;
import com.bad115.SistemaBolsa.service.FileUploadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DataTruncation;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/documento")
@AllArgsConstructor
public class DocumentoController {


    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private AspiranteService aspiranteService;
    @Autowired
    private FileUploadService fileUploadService;

    private final HttpServletRequest request;

    @GetMapping // Todos los Documentos
    public List<Documento> getDocumentos(){
        return documentoService.getDocumentos();
    }

    @GetMapping("/{id}") // Obtener un Documantor por su ID
    public Documento getDocumento(@PathVariable Long id) {
        return documentoService.getDocumento(id);
    }

    @PostMapping("/aspirante/{id}") // Guardar un Documento con su respectivo aspirante
    public Documento saveDocumento(@ModelAttribute Documento documento, @RequestParam ("file") MultipartFile file, @PathVariable("id") Long id) {
        Documento doc = new Documento();
        doc.setNombre_documento(documento.getNombre_documento());
        doc.setUri(uploadFile(file));
        /*if(!file.isEmpty()){
            Path directorio = Paths.get("src//main//Files");
            String rutaAbs = directorio.toFile().getAbsolutePath();

            try {
                byte[] bytesFile = file.getBytes();
                Path rutaCompleta = Paths.get(rutaAbs + "//" + file.getOriginalFilename());
                Files.write(rutaCompleta,bytesFile);
                doc.setUri(String.valueOf(rutaCompleta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/

        return documentoService.save(doc, id);
    }

    @PutMapping("/{id}")
    public Documento updateDocumento(@RequestBody Documento documento, @PathVariable("id") Long id) {
        return documentoService.update(documento, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumento(@PathVariable("id") Long id) {
        documentoService.delete(id);
    }

    @GetMapping("/aspirante/{id}") //Obtener todos las DOCUMENTOS de un Aspirante específico
    public ResponseEntity<List<Documento>> getDocumentoByAspirante(@PathVariable(value = "id") Long id) {
        List<Documento> documentos = null;
        documentos = documentoService.getDocumentoByAspirante(id);

        return new ResponseEntity<>(documentos, HttpStatus.OK);
    }


    public String uploadFile(MultipartFile file){
        String path = fileUploadService.store(file);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/documento/")
                .path(path)
                .toUriString();
        return url;
    }

    @GetMapping("{filename:.+}/file") //Obtener el archivo y su tipo por la URI de la tabla DOCUMENTO
    public ResponseEntity<Resource> getFile(@PathVariable("filename") String fileName) throws IOException{
        Resource file = fileUploadService.loadAsResource(fileName);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }
}
