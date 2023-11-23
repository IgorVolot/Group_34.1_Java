package ait.entitycollections.dao;

import java.util.*;

public class EntityCollectionImplB implements EntityCollection {
    private TreeSet<Entity> entities;

    private int value;

    Comparator<Entity> valueComparator = (v1, v2) -> Integer.compare(v1.getValue(), v2.getValue());

    public EntityCollectionImplB(int value) {
        this.entities = new TreeSet<>(valueComparator);
        this.value = value;
    }

    // O(log(n))
    @Override
    public void add(Entity entity) {
        entities.add(entity);
    }

    // O(log(n))
    @Override
    public Entity removeMaxValue() {
        EntityCollectionImplB maxValue = new EntityCollectionImplB(value);
        Entity victim = entities.higher((Entity) maxValue);
        if (victim != null){
            entities.remove(victim);
        }
        return victim;
    }
}
