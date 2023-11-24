package ait.citizens.dao;

import ait.citizens.model.Person;

import java.time.LocalDate;
import java.util.*;

public class CitizensImpl implements Citizens {
    private TreeSet<Person> idList;
    private TreeSet<Person> lastNameList;
    private TreeSet<Person> ageList;
    private static Comparator<Person> ageComparator = (p1, p2) -> {
        int res = Integer.compare(p1.getAge(), p2.getAge());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };
    private static Comparator<Person> lastNameComparator = (p1, p2) -> {
        int res = p1.getLastName().compareTo(p2.getLastName());
        return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
    };

    // O(log(n))
    public CitizensImpl() {
        idList = new TreeSet<>();
        lastNameList = new TreeSet<>(lastNameComparator);
        ageList = new TreeSet<>(ageComparator);
    }

    // O(1)
    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    // O(log(n))
    @Override
    public boolean add(Person person) {
        if (person == null) {
            return false;
        }
        idList.add(person);

        ageList.add(person);

        lastNameList.add(person);
        return true;
    }

    // O(log(n))
    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if (victim == null) {
            return false;
        }
        idList.remove(victim);
        ageList.remove(victim);
        lastNameList.remove(victim);
        return true;
    }

    // O(log(n))
    @Override
    public Person find(int id) {
        Person pattern = new Person(id, null, null, null);
        Person person = idList.ceiling(pattern);
        return pattern.equals(person) ? person : null;
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        Person p1 = new Person(Integer.MIN_VALUE, null, null, now.minusYears(minAge));
        Person p2 = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));
        return ageList.subSet(ageList.floor(p2), true, ageList.ceiling(p1), true); // O(1)
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person p1 = new Person(Integer.MIN_VALUE, null, lastName, null);
        Person p2 = new Person(Integer.MAX_VALUE, null, lastName, null);
        return lastNameList.subSet(lastNameList.ceiling(p1), true, lastNameList.floor(p2), true);
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;
    }

    // O(1)
    @Override
    public int size() {
        return idList.size();
    }
}
