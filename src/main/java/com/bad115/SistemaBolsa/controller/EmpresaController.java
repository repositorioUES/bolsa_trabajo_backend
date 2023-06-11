package com.bad115.SistemaBolsa.controller;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@CrossOrigin("*")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/usuario/{usuarioId}")
    public Empresa guardarEmpresa(
            @RequestBody Empresa empresa,
            @PathVariable Long usuarioId
    ) {
        return empresaService.guardarEmpresa(empresa, usuarioId);
    }

    @GetMapping
    public List<Empresa> obtenerEmpresas() {
        return empresaService.obtenerEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa obtenerEmpresa(@PathVariable("id") Long id) {
        return empresaService.obtenerEmpresa(id);
    }

    @PutMapping("/{id}/usuario/{usuarioId}")
    public Empresa actualizarEmpresa(
            @PathVariable("id") Long id,
            @RequestBody Empresa empresa,
            @PathVariable Long usuarioId
    ) {
        return empresaService.actualizarEmpresa(empresa, id, usuarioId);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable("id") Long id) {
        empresaService.eliminarEmpresa(id);
    }
}
