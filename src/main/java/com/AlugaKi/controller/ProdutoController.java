package com.AlugaKi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugaKi.application.usecases.CreateProdutoInteractor;
import com.AlugaKi.domain.entity.Produto;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    private CreateProdutoInteractor createProdutoInteractor;
    private final ProdutoDTOMapper produtoDTOMapper;

    public ProdutoController(CreateProdutoInteractor createProdutoInteractor, ProdutoDTOMapper produtoDTOMapper){
        this.createProdutoInteractor = createProdutoInteractor;
        this.produtoDTOMapper = produtoDTOMapper;
    }

    @PostMapping
    CreateProdutoResponse create(@RequestBody CreateProdutoRequest request){
        Produto produtoBusinessObj = produtoDTOMapper.toProduto(request);
        Produto produto = createProdutoInteractor.createProduto(produtoBusinessObj);
        return produtoDTOMapper.toResponse(produto);
    }

    @GetMapping("/{id}")
    CreateProdutoResponse findProdutoById(@PathVariable int id){
        Produto produto = createProdutoInteractor.findProdutoById(id);
        return produtoDTOMapper.toResponse(produto);
    }

    @GetMapping
    List<CreateProdutoResponse> findAllProdutos(){
        List<Produto> produtos = createProdutoInteractor.findAllProdutos();
        return produtos.stream()
            .map(produtoDTOMapper::toResponse)
            .toList();
    }
    
}

