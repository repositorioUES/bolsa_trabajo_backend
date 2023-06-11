package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Empresa;
import com.bad115.SistemaBolsa.entity.Oferta;

import java.util.List;


public interface EmpresaService {

    public Empresa guardarEmpresa(Empresa empresa, Long usuarioId);

    public List<Empresa> obtenerEmpresas();

    public Empresa obtenerEmpresa(Long id);

    public Empresa actualizarEmpresa(Empresa empresa, Long id, Long usuarioId);

    public void eliminarEmpresa(Long id);
}
