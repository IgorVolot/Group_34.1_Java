package ait.titanic;

import java.io.*;

/*
        Задание 1. Рассчитаем общую стоимость проезда.

        Задание 2. Рассчитаем средний тариф для 1,2,3 классов путешествия.

        Задание 3. Подсчитайте общее количество выживших и умерших пассажиров.

        Задание 4. Подсчитайте общее количество выживших и умерших мужчин, женщин и детей (до 18 лет).
     */
public class PassengersDataAppl {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("train.csv"))) {
            String str = br.readLine();
            String[] cells = str.split(",");
            printCells(cells);
            str = br.readLine();

            double totalFareCost = 0;
            int totalPaxFirstClass = 0;
            double firstClassFare = 0;
            int totalPaxSecondClass = 0;
            double secondClassFare = 0;
            int totalPaxThirdClass = 0;
            double thirdClassFare = 0;

            int totalSurvived = 0;
            int totalDied = 0;
            boolean kids = true;
            int totalSurvivedMen = 0;
            int totalDiedMen = 0;
            int totalSurvivedWomen = 0;
            int totalDiedWomen = 0;
            int totalSurvivedKids = 0;
            int totalDiedKids = 0;

            while (str != null) {
                cells = str.split(",");
                totalFareCost += Double.parseDouble(cells[10]);
                if (String.valueOf(cells[6]).equals("")){
                    kids = false;
                } else {
                    kids = Double.parseDouble(cells[6]) < 18;
                }

                if (String.valueOf(cells[2]).equals("1")){
                    totalPaxFirstClass++;
                    firstClassFare += Double.parseDouble(cells[10]);
                }

                if (String.valueOf(cells[2]).equals("2")) {
                    totalPaxSecondClass++;
                    secondClassFare += Double.parseDouble(cells[10]);
                }
                if (String.valueOf(cells[2]).equals("3")) {
                    totalPaxThirdClass++;
                    thirdClassFare += Double.parseDouble(cells[10]);
                }
                if (String.valueOf(cells[1]).equals("1")) {
                    totalSurvived++;
                } else if (String.valueOf(cells[1]).equals("0")) {
                    totalDied++;
                }
                if (String.valueOf(cells[1]).equals("1") && String.valueOf(cells[5]).equals("male") && !kids){
                    totalSurvivedMen++;
                } else if (String.valueOf(cells[1]).equals("0") && String.valueOf(cells[5]).equals("male") && !kids){
                    totalDiedMen++;
                }
                if (String.valueOf(cells[1]).equals("1") && String.valueOf(cells[5]).equals("female") && !kids){
                    totalSurvivedWomen++;
                } else if (String.valueOf(cells[1]).equals("0") && String.valueOf(cells[5]).equals("female") && !kids){
                    totalDiedWomen++;
                }
                if (String.valueOf(cells[1]).equals("1") && kids){
                    totalSurvivedKids++;
                } else if (String.valueOf(cells[1]).equals("0") && kids){
                    totalDiedKids++;
                }
                str = br.readLine();
            }

            System.out.println("Total cost of fares = " + totalFareCost);
            System.out.println("Average First class fare = " + firstClassFare/totalPaxFirstClass);
            System.out.println("Average Second class fare = " + secondClassFare/totalPaxSecondClass);
            System.out.println("Average Third class fare = " + thirdClassFare/totalPaxThirdClass);
            System.out.println("Total survived passengers = " + totalSurvived);
            System.out.println("Total died passengers = " + totalDied);
            System.out.println("Total survived men = " + totalSurvivedMen);
            System.out.println("Total died men = " + totalDiedMen);
            System.out.println("Total survived women = " + totalSurvivedWomen);
            System.out.println("Total died women = " + totalDiedWomen);
            System.out.println("Total survived kids = " + totalSurvivedKids);
            System.out.println("Total died kids = " + totalDiedKids);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCells(String[] cells) {
        for (String s : cells) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }

}
