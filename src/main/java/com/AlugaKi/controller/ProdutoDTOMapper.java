package com.AlugaKi.controller;

import com.AlugaKi.domain.entity.Produto;

public class ProdutoDTOMapper {
    CreateProdutoResponse toResponse(Produto produto){
        return new CreateProdutoResponse(
            produto.idProduto(),
            produto.nome(),
            produto.descricao(),
            produto.foto(),
            produto.preco(),
            produto.categoriaIdCategoria(),
            produto.condicaoIdCondicao(),
            produto.periodoIdPeriodo(),
            produto.usuarioIdUsuario()
        );
    }

    public Produto toProduto(CreateProdutoRequest request){
        return new Produto(
            request.idProduto(),
            request.nome(),
            request.descricao(),
            request.foto(),
            request.preco(),
            request.categoriaIdCategoria(),
            request.condicaoIdCondicao(),
            request.periodoIdPeriodo(),
            request.usuarioIdUsuario()
        );
    }
}

