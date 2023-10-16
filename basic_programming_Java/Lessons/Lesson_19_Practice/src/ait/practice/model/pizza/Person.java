package ait.practice.model.pizza;

public class Person {
    private int id;
    private String name;
    private int pizzaSlices;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPizzaSlices() {
        return this.pizzaSlices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayResult() {
        System.out.println("I'm " + this.name + ", I eat " + this.pizzaSlices + " slices.");
    }

    public void setPizzaSlices(int pizzaSlices) {
        this.pizzaSlices = pizzaSlices;
    }
}
