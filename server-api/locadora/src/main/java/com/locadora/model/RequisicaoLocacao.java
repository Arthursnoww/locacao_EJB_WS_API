package com.locadora.model;

import lombok.Data;

@Data
public class RequisicaoLocacao {
    private Cliente cliente;
    private Aparelho aparelho;
    private int quantidade;

    public RequisicaoLocacao() {}
    public RequisicaoLocacao(Cliente cliente, Aparelho aparelho, int quantidade) {
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.quantidade = quantidade;
    }
}