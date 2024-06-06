package com.example.Dio_final.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private int quantidade;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Bibliotecario bibliotecario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void retirarLivro(Cliente cliente, Bibliotecario bibliotecario) {
        if (cliente != null && bibliotecario != null) {
            // Lógica para retirar o livro
            System.out.println("Livro retirado com sucesso por " + cliente.getNome() + " com a ajuda de " + bibliotecario.getNome());
        } else {
            System.out.println("Não é possível retirar o livro sem cliente e bibliotecário associados.");
        }
    }
}