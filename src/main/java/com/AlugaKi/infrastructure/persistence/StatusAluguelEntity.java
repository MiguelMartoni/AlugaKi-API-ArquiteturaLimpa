package com.AlugaKi.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_aluguel")
public class StatusAluguelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private int idStatus;
    
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    
    // Construtor padrão necessário para JPA
    public StatusAluguelEntity() {
    }
    
    public StatusAluguelEntity(int idStatus, String descricao) {
        this.idStatus = idStatus;
        this.descricao = descricao;
    }
    
    public int getIdStatus() {
        return idStatus;
    }
    
    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
