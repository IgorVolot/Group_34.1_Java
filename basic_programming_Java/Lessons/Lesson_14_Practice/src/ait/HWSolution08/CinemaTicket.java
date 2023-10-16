package ait.HWSolution08;
/**
 * @author Andrej Reutow
 * created on 21.09.2023
 */
public class CinemaTicket {
    public static void main(String[] args) {
        System.out.println("Цена билета: " + calculateTicketPrice(25, false, true));
        System.out.println("Цена билета: " + calculateTicketPrice(17, false, false));
        System.out.println("Цена билета: " + calculateTicketPrice(65, false, false));
        System.out.println("Цена билета: " + calculateTicketPrice(20, true, false));
    }

    public static int calculateTicketPrice(int age, boolean isStudent, boolean isVip) {
        int price = 0;

        if (age < 18) {
            price = 100;
        } else if (age >= 18 && age <= 64) {
            if (isStudent) {
                price = 150;
            } else {
                price = 200;
            }
        } else {
            price = 150;
        }

        if (isVip) {
            price += 50;
        }

        return price;
    }
}