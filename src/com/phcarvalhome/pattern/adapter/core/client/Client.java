package com.phcarvalhome.pattern.adapter.core.client;

import com.phcarvalhome.pattern.adapter.core.IEntityDAO;
import com.phcarvalhome.pattern.privatedataclass.core.User;

public class Client {

    private IEntityDAO<User> entityDAO;

    public Client(IEntityDAO<User> entityDAO) {
        this.entityDAO = entityDAO;
    }

    public User get(int id) {
        return entityDAO.get(id);
    }

    public User save(User entity) {
        return entityDAO.saveOrUpdate(entity);
    }

    public User update(User entity) {
        return entityDAO.saveOrUpdate(entity);
    }

    public void delete(User entity) {
        entityDAO.delete(entity);
    }
}
