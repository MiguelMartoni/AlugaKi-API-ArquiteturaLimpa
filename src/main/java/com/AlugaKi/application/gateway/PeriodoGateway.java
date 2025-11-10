package com.AlugaKi.application.gateway;

import java.util.List;
import com.AlugaKi.domain.entity.Periodo;

public interface PeriodoGateway {  
    Periodo findPeriodoById(int id);
    List<Periodo> findAllPeriodos();
}

