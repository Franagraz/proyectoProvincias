/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.controller;

import com.dosideas.domain.Provincia;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @RequestMapping("/paises")
    public String paises(Model model) {
        List<Provincia> provincias = provinciaService.buscarTodas();
        model.addAttribute("provincias", provincias);
        return "provincia";
    }
    
}
