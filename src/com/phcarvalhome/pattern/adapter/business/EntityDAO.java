package com.phcarvalhome.pattern.adapter.business;

import com.phcarvalhome.pattern.privatedataclass.business.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EntityDAO {

    private List<Entity> entityList;

    public EntityDAO() {
        entityList = new ArrayList<>();
    }

    public Entity find(int id) throws Exception {
        return entityList.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new Exception("The entity was not found!"));
    }

    public List<Object> findAll(int[] idArray){
        return entityList.stream()
                .filter(entity -> Arrays.stream(idArray)
                        .noneMatch(id -> entity.getId() == id))
                .collect(Collectors.toList());
    }

    public int create(Entity entity){
        Integer id = new Random().nextInt();

        entity.setId(id);
        entityList.add(entity);

        return entity.getId();
    }

    public void edit(Entity entity) throws Exception {
        remove(entity.getId());
        create(entity);
    }

    public void remove(int id) throws Exception {
        Entity entity = find(id);

        entityList.remove(entity);
    }

    public void removeAll(int[] idArray) throws Exception {

        for (int id : idArray) {
            remove(id);
        }
    }
}
