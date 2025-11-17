package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.StatusAluguel;
import com.AlugaKi.infrastructure.persistence.StatusAluguelEntity;

public class StatusAluguelEntityMapper {

    StatusAluguelEntity toEntity(StatusAluguel statusAluguelDomainObj) {
        return new StatusAluguelEntity(statusAluguelDomainObj.idStatus(), statusAluguelDomainObj.descricao());
    }

    StatusAluguel toDomainObj(StatusAluguelEntity statusAluguelEntity) {
        return new StatusAluguel(statusAluguelEntity.getIdStatus(), statusAluguelEntity.getDescricao());
    }
}