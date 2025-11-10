package com.AlugaKi.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.AlugaKi.application.gateway.CondicaoGateway;
import com.AlugaKi.domain.entity.Condicao;
import com.AlugaKi.infrastructure.persistence.CondicaoEntity;
import com.AlugaKi.infrastructure.persistence.CondicaoRepository;

public class CondicaoRepositoryGateway implements CondicaoGateway{
    private final CondicaoRepository condicaoRepository;
    private final CondicaoEntityMapper condicaoEntityMapper;

    public CondicaoRepositoryGateway(CondicaoRepository condicaoRepository, CondicaoEntityMapper condicaoEntityMapper) {
        this.condicaoRepository = condicaoRepository;
        this.condicaoEntityMapper = condicaoEntityMapper;
    }

    @Override
    public Condicao findCondicaoById(int id) {
        CondicaoEntity condicaoEntity = condicaoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Condição não encontrada com id: " + id));
        return condicaoEntityMapper.toDomainObj(condicaoEntity);
    }

    @Override
    public List<Condicao> findAllCondicoes() {
        List<CondicaoEntity> condicaoEntities = condicaoRepository.findAll();
        return condicaoEntities.stream()
            .map(condicaoEntityMapper::toDomainObj)
            .collect(Collectors.toList());
    }
}

