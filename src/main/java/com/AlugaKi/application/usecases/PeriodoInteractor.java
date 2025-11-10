package com.AlugaKi.application.usecases;

import java.util.List;

import com.AlugaKi.application.gateway.PeriodoGateway;
import com.AlugaKi.domain.entity.Periodo;

public class PeriodoInteractor {
    private PeriodoGateway periodoGateway;

    public PeriodoInteractor(PeriodoGateway periodoGateway) {
        this.periodoGateway = periodoGateway;
    }

    public Periodo findPeriodoById(int id) {
        return periodoGateway.findPeriodoById(id);
    }

    public List<Periodo> findAllPeriodos() {
        return periodoGateway.findAllPeriodos();
    }
}

