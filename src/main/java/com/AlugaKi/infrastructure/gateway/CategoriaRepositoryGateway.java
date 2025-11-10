package com.AlugaKi.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.AlugaKi.application.gateway.CategoriaGateway;
import com.AlugaKi.domain.entity.Categoria;
import com.AlugaKi.infrastructure.persistence.CategoriaEntity;
import com.AlugaKi.infrastructure.persistence.CategoriaRepository;

public class CategoriaRepositoryGateway implements CategoriaGateway{
    private final CategoriaRepository categoriaRepository;
    private final CategoriaEntityMapper categoriaEntityMapper;

    public CategoriaRepositoryGateway(CategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaEntityMapper = categoriaEntityMapper;
    }

    @Override
    public Categoria findCategoriaById(int id) {
        CategoriaEntity categoriaEntity = categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
        return categoriaEntityMapper.toDomainObj(categoriaEntity);
    }

    @Override
    public List<Categoria> findAllCategorias() {
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();
        return categoriaEntities.stream()
            .map(categoriaEntityMapper::toDomainObj)
            .collect(Collectors.toList());
    }
}

