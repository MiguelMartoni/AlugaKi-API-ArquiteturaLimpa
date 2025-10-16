package com.AlugaKi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugaKi.application.usecases.CreateEnderecoInteractor;
import com.AlugaKi.domain.entity.Endereco;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final CreateEnderecoInteractor createEnderecoInteractor;
    private final EnderecoDTOMapper enderecoDTOMapper;

    public EnderecoController(CreateEnderecoInteractor createEnderecoInteractor, EnderecoDTOMapper enderecoDTOMapper) {
        this.createEnderecoInteractor = createEnderecoInteractor;
        this.enderecoDTOMapper = enderecoDTOMapper;
    }

    @PostMapping
    public ResponseEntity<CreateEnderecoResponse> createEndereco(@RequestBody CreateEnderecoRequest request) {
        Endereco endereco = enderecoDTOMapper.toDomainObj(request);
        Endereco createdEndereco = createEnderecoInteractor.createEndereco(endereco);
        CreateEnderecoResponse response = new CreateEnderecoResponse(0, createdEndereco.cep(), createdEndereco.pais(), createdEndereco.estado(), createdEndereco.cidade(), createdEndereco.rua(), createdEndereco.numero());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateEnderecoResponse> findEnderecoById(@PathVariable int id) {
        Endereco endereco = createEnderecoInteractor.findEnderecoById(id);
        CreateEnderecoResponse response = new CreateEnderecoResponse(id, endereco.cep(), endereco.pais(), endereco.estado(), endereco.cidade(), endereco.rua(), endereco.numero());
        return ResponseEntity.ok(response);
    }
}
