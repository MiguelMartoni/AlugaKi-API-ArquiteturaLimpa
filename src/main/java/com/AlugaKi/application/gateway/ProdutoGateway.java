package com.AlugaKi.application.gateway;

import java.util.List;
import com.AlugaKi.domain.entity.Produto;

public interface ProdutoGateway {  
    Produto createProduto(Produto produto);
    Produto findProdutoById(int id);
    List<Produto> findAllProdutos();
}

