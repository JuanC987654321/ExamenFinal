package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.ProduccionModel;

@Controller
@RequestMapping("/Produccion")
public class ProduccionController {

    @GetMapping("{cl}")
    public String startMethod (@PathVariable("cl") String cl, Model model) {
        String titulo = "Pagina API con Spring Boot";
        model.addAttribute("name", cl);
        model.addAttribute("titulo", titulo);
        ProduccionModel inicioProduccion = produccionDTO (cl);
        model.addAttribute("inicioProduccion", inicioProduccion);
        return "produccion";
    }
    
    public ProduccionModel produccionDTO (String numID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProduccionModel> resp =
                restTemplate
                .getForEntity(
                        String.format("https://myappfb-4718b.firebaseio.com/campeche/produccion/FAB-%s.json", numID),
                        ProduccionModel.class);
        return resp.getBody();
    
    
    }
}