package com.AlugaKi.controller;

public record CreateEnderecoRequest(String cep, String pais, String estado, String cidade, String rua, String numero) {

}
