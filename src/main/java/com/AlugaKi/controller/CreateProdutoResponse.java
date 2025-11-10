package com.AlugaKi.controller;

import java.math.BigDecimal;

public record CreateProdutoResponse(int idProduto, String nome, String descricao, String foto, BigDecimal preco, int categoriaIdCategoria, int condicaoIdCondicao, int periodoIdPeriodo, int usuarioIdUsuario) {
    
}

