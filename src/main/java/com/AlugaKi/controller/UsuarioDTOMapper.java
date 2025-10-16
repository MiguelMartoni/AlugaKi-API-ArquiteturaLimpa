package com.AlugaKi.controller;

import com.AlugaKi.domain.entity.Usuario;

public class UsuarioDTOMapper {
    CreateUsuarioResponse toResponse(Usuario usuario){
        return new CreateUsuarioResponse(usuario.id(), usuario.nome(),usuario.email(),usuario.cpfCnpj(),usuario.telefone(),usuario.enderecoId(),usuario.status());
    }

    public Usuario toUsuario(CreateUsuarioRequest request){
        return new Usuario(request.id(),request.nome(),request.email(),request.senha(),request.cpfCnpj(),request.telefone(),request.enderecoId(),request.status());
    }
}
