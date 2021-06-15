package com.codecool.officeprepa;

import com.codecool.officeprepa.office.FactoryOffice;
import com.codecool.officeprepa.office.Office;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class OfficeApplication {
    private static Office sunnyOfficetest;

    public static void main ( String[] args ) {

        String userInput;
        Scanner scanner = new Scanner(System.in);
        do {
            menu();
            userInput = scanner.nextLine();
            switch (userInput){
                case "1": createTestSunnyOffice(); break;
                case "2": printSunnyOfficeListEmployes(); break;
                case "3": printSunnyOfficeSalariesInMonth(); break;
                case "4": printSunnyOfficeSalariesInYearByEmployeeMonth(); break;
            }

        } while (!userInput.equals("q"));

    }

    private static void printSunnyOfficeSalariesInYearByEmployeeMonth () {

    }

    private static void printSunnyOfficeSalariesInMonth () {

    }

    private static void printSunnyOfficeListEmployes () {

    }

    private static void createTestSunnyOffice () {
        sunnyOfficetest = FactoryOffice.createOffice("Sunny Office");

    }

    private static void menu () {
        System.out.println("Menu:");
        System.out.println("1. Create SunnyOffice for test");
        System.out.println("2. Print Salaries in month by Employee");
        System.out.println("3. Print Salaries in year by Employee and month");
        System.out.println("q - quit program");
    }
}
