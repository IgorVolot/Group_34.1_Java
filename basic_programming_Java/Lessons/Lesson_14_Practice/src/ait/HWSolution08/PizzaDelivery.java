package ait.HWSolution08;

public class PizzaDelivery {
    public static boolean canDeliver(int distance, boolean isRegularCustomer) {
        int deliveryDistance = isRegularCustomer ? 10 : 5;
        if (distance <= deliveryDistance) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Можем доставить? " + canDeliver(4, false));  // Должно быть true
        System.out.println("Можем доставить? " + canDeliver(7, true));   // Должно быть true
        System.out.println("Можем доставить? " + canDeliver(7, false));  // Должно быть false
        System.out.println("Можем доставить? " + canDeliver(11, true));  // Должно быть false
    }
}
