package ait.entitycollections.dao;

public interface EntityCollection {
    public void add(Entity entity);

    public Entity removeMaxValue();
}
