package com.AlugaKi.controller;

import com.AlugaKi.domain.entity.Usuario;

public class UsuarioDTOMapper {
    CreateUsuarioResponse toResponse(Usuario usuario){
        return new CreateUsuarioResponse(
            usuario.idUsuario(), 
            usuario.nome(), 
            usuario.email(), 
            usuario.cpfCnpj(), 
            usuario.contato(), 
            usuario.cep(), 
            usuario.endereco(), 
            usuario.numeroResidenc(), 
            usuario.foto()
        );
    }

    public Usuario toUsuario(CreateUsuarioRequest request){
        return new Usuario(
            request.idUsuario(),
            request.nome(),
            request.email(),
            request.cpfCnpj(),
            request.contato(),
            request.senha(),
            request.cep(),
            request.endereco(),
            request.numeroResidenc(),
            request.foto()
        );
    }
}
