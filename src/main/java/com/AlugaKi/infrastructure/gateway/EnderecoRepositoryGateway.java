package com.AlugaKi.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.AlugaKi.application.gateway.EnderecoGateway;
import com.AlugaKi.domain.entity.Endereco;
import com.AlugaKi.infrastructure.persistence.EnderecoEntity;
import com.AlugaKi.infrastructure.persistence.EnderecoRepository;

@Component
public class EnderecoRepositoryGateway implements EnderecoGateway {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoEntityMapper enderecoEntityMapper;

    public EnderecoRepositoryGateway(EnderecoRepository enderecoRepository, EnderecoEntityMapper enderecoEntityMapper) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoEntityMapper = enderecoEntityMapper;
    }

    @Override
    public Endereco createEndereco(Endereco endereco) {
        EnderecoEntity enderecoEntity = enderecoEntityMapper.toEntity(endereco);
        EnderecoEntity savedEnderecoEntity = enderecoRepository.save(enderecoEntity);
        return enderecoEntityMapper.toDomainObj(savedEnderecoEntity);
    }

    public EnderecoEntity createEnderecoEntity(Endereco endereco) {
        EnderecoEntity enderecoEntity = enderecoEntityMapper.toEntity(endereco);
        return enderecoRepository.save(enderecoEntity);
    }

    @Override
    public Endereco findEnderecoById(int id) {
        EnderecoEntity enderecoEntity = enderecoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Endereço não encontrado com id: " + id));
        return enderecoEntityMapper.toDomainObj(enderecoEntity);
    }
}
