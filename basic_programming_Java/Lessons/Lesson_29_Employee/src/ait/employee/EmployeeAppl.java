package ait.employee;

import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee[] firm = new Employee[5];
        firm[0] = new Manager(1000, "John", "Smith", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 160, 19_000, 0.1);
        firm[3] = new SalesManager(4000, "Rabindranate", "Agraval", 80, 20_000, 0.1);
//        firm[4] = new Employee(5000, "Ivan", "Balda", 160);

        printArray(firm);
        double total = totalSalary(firm);
        System.out.println("Total salary = " + total);
//        total = totalSales(firm);
        System.out.println("Total sales = " + totalSales(firm));
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

    public static double totalSalary(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].calcSalary();
            }
        }
        return sum;
    }

    public static double totalSales(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof SalesManager) {
                sum += ((SalesManager) employees[i]).getSalesValue();
            }
        }
        return sum;
    }
}
