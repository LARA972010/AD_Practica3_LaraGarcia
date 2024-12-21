package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoDAOImpl implements ProductoDAO {
    /**
     * @param producto
     */
    @Override
    public void updateProd(ProductoEntity producto) {
        try (Session session = DAOSession.getSession()) {
            session.update(producto);
        }

    }

    /**
     * @return
     */
    @Override
    public List<ProductoEntity> findAllProduct() {
        try (Session session = DAOSession.getSession()) {
            // Consulta HQL para obtener el nombre, precio máximo y descuento máximo por producto
            String hql = "SELECT p.nombre, MAX(p.precio), MAX(p.descuento) " +
                    "FROM ProductoEntity p " +
                    "GROUP BY p.nombre";

            Query<Object[]> query = session.createQuery(hql, Object[].class);
            List<Object[]> result = query.getResultList();

            // Crear una lista para los productos
            List<ProductoEntity> productos = new ArrayList<>();

            // Por cada resultado (nombre, precio máximo, descuento máximo)
            for (Object[] row : result) {
                String nombre = (String) row[0];
                BigDecimal maxPrecio = (BigDecimal) row[1];
                BigDecimal maxDescuento = (BigDecimal) row[2];

                // Consulta para obtener el ProductoEntity correspondiente con el precio máximo y descuento máximo
                String hqlProducto = "FROM ProductoEntity p WHERE p.nombre = :nombre " +
                        "AND p.precio = :maxPrecio " +
                        "AND p.descuento = :maxDescuento";

                Query<ProductoEntity> queryProducto = session.createQuery(hqlProducto, ProductoEntity.class);
                queryProducto.setParameter("nombre", nombre);
                queryProducto.setParameter("maxPrecio", maxPrecio);
                queryProducto.setParameter("maxDescuento", maxDescuento);

                // Obtener la lista de productos (si hay más de uno, seleccionamos el primero)
                List<ProductoEntity> productosList = queryProducto.getResultList();
                if (!productosList.isEmpty()) {
                    ProductoEntity producto = productosList.get(0); // Si hay varios, tomar el primero

                    // Calcular el precioFinal restando el descuento al precio máximo
                    BigDecimal precioFinal = maxPrecio.subtract(maxDescuento);
                    producto.setPrecioFinal(precioFinal); // Establecer el precioFinal en el producto

                    // Agregar el producto a la lista de productos
                    productos.add(producto);
                }
            }

            return productos;
        }
    }



    /**
     * @param nombre
     * @param talla
     * @param color
     * @return
     */
    @Override
    public ProductoEntity findProductoByName(String nombre, String talla, String color) {
        try (Session session = DAOSession.getSession()) {
            // Consulta para obtener los productos filtrados por nombre, talla y color
            String hql = "FROM ProductoEntity p WHERE p.nombre = :nombre AND p.talla = :talla AND p.color = :color";

            Query<ProductoEntity> query = session.createQuery(hql, ProductoEntity.class);
            query.setParameter("nombre", nombre);
            query.setParameter("talla", talla);
            query.setParameter("color", color);

            // Obtener todos los productos que coinciden con la consulta
            List<ProductoEntity> resultList = query.getResultList();

            // Usar un conjunto para filtrar las combinaciones únicas
            Set<ProductoEntity> uniqueProductos = new HashSet<>(resultList);

            if (!uniqueProductos.isEmpty()) {
                return uniqueProductos.iterator().next(); // Retornar uno de los productos únicos
            }

            return null; // Si no se encuentra el producto
        }
    }


    /**
     * @param nombre
     * @return
     */
    @Override
    public List<ProductoEntity> findOnlyName(String nombre) {
        try (Session session = DAOSession.getSession()) {
            // Consulta HQL utilizando DISTINCT para obtener combinaciones únicas de nombre, talla y color
            String hql = "SELECT DISTINCT p.nombre, p.talla, p.color " +
                    "FROM ProductoEntity p WHERE p.nombre LIKE :nombre";

            // Realizamos la consulta y obtenemos los resultados como una lista de Object[]
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            query.setParameter("nombre", "%" + nombre + "%");

            // Procesamos los resultados para devolver una lista de ProductoDTO
            List<Object[]> result = query.getResultList();
            List<ProductoEntity> productosDTO = new ArrayList<>();



            return productosDTO;
        }
    }

}
