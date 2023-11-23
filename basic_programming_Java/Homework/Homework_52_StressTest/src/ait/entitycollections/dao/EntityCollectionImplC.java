package ait.entitycollections.dao;

import java.util.*;

public class EntityCollectionImplC implements EntityCollection {
    private TreeSet<Entity> entities;

    private int value;

    Comparator<Entity> valueComparator = (v1, v2) -> Integer.compare(v1.getValue(), v2.getValue());

    public EntityCollectionImplC(int value) {
        this.entities = new TreeSet<>(valueComparator);
        this.value = value;
    }

    // O(log(n))
    @Override
    public void add(Entity entity) {
        if (entity == null) {
            throw new RuntimeException("Entity cannot be null!");
        }
        entities.add(entity);
    }

    // O(log(n))
    @Override
    public Entity removeMaxValue() {
        Entity victim = entities.last();
        if (victim != null){
            entities.remove(victim);
        }
        return victim;
    }
}
