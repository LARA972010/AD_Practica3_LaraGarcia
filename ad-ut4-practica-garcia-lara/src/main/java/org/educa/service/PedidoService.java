package org.educa.service;

import org.educa.dao.PedidoDAO;
import org.educa.dao.PedidoDAOImpl;
import org.educa.dao.ProductoDAO;
import org.educa.dao.ProductoDAOImpl;
import org.educa.entity.PedidoEntity;
import org.educa.entity.ProductoEntity;

public class PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();
    private final ProductoDAO productoDAO = new ProductoDAOImpl();


    public void insertarPedido(PedidoEntity pedido) {
        pedidoDAO.savePed(pedido);

        // Actualizar el estado de los productos
        //for (ProductoEntity producto : pedido.getProductos()) {
            //producto.setEstadoProducto("En Pedido"); // Cambiar el estado del producto
            //productoDAO.updateProd(producto);
        //}

        // Crear un historial de pedidos (si se requiere) aquí.

    }
}
