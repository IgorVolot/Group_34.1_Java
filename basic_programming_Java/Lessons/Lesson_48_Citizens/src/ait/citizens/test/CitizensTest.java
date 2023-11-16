package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.model.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest {
    Citizens citizens;
    static final LocalDate now = LocalDate.now();
    Person p1;


//    @BeforeEach
//    void setUp() {  // так тоже правильно!!!!
//        citizens = new CitizensImpl();
//        citizens.add(new Person(1001, "name1", "lastName1", LocalDate.of(1965, 12, 27)));
//        citizens.add(new Person(1002, "name2", "lastName2", LocalDate.of(2013, 04, 12)));
//        citizens.add(new Person(1003, "name3", "lastName3", LocalDate.of(1984, 06, 14)));
//        citizens.add(new Person(1004, "name4", "lastName1", LocalDate.of(1967, 03, 8)));
//        citizens.add(new Person(1005, "name2", "lastName4", LocalDate.of(1991, 01, 25)));
//    }

    @BeforeEach
    void setUp() {
        p1 = new Person(1, "Peter", "Jackson", now.minusYears(23));
        citizens = new CitizensImpl(
                List.of(p1,
                        new Person(2, "John", "Smith", now.minusYears(20)),
                        new Person(3, "Mary", "Jackson", now.minusYears(20)),
                        new Person(4, "Rabindranate", "Anand", now.minusYears(25))));
    }

    @Test
    void testCitizensImplListOfPerson() {
        citizens = new CitizensImpl(List.of(p1, p1));
        assertEquals(1, citizens.size());
    }

    @Test
    void add() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(2, "John", "Smith", now.minusYears(20))));
        assertEquals(4, citizens.size());
        assertTrue(citizens.add(new Person(5, "John", "Smith", now.minusYears(20))));
        assertEquals(5, citizens.size());
    }

    @Test
    void remove() {
        assertFalse(citizens.remove(5));
        assertEquals(4, citizens.size());
        assertTrue(citizens.remove(2));
        assertEquals(3, citizens.size());
    }

    @Test
    void findById() {
        Person person = citizens.find(1);
        assertEquals(p1, person);
        assertEquals(1, person.getId());
        assertEquals("Peter", person.getFirstName());
        assertEquals("Jackson", person.getLastName());
        assertEquals(23, person.getAge());
        assertNull(citizens.find(5));
    }

    @Test
    void testFindByAges() {
        Iterable<Person> res = citizens.find(20, 23);
        List<Person> actual = new ArrayList<>();
        res.forEach(p -> actual.add(p));
        Collections.sort(actual);
        Iterable<Person> expected = List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(20)));
        assertIterableEquals(expected, actual);
    }

    @Test
    void testFindByLastName() {
        Iterable<Person> res = citizens.find("Jackson");
        List<Person> actual = new ArrayList<>();
        res.forEach(p -> actual.add(p));
        Collections.sort(actual);
        Iterable<Person> expected = List.of(
                new Person(1, "Peter", "Jackson", now.minusYears(23)),
                new Person(3, "Mary", "Jackson", now.minusYears(20)));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonSortedById() {
        Iterable<Person> actual = citizens.getAllPersonsSortedById();
        Iterable<Person> expected = List.of(p1,
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(20)),
                new Person(4, "Rabindranate", "Anand", now.minusYears(25)));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonsSortedByAge() {
        Iterable<Person> actual = citizens.getAllPersonsSortedByAge();
        Iterable<Person> expected = List.of(
                new Person(2, "John", "Smith", now.minusYears(20)),
                new Person(3, "Mary", "Jackson", now.minusYears(20)),
                p1, new Person(4, "Rabindranate", "Anand", now.minusYears(25)));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAllPersonSortedByLastName() {
        Iterable<Person> actual = citizens.getAllPersonsSortedByLastName();
        String name = "";
        for (Person person : actual) {
            assertTrue(person.getLastName().compareTo(name) >= 0);
            name = person.getLastName();
        }
    }

    @Test
    void size() {
        assertEquals(4, citizens.size());
    }
}