package HwSolution_l04;

public class CalorieCalculation {
    // Метод для расчета сожженных калорий
    public static int calculateCaloriesBurnt(int minutes, int caloriesPerMinute) {
        return minutes * caloriesPerMinute;
    }

    public static void main(String[] args) {
        // Примеры использования метода для расчета сожженных калорий
        System.out.println("Сожженные калории за 20 минут: " + calculateCaloriesBurnt(20, 8));
        System.out.println("Сожженные калории за 30 минут: " + calculateCaloriesBurnt(30, 10));
    }
}
