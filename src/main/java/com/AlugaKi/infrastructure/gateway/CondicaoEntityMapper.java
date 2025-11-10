package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Condicao;
import com.AlugaKi.infrastructure.persistence.CondicaoEntity;

public class CondicaoEntityMapper {

    CondicaoEntity toEntity(Condicao condicaoDomainObj) {
        return new CondicaoEntity(condicaoDomainObj.idCondicao(), condicaoDomainObj.descricao());
    }

    Condicao toDomainObj(CondicaoEntity condicaoEntity) {
        return new Condicao(condicaoEntity.getIdCondicao(), condicaoEntity.getDescricao());
    }
}

