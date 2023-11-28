package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CompanyListImpl implements Company {
    private List<Employee> employees;
    private int capacity;

    public CompanyListImpl(int capacity) {
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    // O(n)
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null) {
            throw new RuntimeException("Employee cannot be null");
        }
        if (capacity == employees.size() || employees.contains(employee)) {
            return false;
        }
        return employees.add(employee);
    }

    // O(n)
    @Override
    public Employee removeEmployee(int id) {
        Employee employee = findEmployee(id);
        employees.remove(employee);
        return employee;
    }

    // O(n)
    @Override
    public Employee findEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findAny()
                .orElse(null);
    }

    // O(n)
    @Override
    public double totalSalary() {
        return employees.stream()
//                .mapToDouble(e -> e.calcSalary())
                .mapToDouble(Employee::calcSalary)
                .sum();
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    // O(n)
    @Override
    public double totalSales() {
        return employees.stream()
                .filter(e -> e instanceof SalesManager)
                .map(e -> (SalesManager) e)
                .mapToDouble(SalesManager::getSalesValue)
//                .summaryStatistics().getSum()
                .sum();
    }

    // O(n)
    @Override
    public void printEmployees() {
        employees.forEach(System.out::println);
    }

    // O(n)
    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return findEmployeesByPredicate(e -> e.getHours() >= hours);
    }

    // O(n)
    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return findEmployeesByPredicate(e -> e.calcSalary() >= minSalary && e.calcSalary() < maxSalary);
    }

    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .toArray(Employee[]::new);
    }
}
