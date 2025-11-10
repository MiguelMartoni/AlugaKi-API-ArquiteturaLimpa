package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.PeriodoGateway;
import com.AlugaKi.application.usecases.PeriodoInteractor;
import com.AlugaKi.controller.PeriodoDTOMapper;
import com.AlugaKi.infrastructure.gateway.PeriodoEntityMapper;
import com.AlugaKi.infrastructure.gateway.PeriodoRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.PeriodoRepository;

@Configuration
public class PeriodoConfig {
    
    @Bean
    PeriodoInteractor periodoInteractor(PeriodoGateway periodoGateway){
        return new PeriodoInteractor(periodoGateway);
    }

    @Bean
    PeriodoGateway periodoGateway(PeriodoRepository periodoRepository, PeriodoEntityMapper periodoEntityMapper){
        return new PeriodoRepositoryGateway(periodoRepository, periodoEntityMapper);
    }

    @Bean
    PeriodoEntityMapper periodoEntityMapper() {
        return new PeriodoEntityMapper();
    }

    @Bean
    PeriodoDTOMapper periodoDTOMapper() {
        return new PeriodoDTOMapper();
    }
    
}

