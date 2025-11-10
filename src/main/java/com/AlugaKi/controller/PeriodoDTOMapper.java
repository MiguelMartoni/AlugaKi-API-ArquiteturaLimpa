package com.AlugaKi.controller;

import com.AlugaKi.domain.entity.Periodo;

public class PeriodoDTOMapper {
    CreatePeriodoResponse toResponse(Periodo periodo){
        return new CreatePeriodoResponse(periodo.idPeriodo(), periodo.descricao());
    }

    public Periodo toPeriodo(CreatePeriodoRequest request){
        return new Periodo(request.idPeriodo(), request.descricao());
    }
}

