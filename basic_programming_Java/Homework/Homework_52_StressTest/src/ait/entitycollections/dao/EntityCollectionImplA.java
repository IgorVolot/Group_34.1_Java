package ait.entitycollections.dao;

import java.util.*;

public class EntityCollectionImplA implements EntityCollection{
    private HashSet<Entity> entities;

    private int value;

    public EntityCollectionImplA(int value) {
        this.entities = new HashSet<>();
        this.value = value;
    }

    // O(1)
    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    // O(n)
    @Override
    public Entity removeMaxValue() {
        Entity maxValue = (Entity) new EntityCollectionImplA(value);
        for (Entity entity : entities) {
            if (entity.getValue() > maxValue.getValue()) {
                maxValue = entity;
            }
            entities.remove(entity);
        }
        return maxValue;
    }
}
