package com.minhasDespesas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Enumerated(EnumType.STRING)
    @Column
    TipoMovimentacao tipoMovimentacao;


    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private Double valor;
    @Column
    private String vencimento;        //exclusivo da Saidas

    public Movimentacao(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Movimentacao(){
    }

    public Movimentacao(String nome, Double valor, String vencimento) {
        this.nome = nome;
        this.valor = valor;
        this.vencimento = vencimento;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
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
/*Precisa de tudo get e set, */