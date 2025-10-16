package com.AlugaKi.application.gateway;

import com.AlugaKi.domain.entity.Endereco;

public interface EnderecoGateway {
    Endereco createEndereco(Endereco endereco);
    Endereco findEnderecoById(int id);
}
