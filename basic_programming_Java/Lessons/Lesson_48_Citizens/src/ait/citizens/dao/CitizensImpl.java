package ait.citizens.dao;

import ait.citizens.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens {
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static Comparator<Person> lastNameComparator = (p1 , p2) -> p1.getLastName().compareTo(p2.getLastName());
    private static Comparator<Person> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());

    public CitizensImpl(){}

    public CitizensImpl(List<Person> citizens){
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
