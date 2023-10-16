package ait.practice.model.pizza;

import java.util.Random;

public class Pizza {
    public static void main(String[] args) {
        Person[] peoples = new Person[]{new Person(1, "Name1"), new Person(2, "Name2"), new Person(3, "Name3"), new Person(4, "Name4"), new Person(5, "Name5"), new Person(6, "Name6"), new Person(7, "Name7"), new Person(8, "Name8")};
        new Random();
        int arraySize = (int)(Math.random() * 4.0 + 5.0);
        Person[] participants = new Person[arraySize];

        int i;
        for(i = 0; i < participants.length; ++i) {
            participants[i] = peoples[i];
        }

        eatNumOfSliceByPart(participants);

        for(i = 0; i < participants.length; ++i) {
            participants[i].sayResult();
        }

        System.out.println("---------- Sorted -----------------");
        sortedPlaceOfWinners(participants);

        for(i = 0; i < participants.length; ++i) {
            participants[i].sayResult();
        }

        System.out.println("=============== Winners =====================");
        place1(participants);
        awardsForWinners(participants, 1);
        place2(participants);
        awardsForWinners(participants, 2);
        place3(participants);
        awardsForWinners(participants, 3);
        System.out.println("------------ Number of Pizzas ----------------");
        eatNumOfSliceByPart(participants);
    }

    public static void eatNumOfSliceByPart(Person[] peoples) {
        Random random = new Random();

        for(int i = 0; i < peoples.length; ++i) {
            Person currentPerson = peoples[i];
            int slices = random.nextInt(7);
            currentPerson.setPizzaSlices(slices);
            int totalSlices = currentPerson.getPizzaSlices();
            System.out.println("Total slices eat " + totalSlices);
        }

    }

    public static void sortedPlaceOfWinners(Person[] particip) {
        for(int i = 0; i < particip.length - 1; ++i) {
            for(int j = 0; j < particip.length - 1 - i; ++j) {
                if (particip[j].getPizzaSlices() > particip[j + 1].getPizzaSlices()) {
                    Person t = particip[j];
                    particip[j] = particip[j + 1];
                    particip[j + 1] = t;
                }
            }
        }

    }

    public static void place1(Person[] participants) {
        Person winner = null;
        sortedPlaceOfWinners(participants);

        for(int i = participants.length - 1; i >= 0; --i) {
            winner = participants[participants.length - 1];
        }

        System.out.println("The winner of competition is - " + winner.getName());
    }

    public static void place2(Person[] participants) {
        Person place2 = null;
        sortedPlaceOfWinners(participants);

        for(int i = participants.length - 1; i >= 0; --i) {
            place2 = participants[participants.length - 2];
        }

        System.out.println("Second place is - " + place2.getName());
    }

    public static void place3(Person[] participants) {
        Person place3 = null;
        sortedPlaceOfWinners(participants);

        for(int i = participants.length - 1; i >= 0; --i) {
            place3 = participants[participants.length - 3];
        }

        System.out.println("Third place is - " + place3.getName());
    }

    public static void awardsForWinners(Person[] people, int place) {
        switch (place) {
            case 1:
                System.out.println("Первому месту - золотую медаль и сертификат на бесплатную пиццу.");
                break;
            case 2:
                System.out.println("Второму месту - серебряную медаль и сертификат на скидку 50% на следующую пиццу,");
                break;
            case 3:
                System.out.println("Третьему месту - бронзовую медаль и сертификат на скидку 25% на следующую пиццу.");
        }

    }
}
