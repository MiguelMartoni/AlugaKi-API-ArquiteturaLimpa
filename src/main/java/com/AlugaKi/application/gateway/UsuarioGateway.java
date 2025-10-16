package com.AlugaKi.application.gateway;

import java.util.List;
import com.AlugaKi.domain.entity.Usuario;

public interface UsuarioGateway {  
    Usuario createUsuario(Usuario usuario);
    Usuario findUsuarioById(int id);
    List<Usuario> findAllUsuarios();
}   