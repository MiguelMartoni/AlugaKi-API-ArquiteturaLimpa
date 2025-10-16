package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.EnderecoGateway;
import com.AlugaKi.application.usecases.CreateEnderecoInteractor;
import com.AlugaKi.controller.EnderecoDTOMapper;
import com.AlugaKi.infrastructure.gateway.EnderecoEntityMapper;
import com.AlugaKi.infrastructure.gateway.EnderecoRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.EnderecoRepository;

@Configuration
public class EnderecoConfig {

    @Bean
    CreateEnderecoInteractor createEnderecoCase (EnderecoGateway enderecoGateway){
        return new CreateEnderecoInteractor(enderecoGateway);
    }

    @Bean
    EnderecoGateway enderecoGateway (EnderecoRepository enderecoRepository, EnderecoEntityMapper enderecoEntityMapper){
        return new EnderecoRepositoryGateway(enderecoRepository, enderecoEntityMapper);
    }

    @Bean
    EnderecoEntityMapper enderecoEntityMapper() {
        return new EnderecoEntityMapper();
    }

    @Bean
    EnderecoDTOMapper enderecoDTOMapper() {
        return new EnderecoDTOMapper();
    }
}
