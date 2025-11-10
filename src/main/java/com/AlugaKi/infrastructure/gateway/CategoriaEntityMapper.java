package com.AlugaKi.infrastructure.gateway;

import com.AlugaKi.domain.entity.Categoria;
import com.AlugaKi.infrastructure.persistence.CategoriaEntity;

public class CategoriaEntityMapper {

    CategoriaEntity toEntity(Categoria categoriaDomainObj) {
        return new CategoriaEntity(categoriaDomainObj.idCategoria(), categoriaDomainObj.descricao());
    }

    Categoria toDomainObj(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getIdCategoria(), categoriaEntity.getDescricao());
    }
}

