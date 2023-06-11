package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.ConocimientoAcademico;
import com.bad115.SistemaBolsa.entity.Institucion;
import com.bad115.SistemaBolsa.repository.ConocimientoAcademicoRepository;
import com.bad115.SistemaBolsa.repository.InstitucionRepository;
import com.bad115.SistemaBolsa.service.ConocimientoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ConocimientoAcedemicoServiceImpl implements ConocimientoAcademicoService {

    @Autowired
    private ConocimientoAcademicoRepository conocimientoAcademicoRepository;

    @Autowired
    private InstitucionRepository institucionRepository;


    @Override
    public ConocimientoAcademico guardarConocimiento(ConocimientoAcademico conocimientoAcademico) {
        return conocimientoAcademicoRepository.save(conocimientoAcademico);
    }

    @Override
    public ConocimientoAcademico obtenerConocimiento(Long id) {
        return conocimientoAcademicoRepository.getReferenceById(id);
    }

    @Override
    public List<ConocimientoAcademico> obtenerConocimientos() {
        return conocimientoAcademicoRepository.findAll();
    }

    @Override
    public ConocimientoAcademico agregarInstitucion(Long conocimientoId, Long institucionId) {
        Set<Institucion> institucionSet = null;
        ConocimientoAcademico c = conocimientoAcademicoRepository.getReferenceById(conocimientoId);
        Institucion i = institucionRepository.getReferenceById(institucionId);
        institucionSet = c.getInstituciones();
        institucionSet.add(i);
        c.setInstituciones(institucionSet);
        return conocimientoAcademicoRepository.save(c);
    }

    @Override
    public ConocimientoAcademico actualizarConocmiento(ConocimientoAcademico conocimientoAcademico, Long id) {
        ConocimientoAcademico conocimientoLocal = conocimientoAcademicoRepository.getReferenceById(id);
        conocimientoLocal.setTipo_conocimiento(conocimientoAcademico.getTipo_conocimiento());
        conocimientoLocal.setFecha_inico(conocimientoAcademico.getFecha_inico());
        conocimientoLocal.setFecha_fin(conocimientoAcademico.getFecha_fin());
        conocimientoLocal.setTitulo_obtenido(conocimientoAcademico.getTitulo_obtenido());
        conocimientoLocal.setAspirante(conocimientoAcademico.getAspirante());
        conocimientoLocal.setInstituciones(conocimientoAcademico.getInstituciones());
        return conocimientoAcademicoRepository.save(conocimientoLocal);
    }

    @Override
    public void eliminarConocimiento(Long id) {
        conocimientoAcademicoRepository.deleteById(id);
    }
}
