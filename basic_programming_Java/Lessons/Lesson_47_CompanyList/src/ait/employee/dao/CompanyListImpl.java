package ait.employee.dao;

import ait.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyListImpl implements Company {
    private List<Employee> employees;
    private int capacity;

    public CompanyListImpl(int capacity) {
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null){
            throw new RuntimeException("Employee cannot be null");
        }
        if (capacity == employees.size() || employees.contains(employee)) {
            return false;
        }
        return employees.add(employee);
    }

    @Override
    public Employee removeEmployee(int id) {

        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        return 0;
    }

    @Override
    public int quantity() {
        return employees.size();
    }

    @Override
    public double avgSalary() {
        return 0;
    }

    @Override
    public double totalSales() {
        return 0;
    }

    @Override
    public void printEmployees() {

    }

    @Override
    public Employee[] findEmployeesHoursGreaterThan(int hours) {
        return new Employee[0];
    }

    @Override
    public Employee[] findEmployeesSalaryRange(int minSalary, int maxSalary) {
        return new Employee[0];
    }
}
