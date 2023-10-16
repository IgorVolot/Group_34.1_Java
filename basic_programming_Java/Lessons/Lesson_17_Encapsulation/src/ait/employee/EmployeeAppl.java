package ait.employee;

import ait.employee.model.Employee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "John", "Smith", 3000);
        employee1.display();
        Employee employee2 = new Employee(2, "Peter", "Jackson", 3500);

//        employee1.id = 1;
//        employee1.firstName = "John";
//        employee1.lastName = "Smith";
//        employee1.salary = 3000;

//        employee2.id = 2;
//        employee2.firstName = "Peter";
//        employee2.lastName = "Jackson";
//        employee2.salary = 3500;

        double totalSalary = employee1.getSalary() + employee2.getSalary();
        System.out.println("Total salary = " + totalSalary);
        employee1.setSalary(2000);
        employee1.display();
        employee2.display();

//        Employee employee3 = new Employee();
//        employee3.display();
//
//        Employee employee4 = null;
//        employee4.display();
    }
}
