package com.locadora.model;

public class Palco extends Aparelho {
    private float area;

    public Palco() {}
    public Palco(String nome, float preco, int qtd, float area) {
        super(nome, preco, qtd);
        this.area = area;
    }

    public float getArea() { return area; }
    public void setArea(float area) { this.area = area; }

    @Override
    public String toString() {
        return "Palco [nome=" + getNome() + ", preco=" + getPreco() +
               ", qtd=" + getQtd() + ", area=" + area + "]";
    }
}