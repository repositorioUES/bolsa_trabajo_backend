package com.bad115.SistemaBolsa.service;

import com.bad115.SistemaBolsa.entity.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    public Empresa save(Empresa empresa);

    public Empresa getEmpresa(Long id);

    public List<Empresa> getEmpresas();

    public void delete(Long id);

    public Empresa update(Empresa empresa, Long id);
}
