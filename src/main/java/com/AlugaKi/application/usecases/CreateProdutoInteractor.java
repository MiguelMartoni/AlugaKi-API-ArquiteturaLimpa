package com.AlugaKi.application.usecases;

import java.util.List;

import com.AlugaKi.application.gateway.ProdutoGateway;
import com.AlugaKi.domain.entity.Produto;

public class CreateProdutoInteractor {
    private ProdutoGateway produtoGateway;

    public CreateProdutoInteractor(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }
    
    public Produto createProduto(Produto produto) {
        return produtoGateway.createProduto(produto);
    }

    public Produto findProdutoById(int id) {
        return produtoGateway.findProdutoById(id);
    }

    public List<Produto> findAllProdutos() {
        return produtoGateway.findAllProdutos();
    }
}

