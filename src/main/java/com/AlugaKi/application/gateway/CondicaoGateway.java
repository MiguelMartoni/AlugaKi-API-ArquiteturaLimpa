package com.AlugaKi.application.gateway;

import java.util.List;
import com.AlugaKi.domain.entity.Condicao;

public interface CondicaoGateway {  
    Condicao findCondicaoById(int id);
    List<Condicao> findAllCondicoes();
}

