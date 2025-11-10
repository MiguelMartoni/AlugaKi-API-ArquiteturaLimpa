package com.AlugaKi.infrastructure.persistence;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int idProduto;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;
    
    @Column(name = "foto", nullable = false, columnDefinition = "LONGTEXT")
    private String foto;
    
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    
    @Column(name = "categoria_id_categoria", nullable = false)
    private int categoriaIdCategoria;
    
    @Column(name = "condicao_id_condicao", nullable = false)
    private int condicaoIdCondicao;
    
    @Column(name = "periodo_id_periodo", nullable = false)
    private int periodoIdPeriodo;
    
    @Column(name = "usuario_id_usuario", nullable = false)
    private int usuarioIdUsuario;
    
    // Construtor padrão necessário para JPA
    public ProdutoEntity() {
    }
    
    public ProdutoEntity(int idProduto, String nome, String descricao, String foto, BigDecimal preco, int categoriaIdCategoria, int condicaoIdCondicao, int periodoIdPeriodo, int usuarioIdUsuario) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.preco = preco;
        this.categoriaIdCategoria = categoriaIdCategoria;
        this.condicaoIdCondicao = condicaoIdCondicao;
        this.periodoIdPeriodo = periodoIdPeriodo;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    
    public int getIdProduto() {
        return idProduto;
    }
    
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getFoto() {
        return foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public BigDecimal getPreco() {
        return preco;
    }
    
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    public int getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }
    
    public void setCategoriaIdCategoria(int categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }
    
    public int getCondicaoIdCondicao() {
        return condicaoIdCondicao;
    }
    
    public void setCondicaoIdCondicao(int condicaoIdCondicao) {
        this.condicaoIdCondicao = condicaoIdCondicao;
    }
    
    public int getPeriodoIdPeriodo() {
        return periodoIdPeriodo;
    }
    
    public void setPeriodoIdPeriodo(int periodoIdPeriodo) {
        this.periodoIdPeriodo = periodoIdPeriodo;
    }
    
    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }
    
    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
}