package ait.charstream;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeesDataAppl {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String str = br.readLine();
//            System.out.println(str);
            String[] cells = str.split(";");
            printCells(cells);
            /*
            1) Total salary
            2) Total employees
            3) Average salary
            4) Average age
             */

            double salary = 0;
            double totalSalary = 0.;
            int totalEmployees = 0;
            int age = 0;

            str = br.readLine();
            while (str != null) {
                totalEmployees++;
                cells = str.split(";");
                salary += Double.parseDouble(cells[2]);
                age += (int) ChronoUnit.YEARS.between(LocalDate.parse(cells[3]),LocalDate.now());
                printCells(cells);
                str = br.readLine();
            }
            System.out.println("Total salary: " + salary);
            System.out.println("Total employees: " + totalEmployees);
            System.out.println("Average salary: " + salary/totalEmployees);
            System.out.println("Average age: " + 1.* age/totalEmployees);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void printCells(String[] cells) {
        for (String s : cells) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }
}
