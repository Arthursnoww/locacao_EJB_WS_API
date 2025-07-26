package com.locadora.service;

import org.springframework.stereotype.Service;
import com.locadora.model.*;

import java.util.List;
import java.util.ArrayList;

@Service
public class LocadoraService {
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Aparelho> estoque = new ArrayList<>();
    private final List<RequisicaoLocacao> historico = new ArrayList<>();

    public LocadoraService() {
        estoque.add(new Gerador("Gerador", 1500.0f, 5, 3000));
        estoque.add(new Mesa("Mesa", 200.0f, 10, 6));
        estoque.add(new Palco("Palco", 1000.0f, 2, 25.0f));
        estoque.add(new Talher("Talher", 50.0f, 100, "faca"));
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void adicionarAparelho(Aparelho a) {
        estoque.add(a);
    }

    public List<Aparelho> listarAparelhos() {
        return estoque;
    }

    public List<RequisicaoLocacao> listarLocacoes() {
        return historico;
    }

    public String registrarLocacao(RequisicaoLocacao req) {
        for (Aparelho a : estoque) {
            if (a.getNome().equalsIgnoreCase(req.getAparelho().getNome())) {
                if (a.getQtd() >= req.getQuantidade()) {
                    a.setQtd(a.getQtd() - req.getQuantidade());
                    historico.add(req);
                    return "Locação registrada com sucesso!";
                } else {
                    return "Quantidade indisponível.";
                }
            }
        }
        return "Aparelho não encontrado.";
    }
}
