package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Endereco;
import com.AlugaKi.infrastructure.persistence.EnderecoEntity;

public class EnderecoEntityMapper {

    EnderecoEntity toEntity(Endereco enderecoDomainObj) {
        return new EnderecoEntity(
            enderecoDomainObj.cep(), 
            enderecoDomainObj.pais(), 
            enderecoDomainObj.estado(), 
            enderecoDomainObj.cidade(), 
            enderecoDomainObj.rua(), 
            enderecoDomainObj.numero()
        );
    }

    Endereco toDomainObj(EnderecoEntity enderecoEntity) {
        return new Endereco(
            enderecoEntity.getCep(), 
            enderecoEntity.getPais(), 
            enderecoEntity.getEstado(), 
            enderecoEntity.getCidade(), 
            enderecoEntity.getRua(), 
            enderecoEntity.getNumero()
        );
    }
}
