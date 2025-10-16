package com.AlugaKi.controller;

import com.AlugaKi.domain.entity.Endereco;
import com.AlugaKi.infrastructure.persistence.EnderecoEntity;

public class EnderecoDTOMapper {

    CreateEnderecoResponse toResponse(EnderecoEntity enderecoEntity) {
        return new CreateEnderecoResponse(enderecoEntity.getId(), enderecoEntity.getCep(), enderecoEntity.getPais(), enderecoEntity.getEstado(), enderecoEntity.getCidade(), enderecoEntity.getRua(), enderecoEntity.getNumero());
    }

    Endereco toDomainObj(CreateEnderecoRequest request) {
        return new Endereco(request.cep(), request.pais(), request.estado(), request.cidade(), request.rua(), request.numero());
    }
}
