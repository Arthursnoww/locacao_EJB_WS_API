package com.locadora.model;

public class Mesa extends Aparelho {
    private int lugares;

    public Mesa() {}
    public Mesa(String nome, float preco, int qtd, int lugares) {
        super(nome, preco, qtd);
        this.lugares = lugares;
    }

    public int getLugares() { return lugares; }
    public void setLugares(int lugares) { this.lugares = lugares; }

    @Override
    public String toString() {
        return "Mesa [nome=" + getNome() + ", preco=" + getPreco() +
               ", qtd=" + getQtd() + ", lugares=" + lugares + "]";
    }
}