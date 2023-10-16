package HwSolution_l04;

public class EnergyCalculator {
    // Расчет электроэнергии в час
    public static double calculateHourlyConsumption(double fridgeWatt, double acWatt) {
        return (fridgeWatt + acWatt) / 1000; // В кВт
    }

    // Расчет месячных расходов на электроэнергию
    public static double calculateMonthlyCost(double hourlyConsumption, double costPerKWh) {
        return hourlyConsumption * 24 * 30 * costPerKWh;
    }

    public static void main(String[] args) {
        // Примеры
        System.out.println("Месячные расходы (150 Вт холодильник, 2000 Вт кондиционер, 0.15 евро/кВтч): " +
                calculateMonthlyCost(calculateHourlyConsumption(150, 2000), 0.15));
        System.out.println("Месячные расходы (200 Вт холодильник, 1800 Вт кондиционер, 0.20 евро/кВтч): " +
                calculateMonthlyCost(calculateHourlyConsumption(200, 1800), 0.20));
    }
}
