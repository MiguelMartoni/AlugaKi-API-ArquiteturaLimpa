package com.AlugaKi.domain.entity;

public record Usuario(int id, String nome, String email, String senha, String cpfCnpj, String telefone, int enderecoId, boolean status) {
    
}
