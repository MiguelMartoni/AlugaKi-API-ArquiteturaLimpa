package com.AlugaKi.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.AlugaKi.application.gateway.UsuarioGateway;
import com.AlugaKi.domain.entity.Usuario;
import com.AlugaKi.infrastructure.persistence.UsuarioEntity;
import com.AlugaKi.infrastructure.persistence.UsuarioRepository;

public class UsuarioRepositoryGateway implements UsuarioGateway{
    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper usuarioEntityMapper;

    public UsuarioRepositoryGateway(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioEntityMapper  = usuarioEntityMapper;
        }

    @Override
    public Usuario createUsuario(Usuario usuarioDomainObj) {
        UsuarioEntity usuarioEntity = usuarioEntityMapper.toEntity(usuarioDomainObj);
        UsuarioEntity savedObj = usuarioRepository.save(usuarioEntity);
        return usuarioEntityMapper.toDomainObj(savedObj);
    }

    @Override
    public Usuario findUsuarioById(int id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        return usuarioEntityMapper.toDomainObj(usuarioEntity);
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();
        return usuarioEntities.stream()
            .map(usuarioEntityMapper::toDomainObj)
            .collect(Collectors.toList());
    }
}
 