package ait.example1;

public class CarAppRunner2 {
    public static void main(String[] args) {
        Transport transportTruck = new Truck();
        transportTruck.move(); // Transport is moving

        Transport transportCar = new Car();
        transportCar.move(); // My car is moving


        // Статический полиморфизм (перегрузка методов и операторов)
        go();
        go("my param 1");
        go(1);
        go("my str param", 2);

        // проверка статических переменных
        Transport plane1 = new Plane();
        Transport plane2 = new Plane();
        Transport plane3 = new Plane();

        plane1.move(); // Non static var: 1, Static var: 1
        plane3.move(); // Non static var: 1, Static var: 2
        plane2.move(); // Non static var: 1, Static var: 3

        Plane.idCounter++; // 4 + 1

        plane1.move(); // Non static var: 2, Static var: 5

        Plane.idCounter += 100; // 5 + 100
        plane2.move(); // Non static var: 2, Static var: 106
        plane2.move(); // Non static var: 3, Static var: 107

    }

    public static void go() {
        System.out.println("Go");
    }

    public static void go(String param1) {
        System.out.println("Go, param1 " + param1);
    }

    public static void go(Integer param1) {
        System.out.println("Go, param1 " + param1);
    }

    public static void go(String param1, Integer param2) {
        System.out.println("Go, param1: " + param1 + " param2: " + param2);
    }
}