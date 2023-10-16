package HwSolution_l04;

public class CryptoCalculator {
    // 1. На какую сумму Вася может рассчитывать, если продаст все свои монеты?
    public static double calculateTotalValue(double initialCoins, double currentPrice) {
        return initialCoins * currentPrice;
    }

    // 2. Какая прибыль будет у Васи, если он продаст монеты сейчас?
    public static double calculateProfit(double initialCoins, double initialPrice, double currentPrice) {
        return (currentPrice - initialPrice) * initialCoins;
    }

    // 3. Сколько монет нужно продать, чтобы получить x прибыль?
    public static double coinsForXProfit(double initialCoins, double initialPrice, double currentPrice, double desiredProfit) {
        return desiredProfit / (currentPrice - initialPrice);
    }

    // 4. Какая стоимость монеты должна быть, чтобы получить x прибыль?
    public static double priceForXProfit(double initialCoins, double initialPrice, double desiredProfit) {
        return (desiredProfit / initialCoins) + initialPrice;
    }

    // 5. Сколько монет нужно по текущему курсу, чтобы получить x сумму?
    public static double coinsForXAmount(double currentPrice, double desiredAmount) {
        return desiredAmount / currentPrice;
    }

    // 6. Всё то же самое, только любой доход облагается налогом. Налог 23%.
    public static double applyTax(double income) {
        return income * 0.77;  // 100% - 23% = 77%
    }

    public static void main(String[] args) {
        double initialCoins = 12350;
        double initialPrice = 0.27;
        double currentPrice = 16.38;

        System.out.println("Total Value: " + calculateTotalValue(initialCoins, currentPrice));
        System.out.println("Profit: " + calculateProfit(initialCoins, initialPrice, currentPrice));
        System.out.println("Coins for 1000 EUR Profit: " + coinsForXProfit(initialCoins, initialPrice, currentPrice, 1000));
        System.out.println("Price for 1000 EUR Profit: " + priceForXProfit(initialCoins, initialPrice, 1000));
        System.out.println("Coins for 1000 EUR Amount: " + coinsForXAmount(currentPrice, 1000));
        System.out.println("Profit after Tax: " + applyTax(calculateProfit(initialCoins, initialPrice, currentPrice)));
    }
}
