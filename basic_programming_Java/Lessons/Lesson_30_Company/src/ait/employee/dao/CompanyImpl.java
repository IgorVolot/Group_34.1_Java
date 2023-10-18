package ait.employee.dao;

import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee fired = employees[i];
                if (employees[i] == employees[size - 1]){
                    employees[size - 1] = null;
                }
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return fired;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += employees[i].calcSalary();
        }
        return total;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double avgSalary() {
        return totalSalary() / size;
    }

    @Override
    public double totalSales() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof SalesManager) {
                total += ((SalesManager) employees[i]).getSalesValue();
            }
        }
        return total;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
