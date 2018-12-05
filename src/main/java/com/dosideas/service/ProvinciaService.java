package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;

public interface ProvinciaService {
    Provincia buscarPorId(long id);
    List<Provincia> buscarPorNombre(String nombre);
    List<Provincia> buscarPorNombreConteniendo(String nombre);
    List<Provincia> buscarProvinciasPorNombrePais(String nombre);
    List<Provincia> buscarTodas();
}
