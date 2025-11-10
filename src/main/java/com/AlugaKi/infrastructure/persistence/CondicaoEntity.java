package com.AlugaKi.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "condicao")
public class CondicaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicao")
    private int idCondicao;
    @Column(name = "descricao")
    private String descricao;
    
    public int getIdCondicao() {
        return idCondicao;
    }
    public void setIdCondicao(int idCondicao) {
        this.idCondicao = idCondicao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    // Construtor padrão necessário para JPA
    public CondicaoEntity() {
    }
    
    public CondicaoEntity(int idCondicao, String descricao) {
        this.idCondicao = idCondicao;
        this.descricao = descricao;
    }
}

