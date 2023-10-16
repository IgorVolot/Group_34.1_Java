package ait.HWSolution08;

/**
 * @author Andrej Reutow
 * created on 21.09.2023
 * <p>
 * Вася хочет купить себе новый телефон. В магазине он видит телефоны разных цен: 10000 евро, 20000 евро, 30000 евро и 40000 евро.
 * Задание:
 * Напишите программу, которая поможет Васе выбрать телефон, подходящий по цене.
 */
public class PhoneShop {
    public static void main(String[] args) {

        // Вводим цену, которую хочет заплатить Вася
        int budget = 40000;

        boolean found = false;
        if (budget >= 10000) {
            System.out.println("Вася может купить телефон за 10000 евро.");
            found = true;
        }
        if (budget >= 20000) {
            System.out.println("Вася может купить телефон за 20000 евро.");
            found = true;
        }
        if (budget >= 30000) {
            System.out.println("Вася может купить телефон за 30000 евро.");
            found = true;
        }
        if (budget >= 40000) {
            System.out.println("Вася может купить телефон за 40000 евро.");
            found = true;
        }

        if (!found) {
            System.out.println("К сожалению, Вася не может позволить себе ни одного из предложенных телефонов.");
        }

        sellPhone();
    }

    public static void sellPhone() {
        int[] price = {10000, 20000, 30000, 40000};
        int budget = 40000;
        for (int i = 0; i < price.length; i++) {
            if (budget >= price[i]) {
                System.out.println("Вася может купить телефон за " + price[i] + " евро.");
            }
        }

    }
}