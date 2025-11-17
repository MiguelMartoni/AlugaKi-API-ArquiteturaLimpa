package com.AlugaKi.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.AlugaKi.application.gateway.StatusAluguelGateway;
import com.AlugaKi.domain.entity.StatusAluguel;
import com.AlugaKi.infrastructure.persistence.StatusAluguelEntity;
import com.AlugaKi.infrastructure.persistence.StatusAluguelRepository;

public class StatusAluguelRepositoryGateway implements StatusAluguelGateway {
    private final StatusAluguelRepository statusAluguelRepository;
    private final StatusAluguelEntityMapper statusAluguelEntityMapper;

    public StatusAluguelRepositoryGateway(StatusAluguelRepository statusAluguelRepository, StatusAluguelEntityMapper statusAluguelEntityMapper) {
        this.statusAluguelRepository = statusAluguelRepository;
        this.statusAluguelEntityMapper = statusAluguelEntityMapper;
    }

    @Override
    public StatusAluguel findStatusAluguelById(int id) {
        StatusAluguelEntity statusAluguelEntity = statusAluguelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Status de aluguel não encontrado com id: " + id));
        return statusAluguelEntityMapper.toDomainObj(statusAluguelEntity);
    }

    @Override
    public List<StatusAluguel> findAllStatusAlugueis() {
        List<StatusAluguelEntity> statusAluguelEntities = statusAluguelRepository.findAll();
        return statusAluguelEntities.stream()
            .map(statusAluguelEntityMapper::toDomainObj)
            .collect(Collectors.toList());
    }
}