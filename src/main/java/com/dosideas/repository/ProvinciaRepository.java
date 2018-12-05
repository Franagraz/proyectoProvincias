package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
    
    List<Provincia> findByNombre(String nombre);
    
    List<Provincia> findByNombreContainingIgnoreCase(String nombre);
    
    //@Query("select p from Provincia p, Pais pa where p.idPais = pa.id and pa.nombre = ?1")
    @Query("select p from Provincia p where p.pais.nombre = ?1")
    List<Provincia> buscarProvinciasPorNombreDePais(String pais);
}