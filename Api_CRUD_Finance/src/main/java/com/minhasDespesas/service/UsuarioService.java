package com.minhasDespesas.service;

import com.minhasDespesas.dto.UsuarioDto;
import com.minhasDespesas.model.UsuarioModel;
import com.minhasDespesas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {                       //Onde acontece toda a lógica de negocio

    UserRepository userRepository;

    public List<UsuarioModel> getAllUsers(){
         List<UsuarioModel> listUsers = userRepository.findAll();
        return listUsers;
    }

    public UsuarioModel userForId (Long id){
        UsuarioModel returnUserForID = userRepository.getReferenceById(id);
        return returnUserForID;
    }

    public UsuarioModel registerUser(UsuarioDto usuarioDto){
        UsuarioModel novoUsuario = new UsuarioModel(usuarioDto);
        userRepository.save(novoUsuario);
        return novoUsuario;
    }

    public UsuarioModel atualizaUsuario (UsuarioDto usuarioDto){

        UsuarioModel atualizaUsuario = userRepository.getReferenceById(usuarioDto.id());

        atualizaUsuario.setEmail(usuarioDto.email());
        atualizaUsuario.setNome(usuarioDto.nome());
        atualizaUsuario.setSenha(usuarioDto.senha());
        userRepository.save(atualizaUsuario);
        return atualizaUsuario;
    }

    public UsuarioModel deletaUsuario(Long id){

        UsuarioModel deleteUser = userRepository.getReferenceById(id);
        userRepository.delete(deleteUser);
        return deleteUser;
    }
}
