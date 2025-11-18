package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.StatusAluguelGateway;
import com.AlugaKi.application.usecases.StatusAluguelInteractor;
import com.AlugaKi.controller.StatusAluguelDTOMapper;
import com.AlugaKi.infrastructure.gateway.StatusAluguelEntityMapper;
import com.AlugaKi.infrastructure.gateway.StatusAluguelRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.StatusAluguelRepository;

@Configuration
public class StatusAluguelConfig {
    
    @Bean
    StatusAluguelInteractor statusAluguelInteractor(StatusAluguelGateway statusAluguelGateway) {
        return new StatusAluguelInteractor(statusAluguelGateway);
    }

    @Bean
    StatusAluguelGateway statusAluguelGateway(StatusAluguelRepository statusAluguelRepository, StatusAluguelEntityMapper statusAluguelEntityMapper) {
        return new StatusAluguelRepositoryGateway(statusAluguelRepository, statusAluguelEntityMapper);
    }

    @Bean
    StatusAluguelEntityMapper statusAluguelEntityMapper() {
        return new StatusAluguelEntityMapper();
    }

    @Bean
    StatusAluguelDTOMapper statusAluguelDTOMapper() {
        return new StatusAluguelDTOMapper();
    }
}