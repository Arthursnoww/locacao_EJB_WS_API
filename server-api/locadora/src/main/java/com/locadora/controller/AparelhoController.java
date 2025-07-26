package com.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.model.Aparelho;
import com.locadora.service.LocadoraService;

@RestController
@RequestMapping("/api/aparelhos")
public class AparelhoController {
    @Autowired private LocadoraService service;

    @GetMapping
    public List<Aparelho> all() {
        return service.listarAparelhos();
    }
}
