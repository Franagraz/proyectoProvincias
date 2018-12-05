package com.dosideas.service.impl;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    private final ProvinciaRepository provinciaRepositorio;

    public ProvinciaServiceImpl(ProvinciaRepository provinciaRepositorio) {
        this.provinciaRepositorio = provinciaRepositorio;
    }

    @Override
    public Provincia buscarPorId(long id) {
        return provinciaRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Provincia> buscarPorNombre(String nombre) {
        return this.provinciaRepositorio.findByNombre(nombre);
    }

    @Override
    public List<Provincia> buscarPorNombreConteniendo(String nombre) {
        return this.provinciaRepositorio.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Provincia> buscarProvinciasPorNombrePais(String nombre) {
        return this.provinciaRepositorio.buscarProvinciasPorNombreDePais(nombre);
    }
    
    public List<Provincia> buscarTodas(){
        return this.provinciaRepositorio.findAll();
    }

}