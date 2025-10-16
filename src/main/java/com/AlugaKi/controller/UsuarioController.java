package com.AlugaKi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugaKi.application.usecases.CreateUsuarioInteractor;
import com.AlugaKi.domain.entity.Usuario;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private CreateUsuarioInteractor createUsuarioInteractor;
    private final UsuarioDTOMapper usuarioDTOMapper;

    public UsuarioController(CreateUsuarioInteractor createUsuarioInteractor, UsuarioDTOMapper usuarioDTOMapper){
        this.createUsuarioInteractor = createUsuarioInteractor;
        this.usuarioDTOMapper = usuarioDTOMapper;
    }

    @PostMapping
    CreateUsuarioResponse create(@RequestBody CreateUsuarioRequest request){
        Usuario usuarioBusinessObj = usuarioDTOMapper.toUsuario(request);
        Usuario usuario = createUsuarioInteractor.createUsuario(usuarioBusinessObj);
        return usuarioDTOMapper.toResponse(usuario);
    }

    @GetMapping("/{id}")
    CreateUsuarioResponse findUsuarioById(@PathVariable int id){
        Usuario usuario = createUsuarioInteractor.findUsuarioById(id);
        return usuarioDTOMapper.toResponse(usuario);
    }

    @GetMapping
    List<CreateUsuarioResponse> findAllUsuarios(){
        List<Usuario> usuarios = createUsuarioInteractor.findAllUsuarios();
        return usuarios.stream()
            .map(usuarioDTOMapper::toResponse)
            .toList();
    }
    
}
