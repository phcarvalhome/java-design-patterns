package com.phcarvalhome.pattern.adapter.core;

import com.phcarvalhome.pattern.adapter.business.EntityDAO;
import com.phcarvalhome.pattern.privatedataclass.core.User;

public class UserDAOClassAdapter extends EntityDAO implements IEntityDAO<User> {

    @Override
    public User get(int id) {

        try {
            return (User) find(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User saveOrUpdate(User entity) {

        if(entity.getId() == null){
            create(entity);
        } else {

            try {
                edit(entity);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return get(entity.getId());
    }

    @Override
    public void delete(User entity) {

        try {
            remove(entity.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
