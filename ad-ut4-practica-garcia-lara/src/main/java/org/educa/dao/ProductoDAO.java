package org.educa.dao;

import org.educa.entity.ProductoEntity;

import java.util.List;

public interface ProductoDAO {
    void updateProd(ProductoEntity producto);

    List<ProductoEntity> findAllProduct();

    ProductoEntity findProductoByName(String nombre, String talla, String color);

    List<ProductoEntity> findOnlyName(String nombre);
}
