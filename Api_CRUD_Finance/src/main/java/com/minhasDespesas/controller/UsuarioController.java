package com.minhasDespesas.controller;

import com.minhasDespesas.dto.UsuarioDto;
import com.minhasDespesas.model.UsuarioModel;
import com.minhasDespesas.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController                     //usada pra mostrar que a classe é um controller no padrão MVC
@RequestMapping("/usuario")         //indica qual o end-point que esse controller vai ouvir
public class UsuarioController {

    @Autowired                      // Autorizo a injeção dessa classe com todas as funções dela
    private UserRepository userRepository;

    @GetMapping                     //Método que vai tratar as requisições do tipo GET
    public ResponseEntity getAllUsers(){                        //ResponseEntity = Classa padrão para montar resposta para cliente.
        List<UsuarioModel> listUsers = userRepository.findAll();
        return ResponseEntity.ok(listUsers);
    }

    @PostMapping
    public ResponseEntity registraUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        UsuarioModel novoUsuario = new UsuarioModel(usuarioDto);
        userRepository.save(novoUsuario);
        return ResponseEntity.ok("Usuario Salvo com Sucesso");
    }
    /*
     No método POST, ele vai receber dados no corpo da requisição. Então é passado como parâmetro o @ResquestBody e @Valid junto
     com a classe que é passada tbm no parametro. Classe essa que é o DTO.
     */

    @PutMapping    // Verbo HTTP para atualizar um dado
    public ResponseEntity atualizaUsuario (@RequestBody @Valid UsuarioDto usuarioDto){

        //Crio uma instancia do model trazendo a referencia pelo id passada na requisição
        UsuarioModel atualizaUsuario = userRepository.getReferenceById(usuarioDto.id());      //Chamo a linha da tabela referenciada pelo Id.
        atualizaUsuario.setEmail(usuarioDto.email());
        atualizaUsuario.setNome(usuarioDto.nome());
        atualizaUsuario.setSenha(usuarioDto.senha());
        // Atualizo os dados do model com os dados que veio na requisição
        userRepository.save(atualizaUsuario);
        return ResponseEntity.ok("Usuario Atualizado com Sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaUsuario(@PathVariable Long id){

        UsuarioModel deleteUser = userRepository.getReferenceById(id);
        userRepository.delete(deleteUser);
        return ResponseEntity.ok("Exclusão feita com sucesso!");
    }

}
