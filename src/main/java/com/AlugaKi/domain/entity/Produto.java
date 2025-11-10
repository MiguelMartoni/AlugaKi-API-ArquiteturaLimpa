package com.AlugaKi.domain.entity;

import java.math.BigDecimal;

public record Produto(int idProduto, String nome, String descricao, String foto, BigDecimal preco, int categoriaIdCategoria, int condicaoIdCondicao, int periodoIdPeriodo, int usuarioIdUsuario) {
    
}

