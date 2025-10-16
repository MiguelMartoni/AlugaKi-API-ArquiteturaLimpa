package com.AlugaKi.controller;

public record CreateUsuarioResponse(int id,String nome, String email, String cpfCnpj, String telefone, int enderecoId, boolean status) {
    
}
