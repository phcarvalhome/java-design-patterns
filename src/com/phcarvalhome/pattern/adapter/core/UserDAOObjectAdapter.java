package com.phcarvalhome.pattern.adapter.core;

import com.phcarvalhome.pattern.adapter.business.EntityDAO;
import com.phcarvalhome.pattern.privatedataclass.core.User;

public class UserDAOObjectAdapter implements IEntityDAO<User> {

    private EntityDAO entityDAO;

    public UserDAOObjectAdapter() {
        this.entityDAO = new EntityDAO();
    }

    @Override
    public User get(int id) {

        try {
            return (User) entityDAO.find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User saveOrUpdate(User entity) {

        if(entity.getId() == null){
            entityDAO.create(entity);
        } else {

            try {
                entityDAO.edit(entity);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return get(entity.getId());
    }

    @Override
    public void delete(User entity) {

        try {
            entityDAO.remove(entity.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
