package com.AlugaKi.controller;

public record CreateUsuarioRequest(int id, String nome, String email, String senha, String cpfCnpj, String telefone, int enderecoId, boolean status){

} 
