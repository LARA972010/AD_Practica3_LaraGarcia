package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.PedidoEntity;
import org.hibernate.Session;

public class PedidoDAOImpl implements PedidoDAO {
    /**
     * @param pedido
     */
    @Override
    public void savePed(PedidoEntity pedido) {
        try (Session session = DAOSession.getSession()) {
            session.save(pedido);
        }

    }
}
