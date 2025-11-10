package com.AlugaKi.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "periodo")
public class PeriodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private int idPeriodo;
    @Column(name = "descricao")
    private String descricao;
    
    public int getIdPeriodo() {
        return idPeriodo;
    }
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    // Construtor padrão necessário para JPA
    public PeriodoEntity() {
    }
    
    public PeriodoEntity(int idPeriodo, String descricao) {
        this.idPeriodo = idPeriodo;
        this.descricao = descricao;
    }
}

