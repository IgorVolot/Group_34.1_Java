package ait.practiice.company_stream.dao;

import ait.practiice.company_stream.model.Employee;
import ait.practiice.company_stream.model.SalesManager;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class CompanySetImpl implements Company{
    private Set<Employee> employees;
    private int capacity;

    public CompanySetImpl(int capacity) {
        this.capacity = capacity;
        employees = new HashSet<>();
    }

    // O(1)
    @Override
    public boolean addEmployee(Employee employee) {
//        if (employee == null) {
//            throw new RuntimeException("null");
//        }
        if (capacity == employees.size()) {
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
//        for (Employee employee : employees) {
//            if (employee.getId() == id) {
//                return employee;
//            }
//        }
//        return null;
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // O(n)
    @Override
    public double totalSalary() {
//        double res = 0;
//        for (Employee employee : employees) {
//            res += employee.calcSalary();
//        }
//        return res;
        return employees.stream()
                .mapToDouble(e -> e.calcSalary())
                .sum();
    }

    @Override
    public double avgSalary() {
        return totalSalary()/ employees.size();
    }

    // O(1)
    @Override
    public int quantity() {
        return employees.size();
    }

    // O(n)
    @Override
    public double totalSales() {
//        double res = 0;
//        for (Employee employee : employees) {
//            if (employee instanceof SalesManager) {
//                SalesManager salesManager = (SalesManager) employee;
//                res += salesManager.getSalesValue();
//            }
//        }
//        return res;
        return employees.stream()
                .filter(e -> e instanceof SalesManager)
                .mapToDouble(e -> ((SalesManager) e).getSalesValue())
                .sum();
    }

    // O(n)
    @Override
    public void printEmployees() {
        employees.forEach(e -> System.out.println(e));
    }

    // O(n)
    private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
//        List<Employee> res = new ArrayList<>();
//        for (Employee employee : employees) {
//            if (predicate.test(employee)) {
//                res.add(employee);
//            }
//        }
//        return res.toArray(new Employee[0]);
        return employees.stream()
                .filter(predicate)
                .toArray(Employee[]::new);
    }
}
