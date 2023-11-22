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
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // O(n)
    @Override
    public double totalSalary() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.calcSalary();
        }
        return total;
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    // O(n)
    @Override
    public double totalSales() {
        double total = 0;
        for (Employee employee : employees) {
            if (employee instanceof SalesManager) {
                SalesManager salesManager = (SalesManager) employee;
                total += salesManager.getSalesValue();
            }
        }
        return total;
    }

    // O(n)
    @Override
    public void printEmployees() {
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
        employees.forEach(e -> System.out.println(e)); // JAVA 8.0
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
    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate){
        List<Employee> res = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)){
                res.add(employee);
            }
        }
        return res.toArray(new Employee[0]);
    }
}
