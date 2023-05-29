package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getEmpresas() {
        return empresaService.getEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa getEmpresa(@PathVariable Long id) {
        return empresaService.getEmpresa(id);
    }

    @PostMapping
    public Empresa saveEmpresa(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping("/{id}")
    public Empresa updateEmpresa(@RequestBody Empresa empresa, @PathVariable("id") Long id) {
        return empresaService.update(empresa, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") Long id) {
        empresaService.delete(id);
    }
}
