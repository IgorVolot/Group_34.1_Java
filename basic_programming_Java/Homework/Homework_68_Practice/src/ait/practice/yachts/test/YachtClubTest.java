package ait.practice.yachts.test;

import ait.practice.yachts.dao.YachtClub;
import ait.practice.yachts.dao.YachtClubImpl;
import ait.practice.yachts.model.Yacht;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class YachtClubTest {

    YachtClub yachtClub;
    Yacht[] yachts;
//    Comparator<Yacht> costComparator = (y1, y2) -> {Double.compare(y1.getCosts(), y2.getCosts());
    Comparator<Yacht> materialComparator = (yacht1, yacht2) -> yacht1.getMaterial().compareTo(yacht2.getMaterial());


    @BeforeEach
    void setUp() {
        yachtClub = new YachtClubImpl(10);
        yachts = new Yacht[9];
        yachts[0] = new Yacht("Name1", "Manufacture1", 2012, 25.1, "plastic", 2850_000);
        yachts[1] = new Yacht("Name2", "Manufacture2", 2010, 34.3, "plastic", 1230_000);
        yachts[2] = new Yacht("Name3", "Manufacture4", 2018, 17.5, "metal", 1870_000);
        yachts[3] = new Yacht("Name4", "Manufacture5", 1978, 27.2, "wood", 380_000);
        yachts[4] = new Yacht("Name5", "Manufacture3", 1994, 13.8, "plastic", 1850_000);
        yachts[5] = new Yacht("Name6", "Manufacture2", 2020, 28.4, "metal", 850_000);
        yachts[6] = new Yacht("Name7", "Manufacture1", 2003, 43.6, "plastic", 2290_000);
        yachts[7] = new Yacht("Name8", "Manufacture5", 1967, 78.2, "wood", 4520_000);
        yachts[8] = new Yacht("Name9", "Manufacture1", 2022, 42.4, "plastic", 4180_000);
        for (int i = 0; i < yachts.length; i++) {
            yachtClub.addYacht(yachts[i]);
        }
    }

    @Test
    void addYacht() {
        try {
            yachtClub.addYacht(null);
        } catch (RuntimeException e) {
            System.out.println(e.toString());
            return;
        }
        assertFalse(yachtClub.addYacht(yachts[1]));
        Yacht yacht = new Yacht("Name11", "Manufacture5", 1989, 37.7, "wood", 1180_000);
        assertTrue(yachtClub.addYacht(yacht));
        assertEquals(10, yachtClub.quantity());
        yacht = new Yacht("Name23", "Manufacture2", 2012, 30.3, "plastic", 930_000);
        assertFalse(yachtClub.addYacht(yacht));
    }

    @Test
    void findYacht() {
        assertEquals(yachts[3], yachtClub.findYacht("Name4"));
        assertNull(yachtClub.findYacht("BlueStar"));
    }

    @Test
    void quantity() {
        assertEquals(9, yachtClub.quantity());
    }

    @Test
    void printYachts() {
        yachtClub.printYachts();
    }

    @Test
    void findYachtByMaterial() {
        Yacht[] actual = yachtClub.findYachtByMaterial("wood");
        Arrays.sort(actual, materialComparator);
        Yacht[] expected = {yachts[3], yachts[7]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findYachtByPriceGreaterThan() {
        Yacht[] actual = yachtClub.findYachtByPriceGreaterThan(2_500_000.);
        Arrays.sort(actual);
        Yacht[] expected = {yachts[0], yachts[7], yachts[8]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findYachtByManufactureYear() {
        Yacht[] actual = yachtClub.findYachtByManufactureYear(2015, 2022);
        Arrays.sort(actual);
        Yacht[] expected = {yachts[2], yachts[5]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortYachtByPrice() {
        Yacht[] actual = yachtClub.sortYachtByPrice();
        Arrays.sort(actual, (y1, y2) -> Double.compare(y2.getCosts(), y1.getCosts()));
        Yacht[] expected = {yachts[7], yachts[8], yachts[0], yachts[6], yachts[2], yachts[4], yachts[1], yachts[5], yachts[3]};
        assertArrayEquals(expected, actual);

    }

    @Test
    void averagePriceOfYachts() {
        double sum = 0;
        for (int i = 0; i < yachts.length; i++) {
            sum += yachts[i].getCosts();
        }
        assertEquals(2_224_444.4444444445,sum / yachts.length);
    }
}