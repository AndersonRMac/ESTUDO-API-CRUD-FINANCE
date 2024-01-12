package com.minhasDespesas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_saida")
public class SaidaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String vencimento;
    private Double valor;

    public SaidaModel(){}

    public SaidaModel(String nome, String vencimento, Double valor) {
        this.nome = nome;
        this.vencimento = vencimento;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
