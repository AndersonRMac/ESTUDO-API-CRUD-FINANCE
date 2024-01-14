package com.minhasDespesas.model;

import com.minhasDespesas.dto.EntradaDto;
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
     private Integer valor;

    public EntradaModel(String nome, Integer valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public EntradaModel(EntradaDto entradaDto){
        this.nome = entradaDto.nome();
        this.valor = entradaDto.valor();
    }

    public EntradaModel(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
