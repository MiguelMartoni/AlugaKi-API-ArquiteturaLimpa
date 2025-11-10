package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.CondicaoGateway;
import com.AlugaKi.infrastructure.gateway.CondicaoEntityMapper;
import com.AlugaKi.infrastructure.gateway.CondicaoRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.CondicaoRepository;

@Configuration
public class CondicaoConfig {
    
    @Bean
    CondicaoGateway condicaoGateway(CondicaoRepository condicaoRepository, CondicaoEntityMapper condicaoEntityMapper){
        return new CondicaoRepositoryGateway(condicaoRepository, condicaoEntityMapper);
    }

    @Bean
    CondicaoEntityMapper condicaoEntityMapper() {
        return new CondicaoEntityMapper();
    }
    
}

