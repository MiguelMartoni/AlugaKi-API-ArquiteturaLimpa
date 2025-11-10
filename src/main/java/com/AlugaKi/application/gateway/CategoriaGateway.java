package com.AlugaKi.application.gateway;

import java.util.List;
import com.AlugaKi.domain.entity.Categoria;

public interface CategoriaGateway {  
    Categoria findCategoriaById(int id);
    List<Categoria> findAllCategorias();
}

