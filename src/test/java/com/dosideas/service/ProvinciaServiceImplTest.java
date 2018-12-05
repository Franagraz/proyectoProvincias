package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceImplTest {

    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_idExistente_RetornaProvincia() {
        Long idProvAct = 1L;
        Provincia provinciaRetorno = provinciaService.buscarPorId(idProvAct);
        assertEquals(idProvAct, provinciaRetorno.getId());
    }

    @Test
    public void buscarPorId_IdInexistente_RetornaNull() {
        Provincia provinciaRetorno = provinciaService.buscarPorId(-1L);
        assertNull(provinciaRetorno);
    }
    
    @Test
    public void findByName_NombreExistente_RetornaListaConAlMenosUnaProvincia() {
        String nombreProvincia = "Buenos Aires";
        List<Provincia> provinciasEncontradas = this.provinciaService.buscarPorNombre(nombreProvincia);
        assertTrue(provinciasEncontradas.stream().anyMatch(provincia -> provincia.getNombre().equals(nombreProvincia)));
    }
    
    @Test
    public void findByName_NombreInexistente_RetornaListaVacia() {
        String nombreProvincia = "CXSKI43";
        List<Provincia> provinciasEncontradas = this.provinciaService.buscarPorNombre(nombreProvincia);
        assertTrue(provinciasEncontradas.isEmpty());
    }
    
    @Test
    public void findByName_NombreExistenteCaseSensitive_RetornaListaVacia() {
        String nombreProvincia = "buenos aires";
        List<Provincia> provinciasEncontradas = this.provinciaService.buscarPorNombre(nombreProvincia);
        assertTrue(provinciasEncontradas.isEmpty());
    }
    
    @Test
    public void findByName_NombreExistenteSoloUnaParte_RetornaListaVacia() {
        String nombreProvincia = "Buenos A";
        List<Provincia> provinciasEncontradas = this.provinciaService.buscarPorNombre(nombreProvincia);
        assertTrue(provinciasEncontradas.isEmpty());
    }
    
    @Test
    public void buscarPorNombreConteniendo_NombreExistente_RetornaListaConAlMenosUnaProvincia() {
        String nombreProvincia = "Buenos Ai";
        List<Provincia> provinciasEncontradas = this.provinciaService.buscarPorNombreConteniendo(nombreProvincia);
        assertTrue(provinciasEncontradas.stream().anyMatch(provincia -> provincia.getNombre().equals("Buenos Aires")));
    }
    
    @Test
    public void buscarProvinciasPorNombrePais_NombreExistente_RetornaListaConAlMenosUnaProvincia(){
        String nombrePais = "Argentina";
        List<Provincia> provinciasEncontradas = this.provinciaService.buscarProvinciasPorNombrePais(nombrePais);
        assertTrue(provinciasEncontradas.stream().anyMatch(provincia -> provincia.getNombre().equals("Buenos Aires"))); 
    }

}
