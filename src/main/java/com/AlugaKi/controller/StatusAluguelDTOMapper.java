package com.AlugaKi.controller;

import com.AlugaKi.domain.entity.StatusAluguel;

public class StatusAluguelDTOMapper {
    
    public StatusAluguelResponse toResponse(StatusAluguel statusAluguel) {
        return new StatusAluguelResponse(
            statusAluguel.idStatus(), 
            statusAluguel.descricao()
        );
    }
}