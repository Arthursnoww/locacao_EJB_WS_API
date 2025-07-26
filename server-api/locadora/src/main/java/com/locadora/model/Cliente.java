package com.locadora.model;

import lombok.Data;

@Data
public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente() {}
    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}