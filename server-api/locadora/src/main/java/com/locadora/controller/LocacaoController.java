package com.locadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.model.RequisicaoLocacao;
import com.locadora.service.LocadoraService;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {

    @Autowired private LocadoraService service;

    @PostMapping
    public ResponseEntity<String> alugar(@RequestBody RequisicaoLocacao req) {
        String resultado = service.registrarLocacao(req);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public List<RequisicaoLocacao> historico() {
        return service.listarLocacoes();
    }
}
