package org.educa.service;

import org.educa.dao.ProductoDAO;
import org.educa.dao.ProductoDAOImpl;
import org.educa.entity.ProductoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoService {
    private final ProductoDAO productoDAO = new ProductoDAOImpl();


    //TODO: Método que devuelve todos los productos agrupado por Nombre de producto
    public List<ProductoEntity> findAllProducts() throws SQLException {
        // Devuelve todos los productos agrupados por nombre
        return productoDAO.findAllProduct();
    }

    //TODO: Método que devuelve un producto por nombre, talla y color
    public ProductoEntity getFirstProductoByNameTallaAndColor(String nombre, String talla, String color) throws SQLException {
        return productoDAO.findProductoByName(nombre, talla, color);
    }

    //TODO: Método que busca productos por nombre
    public List<ProductoEntity> findByName(ProductoEntity producto) throws SQLException {
        return productoDAO.findOnlyName(producto.getNombre());
    }

}
