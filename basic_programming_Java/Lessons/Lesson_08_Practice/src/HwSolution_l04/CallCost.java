package HwSolution_l04;

public class CallCost {
    // Метод для расчета стоимости звонков
    public static double calculateCallCost(int minutes, double rate) {
        return minutes * rate;
    }

    public static void main(String[] args) {
        // Примеры использования метода для расчета стоимости звонков
        System.out.println("Стоимость 15 минут: " + calculateCallCost(15, 0.20) + " евро");
        System.out.println("Стоимость 30 минут: " + calculateCallCost(30, 0.15) + " евро");
    }
}
