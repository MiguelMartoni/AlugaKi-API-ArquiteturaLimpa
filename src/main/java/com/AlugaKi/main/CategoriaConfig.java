package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.CategoriaGateway;
import com.AlugaKi.infrastructure.gateway.CategoriaEntityMapper;
import com.AlugaKi.infrastructure.gateway.CategoriaRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.CategoriaRepository;

@Configuration
public class CategoriaConfig {
    
    @Bean
    CategoriaGateway categoriaGateway(CategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper){
        return new CategoriaRepositoryGateway(categoriaRepository, categoriaEntityMapper);
    }

    @Bean
    CategoriaEntityMapper categoriaEntityMapper() {
        return new CategoriaEntityMapper();
    }
    
}

