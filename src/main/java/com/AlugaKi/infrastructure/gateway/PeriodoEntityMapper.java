package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Periodo;
import com.AlugaKi.infrastructure.persistence.PeriodoEntity;

public class PeriodoEntityMapper {

    PeriodoEntity toEntity(Periodo periodoDomainObj) {
        return new PeriodoEntity(periodoDomainObj.idPeriodo(), periodoDomainObj.descricao());
    }

    Periodo toDomainObj(PeriodoEntity periodoEntity) {
        return new Periodo(periodoEntity.getIdPeriodo(), periodoEntity.getDescricao());
    }
}

