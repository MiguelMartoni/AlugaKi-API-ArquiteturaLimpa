package com.AlugaKi.application.gateway;

import java.util.List;
import com.AlugaKi.domain.entity.StatusAluguel;

public interface StatusAluguelGateway {  
    StatusAluguel findStatusAluguelById(int id);
    List<StatusAluguel> findAllStatusAlugueis();
}