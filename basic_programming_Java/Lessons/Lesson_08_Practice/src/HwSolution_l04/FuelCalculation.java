package HwSolution_l04;

public class FuelCalculation {
    // Метод для расчета расхода топлива
    public static double calculateFuelConsumption(double distance, double fuelRate) {
        return (distance / 100) * fuelRate;
    }

    public static void main(String[] args) {
        // Примеры использования метода для расчета расхода топлива
        System.out.println("Топливо для 150 км: " + calculateFuelConsumption(150, 8) + " л");
        System.out.println("Топливо для 300 км: " + calculateFuelConsumption(300, 10) + " л");
    }
}
