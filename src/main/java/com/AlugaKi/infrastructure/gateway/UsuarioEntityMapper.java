package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Usuario;
import com.AlugaKi.infrastructure.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    UsuarioEntity toEntity(Usuario usuarioDomainObj) {
        return new UsuarioEntity(usuarioDomainObj.id(),usuarioDomainObj.nome(), usuarioDomainObj.email(), usuarioDomainObj.senha(), usuarioDomainObj.cpfCnpj(), usuarioDomainObj.telefone(), usuarioDomainObj.enderecoId(), usuarioDomainObj.status());
    }

    Usuario toDomainObj(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getId(),usuarioEntity.getNome(), usuarioEntity.getEmail(), usuarioEntity.getSenha(), usuarioEntity.getCpfCnpj(), usuarioEntity.getTelefone(), usuarioEntity.getEnderecoId(), usuarioEntity.isStatus());
    }
}
