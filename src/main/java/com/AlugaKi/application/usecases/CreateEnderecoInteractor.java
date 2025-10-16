package com.AlugaKi.application.usecases;

import org.springframework.stereotype.Component;

import com.AlugaKi.application.gateway.EnderecoGateway;
import com.AlugaKi.domain.entity.Endereco;

@Component
public class CreateEnderecoInteractor {

    private final EnderecoGateway enderecoGateway;

    public CreateEnderecoInteractor(EnderecoGateway enderecoGateway) {
        this.enderecoGateway = enderecoGateway;
    }

    public Endereco createEndereco(Endereco endereco) {
        return enderecoGateway.createEndereco(endereco);
    }

    public Endereco findEnderecoById(int id) {
        return enderecoGateway.findEnderecoById(id);
    }
}
