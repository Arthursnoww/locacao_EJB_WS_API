package com.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.model.Cliente;
import com.locadora.service.LocadoraService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired private LocadoraService service;

    @PostMapping
    public void add(@RequestBody Cliente c) {
        service.adicionarCliente(c);
    }

    @GetMapping
    public List<Cliente> all() {
        return service.listarClientes();
    }
}

