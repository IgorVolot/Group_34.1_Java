package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.model.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {
//    LocalDate today = LocalDate.now();
    Citizens citizens;
    Comparator<Person> comparator = (p1, p2) ->{
        int result = Integer.compare(p1.getId(),p2.getId());
        result = result !=0 ? result : p1.getLastName().compareTo(p2.getLastName());
        return result != 0 ? result : Integer.compare(p1.getAge(), p2.getAge());
    };

    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl();
        citizens.add(new Person(1001, "name1", "lastName1", LocalDate.of(1965, 12, 27)));
        citizens.add(new Person(1002, "name2", "lastName2", LocalDate.of(2013, 04, 12)));
        citizens.add(new Person(1003, "name3", "lastName3", LocalDate.of(1984, 06, 14)));
        citizens.add(new Person(1004, "name4", "lastName1", LocalDate.of(1967, 03, 8)));
        citizens.add(new Person(1005, "name2", "lastName4", LocalDate.of(1991, 01, 25)));
    }

    @Test
    void CitizenImpl() {
        List<Person> person = new ArrayList<>();
        person.add(new Person(1003, "name3", "lastName3", LocalDate.of(1984, 06, 14)));
        person.add(new Person(1004, "name4", "lastName1", LocalDate.of(1967, 03, 8)));
        person.add(new Person(1003, "name2", "lastName4", LocalDate.of(1991, 01, 25)));
        assertEquals(2, citizens.size());

    }

    @Test
    void add() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(1002, "name2", "lastName4", LocalDate.of(1991, 01, 25))));
        assertTrue(citizens.add(new Person(1006, "name6", "lastName2", LocalDate.of(2016, 11, 19))));
        assertEquals(6, citizens.size());
    }

    @Test
    void remove() {
        citizens.remove(1005);
        assertEquals(4, citizens.size());
        assertFalse(citizens.remove(1005));
        assertNull(citizens.find(1005));
    }

    @Test
    void findById() {
        assertNull(citizens.find(2222));
        assertEquals(citizens.find(1002), new Person(1002, "name2", "lastName2", LocalDate.of(2013, 11, 19)));
    }

    @Test
    void testFindByMinAndMaxAge() {
        int minAge = LocalDate.MAX.compareTo(LocalDate.now());
        int maxAge = LocalDate.MIN.compareTo(LocalDate.now());
        Iterable<Person> expected = citizens.find(minAge, maxAge);
        Iterable<Person> actual = new ArrayList<>(0);
        actual.iterator().next().getAge();
        assertIterableEquals( expected, actual);
    }

    @Test
    void testFindByLastName() {
        assertNull(citizens.find(null));
        Iterable<Person> expected = citizens.find("lastName1");
        Iterable<Person> actual = new ArrayList<>(0);
        actual.iterator().next().setLastName("lastName1");
        assertIterableEquals( expected, actual);
    }

    @Test
    void getAllPersonsSortedById() {
        assertEquals(citizens.getAllPersonsSortedById(), comparator);
    }

    @Test
    void getAllPersonsSortedByAge() {
        assertEquals(citizens.getAllPersonsSortedByAge(), comparator);
    }

    @Test
    void getAllPersonsSortedByLastName() {
        assertEquals(citizens.getAllPersonsSortedByLastName(), comparator);
    }

    @Test
    void size() {
        assertEquals(5, citizens.size());
    }
}