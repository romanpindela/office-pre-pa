package com.codecool.officeprepa.office;

import com.codecool.officeprepa.employee.Employee;
import com.codecool.officeprepa.employee.Leader;
import com.codecool.officeprepa.office.salary.EntrySalary;
import com.codecool.officeprepa.office.salary.SalaryCalculator;
import com.codecool.officeprepa.office.salary.SalaryCalculatorSunnyOffice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FactoryOffice {


    // creating instance of Office implementation
    public static Office getInstance ( List<Employee> employees,
                                       SalaryCalculator salaryCalculator,
                                       Map<String, Leader> groups,
                                       String officeName, String officeType){

        return switch(officeType.toLowerCase()){
            case "sunnyoffice" -> new OfficeImplSunnyOffice(employees,salaryCalculator,groups,officeName);
            default -> throw new IllegalArgumentException("Wrong input for officeType");
        };
    }

    public static Office getInstance(String officeType) {

        // Creating dependencies :
        // creating employees structure
        List<Employee> employees = new ArrayList<>();
        // creating groups and officeName
        Map<String, Leader> groups = new HashMap<>();
        String officeName = officeType;

        // create salaryCalculator
        List<EntrySalary> salaryCalculatorEntries = new ArrayList<EntrySalary>();
        SalaryCalculator salaryCalculator = new SalaryCalculatorSunnyOffice(salaryCalculatorEntries, employees, groups);


        return switch(officeType.toLowerCase()){
            case "sunnyoffice" -> new OfficeImplSunnyOffice(employees,salaryCalculator,groups,officeName);
            default -> throw new IllegalArgumentException("Wrong input for officeType");
        };    }



}
