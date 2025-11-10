package com.AlugaKi.infrastructure.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.AlugaKi.application.gateway.ProdutoGateway;
import com.AlugaKi.domain.entity.Produto;
import com.AlugaKi.infrastructure.persistence.ProdutoEntity;
import com.AlugaKi.infrastructure.persistence.ProdutoRepository;

public class ProdutoRepositoryGateway implements ProdutoGateway{
    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityMapper produtoEntityMapper;

    public ProdutoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoEntityMapper = produtoEntityMapper;
    }

    @Override
    public Produto createProduto(Produto produtoDomainObj) {
        ProdutoEntity produtoEntity = produtoEntityMapper.toEntity(produtoDomainObj);
        ProdutoEntity savedObj = produtoRepository.save(produtoEntity);
        return produtoEntityMapper.toDomainObj(savedObj);
    }

    @Override
    public Produto findProdutoById(int id) {
        ProdutoEntity produtoEntity = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
        return produtoEntityMapper.toDomainObj(produtoEntity);
    }

    @Override
    public List<Produto> findAllProdutos() {
        List<ProdutoEntity> produtoEntities = produtoRepository.findAll();
        return produtoEntities.stream()
            .map(produtoEntityMapper::toDomainObj)
            .collect(Collectors.toList());
    }
}

