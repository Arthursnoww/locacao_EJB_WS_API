package com.locadora.model;

public class Gerador extends Aparelho {
    private int potencia;

    public Gerador() {}
    public Gerador(String nome, float preco, int qtd, int potencia) {
        super(nome, preco, qtd);
        this.potencia = potencia;
    }

    public int getPotencia() { return potencia; }
    public void setPotencia(int potencia) { this.potencia = potencia; }

    @Override
    public String toString() {
        return "Gerador [nome=" + getNome() + ", preco=" + getPreco() +
               ", qtd=" + getQtd() + ", potencia=" + potencia + "]";
    }
}
