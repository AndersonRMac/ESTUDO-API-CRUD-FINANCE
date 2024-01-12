package com.minhasDespesas.repository;

import com.minhasDespesas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsuarioModel, Long> {

}


//Injeta os metodos de manipulação no banco de dados
//Atrav´s dos métodos, o JPA faz os comandos de banco
