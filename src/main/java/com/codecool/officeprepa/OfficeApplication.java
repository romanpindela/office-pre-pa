package com.codecool.officeprepa;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.FactoryEmployee;
import com.codecool.officeprepa.office.FactoryOffice;
import com.codecool.officeprepa.office.Office;
import com.codecool.officeprepa.office.PrintOffice;
import com.codecool.officeprepa.office.PrintOfficeImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class OfficeApplication {
    private static Office sunnyOfficetest;

    public static void main ( String[] args ) {

        createTestSunnyOffice();

        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            userInput = scanner.nextLine();
            switch (userInput){
                case "1": printSunnyOfficeListEmployes(); break;
                case "2": printSunnyOfficeSalariesInMonth(); break;
                case "3": printSunnyOfficeSalariesInYearByEmployeeMonth(); break;
            }

        } while (!userInput.equals("q"));

    }

    private static void printSunnyOfficeSalariesInYearByEmployeeMonth () {


    }

    private static void printSunnyOfficeSalariesInMonth () {

    }

    private static void printSunnyOfficeListEmployes () {
        PrintOffice printOffice = new PrintOfficeImpl();
        System.out.println(printOffice.printEmployees(sunnyOfficetest));
        System.out.println(printOffice.printLeadersGroupsEmployees(sunnyOfficetest));
    }

    private static void createTestSunnyOffice () {
        // creating office
        sunnyOfficetest = FactoryOffice.getInstance("sunnyoffice");


        // creating employees
        List<Employee> employees;
        employees = List.of(
                FactoryEmployee.getInstance("leader", "Tomek", "BlueTeam", BigDecimal.valueOf(1800)),
                FactoryEmployee.getInstance("leader", "Romek", "YellowTeam", BigDecimal.valueOf(1800)),
                FactoryEmployee.getInstance("officeworker", "Kasia", "YellowTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("officeworker", "Basia", "YellowTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("officeworker", "Barbara", "YellowTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("officeworker", "Franek", "YellowTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("salesperson", "Maciek", "YellowTeam", BigDecimal.valueOf(1700)),
                FactoryEmployee.getInstance("salesperson", "Marzena", "YellowTeam", BigDecimal.valueOf(1700)),
                FactoryEmployee.getInstance("salesperson", "Rafał", "BlueTeam", BigDecimal.valueOf(1700)),
                FactoryEmployee.getInstance("salesperson", "Michał", "BlueTeam", BigDecimal.valueOf(1700)),
                FactoryEmployee.getInstance("officeworker", "Kinga", "BlueTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("officeworker", "Anna", "BlueTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("officeworker", "Monika", "BlueTeam", BigDecimal.valueOf(1250)),
                FactoryEmployee.getInstance("officeworker", "Agata", "BlueTeam", BigDecimal.valueOf(1250))
                );

        for (Employee e : employees){
            sunnyOfficetest.hireEmployee(e);
        }
        sunnyOfficetest.getEmployees();

    }

    private static void menu () {
        System.out.println("Menu:");
        System.out.println("1. Print sunnyOffice list of employees");
        System.out.println("2. Print Salaries in month by Employee");
        System.out.println("3. Print Salaries in year by Employee and month");
        System.out.println("q - quit program");
    }
}
