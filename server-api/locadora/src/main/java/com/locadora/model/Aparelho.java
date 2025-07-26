package com.locadora.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Mesa.class, name = "mesa"),
    @JsonSubTypes.Type(value = Palco.class, name = "palco"),
    @JsonSubTypes.Type(value = Talher.class, name = "talher"),
    @JsonSubTypes.Type(value = Gerador.class, name = "gerador")
})
public abstract class Aparelho {
    private String nome;
    private float preco;
    private int qtd;

    public Aparelho() {}
    public Aparelho(String nome, float preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }
}
