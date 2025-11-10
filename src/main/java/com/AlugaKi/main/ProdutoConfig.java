package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.ProdutoGateway;
import com.AlugaKi.application.usecases.CreateProdutoInteractor;
import com.AlugaKi.controller.ProdutoDTOMapper;
import com.AlugaKi.infrastructure.gateway.ProdutoEntityMapper;
import com.AlugaKi.infrastructure.gateway.ProdutoRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.ProdutoRepository;

@Configuration
public class ProdutoConfig {
    
    @Bean
    CreateProdutoInteractor createProdutoCase (ProdutoGateway produtoGateway){
        return new CreateProdutoInteractor(produtoGateway);
    }

    @Bean
    ProdutoGateway produtoGateway (ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper){
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
    }

    @Bean
    ProdutoEntityMapper produtoEntityMapper() {
        return new ProdutoEntityMapper();
    }

    @Bean
    ProdutoDTOMapper produtoDTOMapper() {
        return new ProdutoDTOMapper();
    }
    
}

