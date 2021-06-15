package com.codecool.officeprepa;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.FactoryEmployee;
import com.codecool.officeprepa.office.FactoryOffice;
import com.codecool.officeprepa.office.Office;
import com.codecool.officeprepa.office.PrintOffice;
import com.codecool.officeprepa.office.PrintOfficeImpl;
import com.codecool.officeprepa.office.salary.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class OfficeApplication {
    private static Office sunnyOfficetest;
    private static List<Employee> employees;

    public static void main ( String[] args ) {

        createTestSunnyOffice();

        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            userInput = scanner.nextLine();
            switch (userInput){
                case "1": printSunnyOfficeListEmployes(); break;
                case "2": printYearSalaryByEmployees(); break;
                case "3": printYearSalaryOneEmployee(); break;
            }

        } while (!userInput.equals("q"));

    }

    private static void printYearSalaryOneEmployee () {
        PrintSalaryOffice printerSalary = new PrintSalaryOfficeImpl();
        System.out.println(
                printerSalary.printYearSalaryOneEmployee(sunnyOfficetest.getSalaryCalculator(), LocalDate.parse("2021-02-01"),employees.get(0))
        );
        System.out.println(
                printerSalary.printYearSalaryOneEmployee(sunnyOfficetest.getSalaryCalculator(), LocalDate.parse("2021-02-01"),employees.get(3))
        );

    }

    private static void printYearSalaryByEmployees () {
        PrintSalaryOffice printerSalary = new PrintSalaryOfficeImpl();
        System.out.println(
                printerSalary.printYearSalaryByEmployees(sunnyOfficetest.getSalaryCalculator(), LocalDate.parse("2021-02-01"))
        );
    }

    private static void printSunnyOfficeListEmployes () {
        PrintOffice printOffice = new PrintOfficeImpl();
        System.out.println(printOffice.printEmployees(sunnyOfficetest));
        System.out.println(printOffice.printLeadersGroupsEmployees(sunnyOfficetest));
    }
    private static void menu () {
        System.out.println("Menu:");
        System.out.println("1. Print sunnyOffice list of employees");
        System.out.println("2. Print year salaries by All Employees");
        System.out.println("3. Print year salaries by One Employee");
        System.out.println("q - quit program");
    }
    private static void createTestSunnyOffice () {
        // creating office
        sunnyOfficetest = FactoryOffice.getInstance("sunnyoffice");


        // creating employees
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

        // hiring employees in sunnyOffice
        for (Employee e : employees){
            sunnyOfficetest.hireEmployee(e);
        }

        SalaryCalculator salaryCalculator = sunnyOfficetest.getSalaryCalculator();

//                new SalaryCalculatorSunnyOffice(
//                new ArrayList<EntrySalary>(), employees, sunnyOfficetest.getGroups()
//        );
        sunnyOfficetest.getSalaryCalculator().getYearSalaryByEmployeesEntries(LocalDate.parse("2021-04-10"));

        List<List<EntrySalary>> salaryEntries = List.of(
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-01-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-02-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-03-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-04-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-05-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-06-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-07-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-08-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-09-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-10-10")),
            salaryCalculator.calculateSalaryForGivenMonth(LocalDate.parse("2021-11-10"))
        );

        for (List<EntrySalary> salaryEntry : salaryEntries){
            salaryCalculator.addCalculatedSalaryOfMonth(salaryEntry);
        }


    }


}
