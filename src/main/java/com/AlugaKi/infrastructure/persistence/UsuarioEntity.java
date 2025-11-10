package com.AlugaKi.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Column(name = "cpf_cnpj", nullable = false, length = 15, unique = true)
    private String cpfCnpj;
    
    @Column(name = "contato", nullable = false, length = 11)
    private String contato;
    
    @Column(name = "senha", nullable = false, length = 45)
    private String senha;
    
    @Column(name = "cep", nullable = false, length = 10)
    private String cep;
    
    @Column(name = "endereço", nullable = false, length = 100)
    private String endereco;
    
    @Column(name = "numero_residenc", nullable = false, length = 6)
    private String numeroResidenc;
    
    @Column(name = "foto", nullable = false, columnDefinition = "LONGTEXT")
    private String foto;
    
    // Construtor padrão necessário para JPA
    public UsuarioEntity() {
    }
    
    public UsuarioEntity(int idUsuario, String nome, String email, String cpfCnpj, String contato, String senha, String cep, String endereco, String numeroResidenc, String foto) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.contato = contato;
        this.senha = senha;
        this.cep = cep;
        this.endereco = endereco;
        this.numeroResidenc = numeroResidenc;
        this.foto = foto;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public String getContato() {
        return contato;
    }
    
    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getNumeroResidenc() {
        return numeroResidenc;
    }
    
    public void setNumeroResidenc(String numeroResidenc) {
        this.numeroResidenc = numeroResidenc;
    }
    
    public String getFoto() {
        return foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
}

