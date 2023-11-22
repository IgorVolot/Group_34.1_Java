package ait.entitycollections.dao;

import java.util.*;

public class EntityCollectionImplA implements EntityCollection{
    private HashSet<Entity> entities;

    private int value;

    // O(1)
    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    // O(n)
    @Override
    public Entity removeMaxValue() {
        Entity maxValue = new EntityCollectionImplA();
        for (Entity entity : entities) {
            if (entity.getValue() > maxValue.getValue()) {
                maxValue = entity;
            }
            entities.remove(entity);
        }
        return maxValue;
    }

    @Override
    public int getValue() {
        return value;
    }
}
