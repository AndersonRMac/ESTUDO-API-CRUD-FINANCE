package com.minhasDespesas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_entrada")
public class EntradaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
    @Column(nullable = false)
     private String nome;
    @Column(nullable = false)
     private Double valor;

    public EntradaModel(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public EntradaModel(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
