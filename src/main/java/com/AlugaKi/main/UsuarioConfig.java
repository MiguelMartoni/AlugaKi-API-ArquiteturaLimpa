package com.AlugaKi.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.AlugaKi.application.gateway.UsuarioGateway;
import com.AlugaKi.application.usecases.CreateUsuarioInteractor;
import com.AlugaKi.controller.UsuarioDTOMapper;
import com.AlugaKi.infrastructure.gateway.UsuarioEntityMapper;
import com.AlugaKi.infrastructure.gateway.UsuarioRepositoryGateway;
import com.AlugaKi.infrastructure.persistence.UsuarioRepository;

@Configuration
public class UsuarioConfig {
    
    @Bean
    CreateUsuarioInteractor createUsuarioCase (UsuarioGateway usuarioGateway){
        return new CreateUsuarioInteractor(usuarioGateway);
    }

    @Bean
    UsuarioGateway usuarioGateway (UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper){
        return new UsuarioRepositoryGateway(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }

    @Bean
    UsuarioDTOMapper usuarioDTOMapper() {
        return new UsuarioDTOMapper();
    }
    
}
