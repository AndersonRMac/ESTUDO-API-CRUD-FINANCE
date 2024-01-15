package com.minhasDespesas.model;


public enum TipoMovimentacao {                  //Representação de Constantes   //Enum sempre UPPERCASE

    ENTRADA,SAIDA;
    private Long id;
    private String nome;

    TipoMovimentacao(String nome) {
        this.nome = nome;
    }

    TipoMovimentacao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
