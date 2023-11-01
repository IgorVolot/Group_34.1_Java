package ait.example3;


import ait.example3.entity.Animal;
import ait.example3.entity.Dog;

public class Example3Runner {

    public static void main(String[] args) {
        // создание объекта не возможно, т.к. конструктор приватный
        //  SomeUtilityClass utilityClass = new SomeUtilityClass();

        Animal animal = new Dog("Black", "Tom", "Такса");
    }
}
