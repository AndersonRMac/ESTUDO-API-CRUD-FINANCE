package com.minhasDespesas.model;

import com.minhasDespesas.dto.UsuarioDto;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestBody;

@Entity                         //Para informar que vai ser uma classe que vai ser uma tabela no banco de dados.
@Table (name = "tb_usuario")
public class UsuarioModel {

    @Id                         //Estou informando que id é uma chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) //significa que o id será gerado de forma automática.
    private Long id;
    @Column(nullable = false)  //informa que essa informação/campo da tabela não pode vir vazio.
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;

    public UsuarioModel(){

    }

    public UsuarioModel(UsuarioDto usuarioDto){
        this.nome = usuarioDto.nome();
        this.email = usuarioDto.email();
        this.senha = usuarioDto.senha();
    }

    public UsuarioModel(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
