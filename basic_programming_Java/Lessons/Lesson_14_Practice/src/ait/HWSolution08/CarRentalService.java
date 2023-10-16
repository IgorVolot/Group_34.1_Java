package ait.HWSolution08;

public class CarRentalService {
    public static void main(String[] args) {
        char carType = 'E';
        int days = 5;
        int age = 25;
        int experience = 3;
        char insurance = 'O';
        boolean isVip = true;
        boolean hasCoupon = false;
        boolean wantsGps = true;
        boolean wantsChildSeat = false;

        if (!canRent(carType, age, experience, isVip)) {
            System.out.println("Клиент не может арендовать этот тип автомобиля.");

        } else {
            double baseCost = calculateBaseCost(carType, days);
            int discount = calculateDiscount(days, isVip, hasCoupon);
            double insuranceCost = calculateInsurance(insurance);
            double extras = calculateExtras(wantsGps, wantsChildSeat);

            double totalCost = baseCost * (1 - discount / 100.0) + insuranceCost + extras;

            if (discount > 25) {
                System.out.println("Вы получили купон на следующий прокат!");
                totalCost = baseCost * 0.75 + insuranceCost + extras;
            }

            System.out.println("Общая стоимость: " + totalCost);
        }
    }

    public static double calculateBaseCost(char carType, int days) {
        double dailyRate = 0;
        switch (carType) {
            case 'E':
                dailyRate = 100;
                break;
            case 'B':
                dailyRate = 200;
                break;
            case 'L':
                dailyRate = 300;
                break;
        }
        return dailyRate * days;
    }

    public static boolean canRent(char carType, int age, int experience, boolean isVip) {
        if (carType == 'L') {
            if (isVip && age >= 20) {
                return true;
            }
            if (age >= 23 && experience >= 5) {
                return true;
            }
            return false;
        }
        return true;

//        return carType == 'L' ? (isVip && age >= 20) || (age >= 23 && experience >= 5) : true;
    }

    public static int calculateDiscount(int days, boolean isVip, boolean hasCoupon) {
        int discount = 0;
        if (days > 30) {
            discount += 10;
        } else if (days > 7) {
            discount += 6;
        } else if (days > 3) {
            discount += 4;
        }

        if (isVip) {
            discount += 12;
        }

        if (hasCoupon) {
            discount += 5;
        }

        return discount;
    }

    public static double calculateInsurance(char insurance) {
        switch (insurance) {
            case 'O':
                return 20;
            case 'K':
                return 50;
            default:
                return 0;
        }
    }

    public static double calculateExtras(boolean wantsGps, boolean wantsChildSeat) {
        double extras = 0;
        if (wantsGps) {
            extras += 10;
        }
        if (wantsChildSeat) {
            extras += 5;
        }
        return extras;
    }
}
