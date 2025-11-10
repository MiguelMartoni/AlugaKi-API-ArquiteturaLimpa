package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Usuario;
import com.AlugaKi.infrastructure.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    UsuarioEntity toEntity(Usuario usuarioDomainObj) {
        return new UsuarioEntity(
            usuarioDomainObj.idUsuario(),
            usuarioDomainObj.nome(),
            usuarioDomainObj.email(),
            usuarioDomainObj.cpfCnpj(),
            usuarioDomainObj.contato(),
            usuarioDomainObj.senha(),
            usuarioDomainObj.cep(),
            usuarioDomainObj.endereco(),
            usuarioDomainObj.numeroResidenc(),
            usuarioDomainObj.foto()
        );
    }

    Usuario toDomainObj(UsuarioEntity usuarioEntity) {
        return new Usuario(
            usuarioEntity.getIdUsuario(),
            usuarioEntity.getNome(),
            usuarioEntity.getEmail(),
            usuarioEntity.getCpfCnpj(),
            usuarioEntity.getContato(),
            usuarioEntity.getSenha(),
            usuarioEntity.getCep(),
            usuarioEntity.getEndereco(),
            usuarioEntity.getNumeroResidenc(),
            usuarioEntity.getFoto()
        );
    }
}
