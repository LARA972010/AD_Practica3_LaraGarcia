package org.educa.dao;

import org.educa.dao.hibernate.DAOSession;
import org.educa.entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ClienteDAOImpl implements ClienteDAO {
    /**
     * @param dni
     * @param password
     * @return
     */
    @Override
    public ClienteEntity loginClient(String dni, String password) {
        try (Session session = DAOSession.getSession()) {
            String hql = "FROM ClienteEntity WHERE dni = :dni AND pass = :password";
            Query<ClienteEntity> query = session.createQuery(hql, ClienteEntity.class);
            query.setParameter("dni", dni);
            query.setParameter("password", password);
            // Devuelve un único cliente o null si no lo encuentra
            return query.uniqueResult();
        }
    }
}
