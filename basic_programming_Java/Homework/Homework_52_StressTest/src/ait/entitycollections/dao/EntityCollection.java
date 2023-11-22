package ait.entitycollections.dao;

public interface EntityCollection extends Entity {
    public void add(Entity entity);

    public Entity removeMaxValue();
}
