package com.AlugaKi.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.AlugaKi.application.gateway.PeriodoGateway;
import com.AlugaKi.domain.entity.Periodo;
import com.AlugaKi.infrastructure.persistence.PeriodoEntity;
import com.AlugaKi.infrastructure.persistence.PeriodoRepository;

public class PeriodoRepositoryGateway implements PeriodoGateway{
    private final PeriodoRepository periodoRepository;
    private final PeriodoEntityMapper periodoEntityMapper;

    public PeriodoRepositoryGateway(PeriodoRepository periodoRepository, PeriodoEntityMapper periodoEntityMapper) {
        this.periodoRepository = periodoRepository;
        this.periodoEntityMapper = periodoEntityMapper;
    }

    @Override
    public Periodo findPeriodoById(int id) {
        PeriodoEntity periodoEntity = periodoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Período não encontrado com id: " + id));
        return periodoEntityMapper.toDomainObj(periodoEntity);
    }

    @Override
    public List<Periodo> findAllPeriodos() {
        List<PeriodoEntity> periodoEntities = periodoRepository.findAll();
        return periodoEntities.stream()
            .map(periodoEntityMapper::toDomainObj)
            .collect(Collectors.toList());
    }
}

