package ait.example1;

public class CarAppRunner {
    public static void main(String[] args) {
        Car carCar = new Car();
        carCar.drive();

        Transport transportCar = new Car();
        Transport transportPlane = new Plane();
        transportCar.move();
        transportPlane.move();

        Transport[] transports = {transportCar, transportPlane};

        for (int i = 0; i < transports.length; i++) {
            Transport currentIterableTransport = transports[i]; // итерируемый элемент массива

            if (currentIterableTransport instanceof Plane) {
                Plane plane = (Plane) currentIterableTransport;
                plane.fly();
            }

            if (currentIterableTransport instanceof Car) {
                ((Car) currentIterableTransport).drive();
            }
        }

//        Car car = (Car) transportPlane; // Transport  = Plane
//        car.drive();
//        Plane plane = (Plane) carCar; // ошибка на стадии компиляции


    }
}
