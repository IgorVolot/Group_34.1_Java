package ait.practice.yachts;

import ait.practice.yachts.dao.YachtClub;
import ait.practice.yachts.dao.YachtClubImpl;
import ait.practice.yachts.model.Yacht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class YachtAppl {
    public static void main(String[] args) {
        YachtClub myYachtClub = new YachtClubImpl(10);
        myYachtClub.addYacht(new Yacht("Name1", "Manufacture1", 2012, 25.1, "plastic", 2850_000));
        myYachtClub.addYacht(new Yacht("Name2", "Manufacture2", 2010, 34.3, "plastic", 1230_000));
        myYachtClub.addYacht(new Yacht("Name3", "Manufacture4", 2018, 17.5, "metal", 1870_000));
        myYachtClub.addYacht(new Yacht("Name4", "Manufacture5", 1978, 27.2, "wood", 380_000));
        myYachtClub.addYacht(new Yacht("Name5", "Manufacture3", 1994, 13.8, "plastic", 1850_000));
        myYachtClub.addYacht(new Yacht("Name6", "Manufacture2", 2020, 28.4, "metal", 850_000));
        myYachtClub.addYacht(new Yacht("Name7", "Manufacture1", 2003, 43.6, "plastic", 2290_000));
        myYachtClub.addYacht(new Yacht("Name8", "Manufacture5", 1967, 78.2, "wood", 4520_000));
        myYachtClub.addYacht(new Yacht("Name9", "Manufacture1", 2022, 42.4, "plastic", 4180_000));

        myYachtClub.printYachts();

        System.out.println("================ Find Yacht by material ===============\n");
        StreamSupport.stream(Arrays.spliterator(myYachtClub.findYachtByMaterial("WOOD")), false)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("================ Find Yacht more expensive than ===============\n");
        StreamSupport.stream(Arrays.spliterator(myYachtClub.findYachtByPriceGreaterThan(2_500_000)), false)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("================ Find Yacht manufactures between years ... ===============\n");
        StreamSupport.stream(Arrays.spliterator(myYachtClub.findYachtByManufactureYear(2015, 2021)), false)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("--------------- Sort Yacht by Price -------------------\n");
        StreamSupport.stream(Arrays.spliterator(myYachtClub.sortYachtByPrice()), false)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("--------------- Get average Price of selected Yachts -------------------\n");

        Yacht[] yachtList = {new Yacht("Name4", "Manufacture5", 1978, 27.2, "wood", 380_000),
                new Yacht("Name5", "Manufacture3", 1994, 13.8, "plastic", 1850_000),
                new Yacht("Name8", "Manufacture5", 1967, 78.2, "wood", 4520_000)
            };
        System.out.println("The average price of selected yachts => " + myYachtClub.averagePriceOfYachts(yachtList));


    }
}
