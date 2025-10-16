package com.AlugaKi.application.usecases;

import java.util.List;

import com.AlugaKi.application.gateway.UsuarioGateway;
import com.AlugaKi.domain.entity.Usuario;

public class CreateUsuarioInteractor {
    private UsuarioGateway usuarioGateway;

    public CreateUsuarioInteractor(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }
    
    public Usuario createUsuario(Usuario usuario) {
        return usuarioGateway.createUsuario(usuario);
    }

    public Usuario findUsuarioById(int id) {
        return usuarioGateway.findUsuarioById(id);
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioGateway.findAllUsuarios();
    }
}
