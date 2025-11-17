package com.AlugaKi.application.usecases;

import java.util.List;

import com.AlugaKi.application.gateway.StatusAluguelGateway;
import com.AlugaKi.domain.entity.StatusAluguel;

public class StatusAluguelInteractor {
    private StatusAluguelGateway statusAluguelGateway;

    public StatusAluguelInteractor(StatusAluguelGateway statusAluguelGateway) {
        this.statusAluguelGateway = statusAluguelGateway;
    }

    public StatusAluguel findStatusAluguelById(int id) {
        return statusAluguelGateway.findStatusAluguelById(id);
    }

    public List<StatusAluguel> findAllStatusAlugueis() {
        return statusAluguelGateway.findAllStatusAlugueis();
    }
}