package com.locadora.model;

public class Talher extends Aparelho {
    private String categoria; 

    public Talher() {}

    public Talher(String nome, float preco, int qtd, String categoria) {
        super(nome, preco, qtd);
        this.categoria = categoria;
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Talher [nome=" + getNome() +
               ", preco=" + getPreco() +
               ", qtd=" + getQtd() +
               ", categoria=" + categoria + "]";
    }
}

