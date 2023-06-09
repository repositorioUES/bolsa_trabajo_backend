package com.bad115.SistemaBolsa.service.impl;

import com.bad115.SistemaBolsa.entity.Aspirante;
import com.bad115.SistemaBolsa.entity.Genero;
import com.bad115.SistemaBolsa.entity.Oferta;
import com.bad115.SistemaBolsa.entity.Usuario;
import com.bad115.SistemaBolsa.repository.AspiranteRepository;
import com.bad115.SistemaBolsa.repository.GeneroRepository;
import com.bad115.SistemaBolsa.repository.OfertaRepository;
import com.bad115.SistemaBolsa.repository.UsuarioRepository;
import com.bad115.SistemaBolsa.service.AspiranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Set;

@Service
public class AspiranteServiceImpl implements AspiranteService {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public Aspirante guardarAspirante(Aspirante aspirante, Long generoId, Long usuarioId) {
        Usuario u = usuarioRepository.getReferenceById(usuarioId);
        Genero g = generoRepository.getReferenceById(generoId);

        Aspirante a = new Aspirante();
        a.setTipo_documento(aspirante.getTipo_documento());
        a.setNumero_documento_identidad(aspirante.getNumero_documento_identidad());
        a.setPrimer_nombre(aspirante.getPrimer_nombre());
        a.setSegundo_nombre(aspirante.getSegundo_nombre());
        a.setPrimer_apellido(aspirante.getPrimer_apellido());
        a.setSegundo_apellido(aspirante.getSegundo_apellido());
        a.setFecha_nacimiento(aspirante.getFecha_nacimiento());
        a.setNit(aspirante.getNit());
        a.setNup(aspirante.getNup());
        a.setTelefono_casa(aspirante.getTelefono_casa());
        a.setTelefono_personal(aspirante.getTelefono_personal());
        a.setEmail(aspirante.getEmail());
        a.setRedes_sociales(aspirante.getRedes_sociales());
        a.setUsuario(u);
        a.setGenero(g);
        return aspiranteRepository.save(a);
    }

    @Override
    public Aspirante obtenerAspirante(Long id) {
        return aspiranteRepository.getReferenceById(id);
    }

    @Override
    public List<Aspirante> obtenerAspirantes() {
        return aspiranteRepository.findAll();
    }

    @Override
    public Aspirante aplicarOferta(Long aspiranteId, Long ofertaId) {
        Set<Oferta> ofertaSet = null;
        Aspirante aspirante = aspiranteRepository.getReferenceById(aspiranteId);
        Oferta oferta = ofertaRepository.getReferenceById(ofertaId);
        ofertaSet = aspirante.getOfertas();
        ofertaSet.add(oferta);
        aspirante.setOfertas(ofertaSet);
        return aspiranteRepository.save(aspirante);
    }

    @Override
    public Aspirante actualizarAspirante(Aspirante aspirante, Long id, Long generoId, Long usuarioId) {
        Usuario u = usuarioRepository.getReferenceById(usuarioId);
        Genero g = generoRepository.getReferenceById(generoId);

        Aspirante a = aspiranteRepository.getReferenceById(id);
        a.setTipo_documento(aspirante.getTipo_documento());
        a.setNumero_documento_identidad(aspirante.getNumero_documento_identidad());
        a.setPrimer_nombre(aspirante.getPrimer_nombre());
        a.setSegundo_nombre(aspirante.getSegundo_nombre());
        a.setPrimer_apellido(aspirante.getPrimer_apellido());
        a.setSegundo_apellido(aspirante.getSegundo_apellido());
        a.setFecha_nacimiento(aspirante.getFecha_nacimiento());
        a.setNit(aspirante.getNit());
        a.setNup(aspirante.getNup());
        a.setTelefono_casa(aspirante.getTelefono_casa());
        a.setTelefono_personal(aspirante.getTelefono_personal());
        a.setEmail(aspirante.getEmail());
        a.setRedes_sociales(aspirante.getRedes_sociales());
        a.setUsuario(u);
        a.setGenero(g);
        return aspiranteRepository.save(a);
    }

    @Override
    public void eliminarAspirante(Long id) {
        aspiranteRepository.deleteById(id);
    }
}
