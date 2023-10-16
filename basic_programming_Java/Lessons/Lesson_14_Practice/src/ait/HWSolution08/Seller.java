package ait.HWSolution08;

/**
 * @author Andrej Reutow
 * created on 21.09.2023
 * <p>
 * У продавца есть товар, который он хочет продать. Он может продать товар за 100 евро, если покупатель согласен на
 * эту цену. Если покупатель не согласен на эту цену, продавец может предложить скидку в 10%.
 * Если покупатель не
 * согласен и на эту цену, продавец может предложить скидку в 20%. Если покупатель не согласен и на эту цену, продавец
 * отказывается продавать товар.
 */
public class Seller {


    public static void main(String[] args) {
        sell(100); // Товар продан
        sell(90); // Скидка 10%
        sell(70); // Товар не продан
    }


    public static void sell(int offer) {
        int price = 100;

        if (offer >= price) {
            System.out.println("Товар продан");
        } else if (offer > price * 0.9) {
            System.out.println("Скидка 10%");
            System.out.println("Новая цена: " + price * 0.9);
        } else if (offer > price * 0.8) {
            System.out.println("Скидка 20%");
            System.out.println("Новая цена: " + price * 0.8);
        } else {
            System.out.println("Товар не продан");
        }

    }


}