package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Produto;
import com.AlugaKi.infrastructure.persistence.ProdutoEntity;

public class ProdutoEntityMapper {

    ProdutoEntity toEntity(Produto produtoDomainObj) {
        return new ProdutoEntity(
            produtoDomainObj.idProduto(),
            produtoDomainObj.nome(),
            produtoDomainObj.descricao(),
            produtoDomainObj.foto(),
            produtoDomainObj.preco(),
            produtoDomainObj.categoriaIdCategoria(),
            produtoDomainObj.condicaoIdCondicao(),
            produtoDomainObj.periodoIdPeriodo(),
            produtoDomainObj.usuarioIdUsuario()
        );
    }

    Produto toDomainObj(ProdutoEntity produtoEntity) {
        return new Produto(
            produtoEntity.getIdProduto(),
            produtoEntity.getNome(),
            produtoEntity.getDescricao(),
            produtoEntity.getFoto(),
            produtoEntity.getPreco(),
            produtoEntity.getCategoriaIdCategoria(),
            produtoEntity.getCondicaoIdCondicao(),
            produtoEntity.getPeriodoIdPeriodo(),
            produtoEntity.getUsuarioIdUsuario()
        );
    }
}

